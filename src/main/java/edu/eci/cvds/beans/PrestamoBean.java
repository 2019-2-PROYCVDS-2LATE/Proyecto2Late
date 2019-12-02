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
import java.text.ParseException;
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
    private String fechaInicio;
    private String fechaFin;
    private ScheduleModel eventModel;

    /**
     * Obtenemos una instancia de ServiciosBiblioteca,
     * para poder utilizar los servicios de la biblioteca
     */
    public PrestamoBean() {
        setServiciosBiblioteca(ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca());
        HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

        correoUsuario = request.getRemoteUser();
        eventModel = new DefaultScheduleModel();
        cargarEventos();

    }
    
    public void cargarEventos(){
        List<Prestamo> prestamosUsuario = null;
        try {
            prestamosUsuario = serviciosBiblioteca.consultarPrestamosUsuario(correoUsuario);

        } catch (ServiciosBibliotecaException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatter=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        for (int i = 0; i<prestamosUsuario.size(); i++) {
        	Date fin = null;
        	Date inicio = null;

			try {
				inicio = formatter.parse(prestamosUsuario.get(i).getFechaInicio());
				fin = formatter.parse(prestamosUsuario.get(i).getFechaFin());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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





    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFi) {
        this.fechaFin = fechaFi;
    }

}
