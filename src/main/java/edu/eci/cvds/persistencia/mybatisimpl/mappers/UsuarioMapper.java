/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Usuario;
/**
 *
 * @author 2LateTeam
 *
 */
public interface UsuarioMapper {
	
    public Usuario consultarUsuario(@Param("correo") String correo);

    public void save(@Param("usuario") Usuario usuario);

    public List<Usuario> loadAll();

}
