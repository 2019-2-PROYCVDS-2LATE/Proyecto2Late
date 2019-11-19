/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Prestamo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Recurso;
import java.util.Date;
import java.util.List;
/**
 *
 * @author 2LateTeam
 */
public interface ServiciosBiblioteca {
    /**
     * Registra un recurso
     * @throws ServiciosBibliotecaException 
     */
    public void registrarRecurso(Recurso rec) throws ServiciosBibliotecaException;
    
    /**
     * Modifica los valores de un recurso
     * @throws ServiciosBibliotecaException 
     */
    public void modificarRecurso(String id, String est) throws ServiciosBibliotecaException;
    
    /**
     * Consulta un recurso
     * @return el recurso a consultar
     * @throws ServiciosBibliotecaException 
     */
    public Recurso consultarRecurso(int id) throws ServiciosBibliotecaException;

    /**
     * Consulta todos los recursos
     * @return una lista con todos los recursos
     * @throws ServiciosBibliotecaException 
     */
    public List<Recurso> consultarRecursos() throws ServiciosBibliotecaException;

    /**
     * Registrar un prestamo
     * @throws ServiciosBibliotecaException
     *
     */
    public void registrarPrestamo(Prestamo prestamo) throws ServiciosBibliotecaException;

    /**
     * Consulta un prestamos
     * @return los prestamos realizados
     * @throws ServiciosBibliotecaException
     */
    public List<Prestamo> consultarPrestamos() throws ServiciosBibliotecaException;

    /**
     * Consultar todos las reservas relaizadas por  el usuario logueado
     * @return los prestamos realizados por el usuario
     * @throws ServiciosBibliotecaException
     */
    public List<Prestamo> consultarPrestamosUsuario(String correoUsuario) throws ServiciosBibliotecaException;

    /**
     *
     * @param usuario
     * @throws ServiciosBibliotecaException
     */
    public void registrarUsuario(Usuario usuario) throws ServiciosBibliotecaException;
}
