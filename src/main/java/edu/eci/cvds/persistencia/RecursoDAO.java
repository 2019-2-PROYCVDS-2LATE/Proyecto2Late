/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia;

import java.util.List;
import edu.eci.cvds.samples.entities.Recurso;

/**
 *
 * @author 2LateTeam
 */
public interface RecursoDAO {
    public List<Recurso> consultarRecursos() throws PersistenceException;
    
    public void registrarRecurso(Recurso b) throws PersistenceException;
    
    public Recurso consultarRecurso(int recursoID) throws PersistenceException;
    
    public void modificarRecurso(String id, String est) throws PersistenceException;
    
}
