package com.conexion.bd.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.conexion.bd.modelo.Videos;

public interface RepositorioVideos extends JpaRepository<Videos,Integer>{
    @Query(value = "Select * from public.fn_crud_video(:vaccion, :c_id, :d_nombre, :d_descripcion, :d_url, :n_likes, :n_dislikes);", nativeQuery = true)
    List<Videos> crudVideos(
        @Param("vaccion") String accion,
        @Param("c_id") Integer id,
        @Param("d_nombre") String nombre,
        @Param("d_descripcion") String descripcion,
        @Param("d_url") String url_video,
        @Param("n_likes") Integer cant_likes,
        @Param("n_dislikes") Integer cant_dislikes

    );

}
