/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Prestamo;

import java.util.Date;

/**
 *
 * @author 2LateTeam
 */
public interface PrestamoMapper {
    public void registrarPrestamo(@Param("prestamo") Prestamo prestamo);
    
    public Prestamo consultarPrestamo(@Param("id") int id);
    
    public void modificarDuracionPrestamo(@Param("id") int id, @Param("duracion") String duracion);
    
    public void modificarFechaPrestamo(@Param("id") int id, @Param("fecha") Date date);
    
    public List<Prestamo> consultarPrestamos();

}
