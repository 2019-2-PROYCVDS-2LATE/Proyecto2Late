/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia;
import java.util.Date;
import java.util.List;
import edu.eci.cvds.samples.entities.Prestamo;

/**
 *
 * @author 2LateTeam
 */
public interface PrestamoDAO {

    public void registrarPrestamo( Prestamo prestamo) throws PersistenceException;
    
    public Prestamo consultarPrestamo( int id) throws PersistenceException;

    public void modificarDuracionPrestamo( int id, String duracion) throws PersistenceException;
    
    public void modificarFechaPrestamo( int id,  String date) throws PersistenceException;
    
    public List<Prestamo> consultarPrestamos() throws PersistenceException;

    public List<Prestamo> consultarPrestamosUsuario(String correoUsuario) throws PersistenceException;
}
