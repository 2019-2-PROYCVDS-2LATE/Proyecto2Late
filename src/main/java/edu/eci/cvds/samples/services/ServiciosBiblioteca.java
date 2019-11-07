/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Recurso;
import java.util.Date;
import java.util.List;
/**
 *
 * @author 2152972
 */
public interface ServiciosBiblioteca {
    /**
     * Registra un recurso
     * @throws ServiciosBibliotecaException 
     */
    void registrarRecurso(Recurso rec) throws ServiciosBibliotecaException;
    
    /**
     * Modifica los valores de un recurso
     * @throws ServiciosBibliotecaException 
     */
    void modificarRecurso(String id, String est) throws ServiciosBibliotecaException;
    
    /**
     * Consulta un recurso
     * @return el recurso a consultar
     * @throws ServiciosBibliotecaException 
     */
    Recurso consultarRecurso(int id) throws ServiciosBibliotecaException;

    /**
     * Consulta todos los recursos
     * @return una lista con todos los recursos
     * @throws ServiciosBibliotecaException 
     */
    List<Recurso> consultarRecursos() throws ServiciosBibliotecaException;
}
