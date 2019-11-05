    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.RecursoDAO;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import java.util.List;

/**
 *
 * @author Carlos Murillo
 */
public class ServiciosBibliotecaImpl implements ServiciosBiblioteca{
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private UsuarioDAO UsuarioDAO;

    @Override
    public void registrarRecurso(Recurso cli) throws ServiciosBibliotecaException {
        try {
            System.out.println("si1");
            recursoDAO.registrarRecurso(cli);
            System.out.println("si2");
        } catch (PersistenceException e) {
            throw new ServiciosBibliotecaException("Error al guardar el recurso " + cli.toString(), e);
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

}
