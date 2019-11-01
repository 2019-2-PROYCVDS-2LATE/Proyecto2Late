/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.persistencia;

/**
 *
 * @author 2152972
 */
public class PersistenceException extends Exception{
    public PersistenceException(String message){ 
        super(message);
    }
    
    public PersistenceException(String message, Exception cause) {
        super(message, cause);
    }

    public PersistenceException(Exception cause) {
        super(cause);
    }

}
