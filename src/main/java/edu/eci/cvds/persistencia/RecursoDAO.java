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
 * @author 2127790
 */
public interface RecursoDAO {
    public List<Recurso> loadAll() throws PersistenceException;
    
    public void save(Recurso b) throws PersistenceException;
    
    public Recurso load(int recursoID) throws PersistenceException;
    
}
