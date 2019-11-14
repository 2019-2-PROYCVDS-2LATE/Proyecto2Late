/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia.mybatisimpl;
import com.google.inject.Inject;



import edu.eci.cvds.persistencia.PrestamoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.PrestamoMapper;
import java.util.List;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.samples.entities.Prestamo;

import java.util.Date;

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
    @Override
    public Prestamo consultarPrestamo( int id) throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modificarDuracionPrestamo(int id, String duracion) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarFechaPrestamo(int id, Date date) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestamo> consultarPrestamos() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
