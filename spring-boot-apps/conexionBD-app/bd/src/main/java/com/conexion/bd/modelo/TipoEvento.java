package com.conexion.bd.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class TipoEvento {
    @Id
    @Column (name = "id")
    private Integer id;

    @Column (name = "nombre")
    private String nombre;

}
