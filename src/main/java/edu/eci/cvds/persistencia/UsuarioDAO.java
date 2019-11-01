/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.samples.entities.Usuario;
/**
 *
 * @author 2127790
 */
public interface UsuarioDAO {
    
     public void save(Usuario user) throws PersistenceException;

    public List<Usuario> loadAll() throws PersistenceException;
}
