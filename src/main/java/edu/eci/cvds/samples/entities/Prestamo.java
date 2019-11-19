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
    private int IdRecurso;
    private int horaInicio;
    private String fechaInicio;//fecha en la cual se va a prestar el recurso
    private int duracion; //duracion en horas
    private int idPrestamo;

    public Prestamo(String correoUsuario, int IdRecurso, String fechaInico, int horaInicio){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);
        this.setHoraInicio(horaInicio);
        this.setFechaInicio(fechaInico);
    }

    public Prestamo(String correoUsuario, int IdRecurso,String fechaInico, int horaInicio, int duracion){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);
        this.setHoraInicio(horaInicio);
        this.setFechaInicio(fechaInico);
        this.setDuracion(duracion);
    }

    public Prestamo(int idPrestamo, String correoUsuario, int IdRecurso,String fechaInico, int horaInicio, int duracion){
        this.setCorreoUsuario(correoUsuario);
        this.setIdRecurso(IdRecurso);
        this.setHoraInicio(horaInicio);
        this.setFechaInicio(fechaInico);
        this.setDuracion(duracion);
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

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
}
