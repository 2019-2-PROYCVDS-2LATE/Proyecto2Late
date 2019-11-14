/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;
import java.util.Date;
/**
 *
 * @author 2lateTeam
 */
public class Prestamo {
    private String correoUsuario;
    private String IdRecurso;
    private Date horaInicio; //fecha en la cual se va a prestar el recurso
    private int duracion; //duracion en horas 
    
    public Prestamo(String correoUsuario, String IdRecurso, Date horaInicio){
        this.correoUsuario =  correoUsuario;
        this.IdRecurso =  IdRecurso;
        this.horaInicio =  horaInicio;
    }
    public Prestamo(String correoUsuario, String IdRecurso, Date horaInicio, int duracion){
        this.correoUsuario =  correoUsuario;
        this.IdRecurso =  IdRecurso;
        this.horaInicio =  horaInicio;
        this.duracion = duracion;
    }        
}
