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
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;


import javax.servlet.http.HttpServletRequest;
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
    private Date fechaInicio;
    private Date fechaFin;
    private ScheduleModel eventModel;

    public PrestamoBean() {

        setServiciosBiblioteca(ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca());
        HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

        correoUsuario = request.getRemoteUser();
        eventModel = new DefaultScheduleModel();


    }
    
    public void cargarEventos(){
        List<Prestamo> prestamosUsuario = null;
        try {
            prestamosUsuario = serviciosBiblioteca.consultarPrestamosUsuario(correoUsuario);
            System.out.println(prestamosUsuario.size());
        } catch (ServiciosBibliotecaException e) {
            e.printStackTrace();
        }
        for (int i = 0; i<prestamosUsuario.size(); i++) {
        	Date inicio = prestamosUsuario.get(i).getFechaInicio();
        	Date fin = prestamosUsuario.get(i).getFechaFin();
            System.out.println(inicio);
            System.out.println(fin);
        	DefaultScheduleEvent event = new DefaultScheduleEvent("Prestamo",inicio,fin);
        	eventModel.addEvent(event);
        }

    }

    public void registrarPrestamo() {
        try {
            //System.out.println(correoUsuario + " " + idRecurso + " " + horaInicio + " " +fechaInicio+" "+duracion);
            Prestamo prestamo = new Prestamo(getCorreoUsuario(), getIdRecurso(), getFechaInicio(), getFechaFin());
            getServiciosBiblioteca().registrarPrestamo(prestamo);
            facesError("Registro Exitoso!");
        } catch (ServiciosBibliotecaException e) {
            facesError(e.getMessage());
        }
    }

    /**
     * El recurso debe estar disponible en la hora que se desea reservar
     *
     * @param prestamo
     * @return si es posible reservar el recurso
     */
    public boolean verificarPrestamo(Prestamo prestamo){
        try{
            List<Prestamo> prestamosGuardados = getServiciosBiblioteca().consultarPrestamos();
            for(Prestamo p: prestamosGuardados){
                if(p.getIdRecurso() == prestamo.getIdRecurso() &&
                        p.getFechaInicio().equals(prestamo.getFechaInicio()) &&
                        p.getFechaFin().equals(prestamo.getFechaFin())

                ){
                    return false;
                }
            }
            return true;
        }
        catch (ServiciosBibliotecaException e){
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

    public ScheduleModel getEventModel(){

        return eventModel;
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





    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFi) {
        this.fechaFin = fechaFi;
    }


}
