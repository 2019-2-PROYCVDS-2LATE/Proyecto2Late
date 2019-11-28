/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author 2lateTeam
 */
public class Prestamo implements Serializable {
    private String correoUsuario;
    private int IdRecurso;

    private String fechaInicio;//fecha en la cual se va a prestar el recurso
    private String fechaFin;
    private int idPrestamo;

    public Prestamo(String correoUsuario, int IdRecurso, String fechaInico, String fechaFina){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);

        this.setFechaInicio(fechaInico);
        this.setFechaFin(fechaFina);

    }



    public Prestamo(int idPrestamo, String correoUsuario, int IdRecurso,String fechaInico, String fechaFina){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);

        System.out.println(fechaInico);
        System.out.println(fechaFina);
        this.setFechaInicio(fechaInico);
        this.setFechaFin(fechaFina);
        this.setIdPrestamo(idPrestamo);
    }


    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getIdRecurso() {
        return IdRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        IdRecurso = idRecurso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
}
