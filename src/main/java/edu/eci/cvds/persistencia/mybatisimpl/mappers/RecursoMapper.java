/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Recurso;
/**
 *
 * @author 2152972
 */
public interface RecursoMapper {
    public Recurso consultarRecurso(@Param("id") int id);

    public void registrarRecurso(@Param("rec") Recurso rec);
    
    public void modificarRecurso(@Param("id") String id, @Param("nom") String nom, @Param("ubi") String ubi, @Param("cap") int cap, @Param("est") String est);

    public List<Recurso> consultarRecursos();
}
