/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author 2lateTeam
 */
public class Prestamo implements Serializable {
    private String correoUsuario;
    private int IdRecurso;

    private Date fechaInicio;//fecha en la cual se va a prestar el recurso
    private Date fechaFin;
    private int idPrestamo;



    public Prestamo(String correoUsuario, int IdRecurso,Date fechaInico, Date fechaFina){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);

        this.setFechaInicio(fechaInico);

    }

    public Prestamo(int idPrestamo, String correoUsuario, int IdRecurso,Date fechaInico, Date fechaFina){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);

        this.setFechaInicio(fechaInico);

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


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
}
