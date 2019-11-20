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
        try{
            return usuarioMapper.loadAll();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("Imposible cargar los usuario",e);
        }
    }

    @Override
    public void save(Usuario usuario) throws PersistenceException {
        try{
            usuarioMapper.save(usuario);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("El usuario ya existe",e);
        }
    }

    @Override
    public Usuario consultarUsuario(String correo) throws PersistenceException {
        return usuarioMapper.consultarUsuario(correo);
    }
}
