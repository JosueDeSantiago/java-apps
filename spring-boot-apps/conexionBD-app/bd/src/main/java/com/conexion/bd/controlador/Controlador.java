package com.conexion.bd.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexion.bd.modelo.TipoEvento;
import com.conexion.bd.modelo.Videos;
import com.conexion.bd.repositorio.Repositorio;
import com.conexion.bd.repositorio.RepositorioVideos;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@CrossOrigin("*")
public class Controlador {
    //INYECCIÓN DE DEPENDENCIAS CON LOS REPOSITORIOS
    @Autowired
    Repositorio funcionesRepositorio;

    @Autowired
    RepositorioVideos funcionesRepositorioVideos;

    @GetMapping(path= "/tipoevento")
    public List<TipoEvento> crudTipoEvento(
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = true) String accion){
            
            List<TipoEvento> resultado = funcionesRepositorio.crudTipoEvento(id, nombre, accion);

            return resultado;
    }

    @GetMapping(path= "/videos")
    @Operation(summary= "Actualiza los datos del catalogo de Videos", description = "Ejecución de fn_crud_video")
    public List<Videos> crudVideos(
        @RequestParam(required = true) String accion,
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String descripcion,
        @RequestParam(required = false) String url_video,
        @RequestParam(required = false) Integer cant_likes,
        @RequestParam(required = false) Integer cant_dislikes){
            
            List<Videos> resultado = funcionesRepositorioVideos.crudVideos(accion, id, nombre, descripcion, url_video, cant_likes, cant_dislikes);

            if (resultado.isEmpty()) {
                log.info("* [VIDEO]: No se ejecuto de la funcion fn_crud_video");
            } else {
                log.info("* [VIDEO]: Ejecucion satisfactoria fn_crud_video");
            }

            return resultado;
    }
}
    

