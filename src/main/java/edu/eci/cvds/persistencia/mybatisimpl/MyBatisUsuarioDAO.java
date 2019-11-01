/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;

/**
 *
 * @author 2127790
 */
public class MyBatisUsuarioDAO implements UsuarioDAO{
    @Inject
    UsuarioMapper usuarioMapper;
    
    @Override
    public List<Usuario> loadAll() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Usuario b) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
