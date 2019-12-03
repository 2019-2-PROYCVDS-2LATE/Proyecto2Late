    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.PrestamoDAO;
import edu.eci.cvds.persistencia.RecursoDAO;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Prestamo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import java.util.List;
/**
 *
 * @author 2LateTeam
 */
public class ServiciosBibliotecaImpl implements ServiciosBiblioteca{
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private UsuarioDAO UsuarioDAO;
    @Inject
    private PrestamoDAO prestamoDAO;

    @Override
    public void registrarRecurso(Recurso cli) throws ServiciosBibliotecaException {
        try {

            recursoDAO.registrarRecurso(cli);

        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al guardar el recurso " + cli.toString(), e);
        }

    }
    
    @Override
    public void modificarRecurso(String id, String est) throws ServiciosBibliotecaException{
        try{
            recursoDAO.modificarRecurso(id, est);
        }catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al modifica el recurso " + id, e);
        }
        
    }

    @Override
    public Recurso consultarRecurso(int id) throws ServiciosBibliotecaException {
        Recurso ans = null;
        try {
            ans = recursoDAO.consultarRecurso(id);
        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al consultar el recurso " + id, e);
        }
        return ans;
    }

    @Override
    public List<Recurso> consultarRecursos() throws ServiciosBibliotecaException {
        List<Recurso> ans= null;
        try {
            ans = recursoDAO.consultarRecursos();
        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al consultar los recursos", e);
        }
        return ans;
    }
    @Override
    public void registrarPrestamo(Prestamo pres) throws ServiciosBibliotecaException{
        try {
            prestamoDAO.registrarPrestamo(pres);

        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al registrar la reserva " + pres.toString(), e);
        }
    }

    @Override
    public List<Prestamo> consultarPrestamos() throws ServiciosBibliotecaException {
        List<Prestamo> ans= null;
        try {
            ans = prestamoDAO.consultarPrestamos();
        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al consultar las reservas.", e);
        }
        return ans;
    }

    @Override
    public List<Prestamo> consultarPrestamosUsuario(String correoUsuario) throws ServiciosBibliotecaException {
        List<Prestamo> prestamosUsuario = null;
        try{
            prestamosUsuario =  prestamoDAO.consultarPrestamosUsuario(correoUsuario);
        }
        catch (PersistenceException e){
            throw new ServiciosBibliotecaException("Error al consultar las reservas del usuario.",e);
        }
        return prestamosUsuario;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws ServiciosBibliotecaException {
        try{
            UsuarioDAO.save(usuario);
        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al registrar el usuario " + usuario.toString(), e);
        }
    }

    @Override
    public Usuario consultarUsuario(String correo) throws ServiciosBibliotecaException {
        try{
            return UsuarioDAO.consultarUsuario(correo);

        } catch (PersistenceException e ){
            throw new ServiciosBibliotecaException("Error al consultar el usuario "+correo,e);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ServiciosBibliotecaException {
        List<Usuario> usuarios= null;
        try {
            usuarios = UsuarioDAO.loadAll();
        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al consultar los usuarios", e);
        }
        return usuarios;
    }

    @Override
    public List<Prestamo> consultarPrestamosRecurso(Recurso recurso) throws ServiciosBibliotecaException {
        List<Prestamo> prestamosRecurso = null;
        try{
            prestamosRecurso = prestamoDAO.consultarPrestamosRecurso(recurso);
        }
        catch (PersistenceException e){
            throw new ServiciosBibliotecaException("Error al consultar las reservas del recurso.",e);
        }
        return prestamosRecurso;
    }

    @Override
    public void cancelarPrestamo(String correoUsuario, int idRecurso) throws ServiciosBibliotecaException {
        try{
            prestamoDAO.cancelarPrestamo(correoUsuario, idRecurso);
        }
        catch (PersistenceException e){
            throw new ServiciosBibliotecaException("Error al eliminar la reserva del usuario",e);
        }
    }
}
