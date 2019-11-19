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
    private int idRecurso;
    private int horaInicio;
    private String fechaInicio;
    private int duracion;

    public PrestamoBean() {
        setServiciosBiblioteca(ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca());
    }

    public void registrarPrestamo() {
        try {
            Prestamo prestamo = new Prestamo(getCorreoUsuario(), getIdRecurso(), getFechaInicio(), getHoraInicio(), getDuracion());
            getServiciosBiblioteca().registrarPrestamo(prestamo);
            facesError("Registro Exitoso!");
        } catch (ServiciosBibliotecaException e) {
            facesError(e.getMessage());
        }
    }
    public boolean verificarPrestamo(Prestamo prestamo){
        try {
            List<Prestamo> aux = getServiciosBiblioteca().consultarPrestamos();
            for(int i=0;i<aux.size();i++){
                if(aux.get(i).getIdRecurso() == prestamo.getIdRecurso() && aux.get(i).getFechaInicio().equals(prestamo.getFechaInicio()) && aux.get(i).getHoraInicio()==prestamo.getHoraInicio()){
                    return false;
                }
            }
            return true;

        }catch (ServiciosBibliotecaException e) {
            facesError(e.getMessage());
        }
        return true;
    }

    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage("Registro: ", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }


    public ServiciosBiblioteca getServiciosBiblioteca() {
        return serviciosBiblioteca;
    }

    public void setServiciosBiblioteca(ServiciosBiblioteca serviciosBiblioteca) {
        this.serviciosBiblioteca = serviciosBiblioteca;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
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
}
