/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.persistencia.RecursoDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.RecursoMapper;
import java.util.List;

/**
 *
 * @author 2127790
 */
public class MyBatisRecursoDAO implements RecursoDAO{
    @Inject
    RecursoMapper recursoMapper;
    public List<Recurso> consultarRecursos() throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void save(Recurso b) throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Recurso load(int recursoID) throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
