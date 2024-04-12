package com.conexion.bd.config.eureka;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.discovery.EurekaClient;

@Configuration
public class EurekaMultiInstanceConfig implements ApplicationContextAware {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private int serverPort;

    @Value("${eureka.client.serviceUrl.additionalZones:}") // Valor importado desde application.properties, vacío por defecto.
    private String[] additionalZones;

    private Map<String, EurekaClient> clients = new HashMap<>(); // Se inicializa mapa que contendrá todas las intancias a donde se realizará el registro.

    @Autowired // Inyección de dependencias, contexto configurable de aplicación.
    private ConfigurableApplicationContext applicationContext;

    // Generación aleatoria de un ID de 16 caracteres de largo.
    private String getRandomID() {
        RandomIdGenerator random = new RandomIdGenerator(16);

        return random.nextString();
    }

    @Override
     // Utilización de un contexto configurable de aplicación para permitir mayor control sobre el ciclo de vida de la misma.
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }
    
    @Bean
    // Configuración para la instanciación de clientes de Eureka.
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        EurekaInstanceConfigBean eurekaConfigBean = new EurekaInstanceConfigBean(inetUtils); // Crea nueva instancia del bean de config.
        eurekaConfigBean.setInstanceId(appName + ":" + getRandomID()); // Asigna ID de instancia.
        eurekaConfigBean.setNonSecurePort(serverPort); // Y puerto por el que se comunicará el microservicio.
        
        return eurekaConfigBean;
    }

    @Bean
    // Método para registro a más de un servidor en Eureka.
    public Map<String, EurekaClient> registerToAdditionalEurekaServers(ApplicationInfoManager manager, @Autowired(required = false) HealthCheckHandler healthCheckHandler) {

        for (String host : additionalZones) { // Para cada elemento del arreglo que contiene las instancias adicionales
            EurekaClient client = new CloudEurekaClient( // Crea un cliente de Eureka
                manager,
                new SimpleEurekaClientConfig(host.trim(), "defaultZone", "us-east-1"),
                null,
                this.applicationContext);
            client.registerHealthCheck(healthCheckHandler); // Registra para Health Check
            String clientName = host + "_Client"; // Asigna un nombre único para el cliente
            clients.put(clientName, client); // Y añade al mapa inicializado anteriormente.
        }

        return clients;
    }

    @PreDestroy // La directiva indica que éste método se ejecuta una sóla vez, justo antes de que Spring destruya el bean Application.
    // Método para anular el registro de nuestra aplicación de los servidores adicionales de Eureka.
    public void unregisterFromAllDiscoveryServers() { // Obtener el mapa de las intancias adicionales de Eureka.
        this.clients.forEach((k, v) -> v.shutdown()); // Dados todos los elementos del mapa, apagar instancias de Eureka.
    }
}