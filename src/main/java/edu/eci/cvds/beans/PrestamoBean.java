/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.beans;

import edu.eci.cvds.samples.entities.Prestamo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
/**
 *
 * @author 2LateTeam
 */

@ManagedBean(name = "prestamoBean")
@ViewScoped
public class PrestamoBean implements Serializable {
    private ServiciosBiblioteca serviciosBiblioteca;

    private String correoUsuario;
    private String idRecurso;
    private Date horaInicio;
    private int duracion;

    public PrestamoBean() {
        serviciosBiblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        idRecurso = idRecurso;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void registrarPrestamo() {
        try {
            Prestamo prestamo = new Prestamo(correoUsuario, idRecurso, horaInicio);
            serviciosBiblioteca.registrarPrestamo(prestamo);
            facesError("Registro Exitoso!");
        } catch (ServiciosBibliotecaException e) {
            facesError(e.getMessage());
        }
    }
    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage("Registro: ", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }


}
