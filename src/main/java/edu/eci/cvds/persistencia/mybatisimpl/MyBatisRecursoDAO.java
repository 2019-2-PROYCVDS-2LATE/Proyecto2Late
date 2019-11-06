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
 * @author 2152972
 */
public class MyBatisRecursoDAO implements RecursoDAO{
    @Inject
    RecursoMapper recursoMapper;

    @Override
    public List<Recurso> consultarRecursos() throws PersistenceException{
        return recursoMapper.consultarRecursos();
    }

    @Override
    public void registrarRecurso(Recurso b) throws PersistenceException {
        try{

            recursoMapper.registrarRecurso(b);

        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("Elemento ya existe",e);
        }
    }

    @Override
    public Recurso consultarRecurso(int recursoID) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
