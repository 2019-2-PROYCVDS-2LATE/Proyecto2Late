/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.inject.Inject;
package edu.eci.cvds.persistencia.mybatisimpl;

import edu.eci.cvds.persistencia.PrestamoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.PrestamoMapper;
import java.util.List;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.samples.entities.Prestamo;
/**
 *
 * @author 2LateTeam
 */
public class MyBatisPrestamoDAO implements PrestamoDAO {
    @Inject
    PrestamoMapper prestamoMapper;
    
    @Override
    public void registrarPrestamo( Prestamo prestamo) throws PersistenceException{
        try{
            prestamoMapper.registrarPrestamo(prestamo);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("La reserva ya existe",e);
        }
    }
    
    
}
