package com.conexion.bd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.conexion.bd.modelo.TipoEvento;

public interface Repositorio extends JpaRepository<TipoEvento,Integer>{
    @Query(value = "Select * from public.fn_crud_tipoevento(:v_id, :v_nombre, :vaccion);", nativeQuery = true)
    List<TipoEvento> crudTipoEvento(
        @Param("v_id") Integer id,
        @Param("v_nombre") String nombre,
        @Param("vaccion") String accion
    );

}
