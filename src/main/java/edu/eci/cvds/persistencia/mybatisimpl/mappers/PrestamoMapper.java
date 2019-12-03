/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Prestamo;

import java.util.Date;

/**
 *
 * @author 2LateTeam
 */
public interface PrestamoMapper {
    public void registrarPrestamo(@Param("pres") Prestamo pres);

    public Prestamo consultarPrestamo(@Param("id") int id);

    public void modificarDuracionPrestamo(@Param("id") int id, @Param("dur") String dur);

    public void modificarFechaPrestamo(@Param("id") int id, @Param("date") String date);

    public List<Prestamo> consultarPrestamos();

    public List<Prestamo> consultarPrestamosUsuario(@Param("correo") String correoUsuario);

    public List<Prestamo> consultarPrestamosRecurso(@Param("rec")Recurso recurso);

    public void cancelarPrestamo(@Param("correo") String correo,@Param("id") int id);

}
