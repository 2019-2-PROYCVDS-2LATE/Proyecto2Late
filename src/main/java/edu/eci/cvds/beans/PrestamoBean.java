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
/**
 *
 * @author 2LateTeam
 */

@ManagedBean(name = "prestamoBean")
@ViewScoped
public class PrestamoBean implements Serializable {
        private ServiciosBiblioteca serviciosBiblioteca;

        private String correoUsuario;
        private String IdRecurso;
        private Date horaInicio;
        private int duracion;


    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getIdRecurso() {
        return IdRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        IdRecurso = idRecurso;
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

}
