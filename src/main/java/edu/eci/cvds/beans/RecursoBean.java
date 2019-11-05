package edu.eci.cvds.beans;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.RecursoTipo;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "recursoBean")
@ViewScoped
public class RecursoBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ShiroLoginBean.class);

    private ServiciosBiblioteca serviciosBiblioteca;

    private String nombre;
    private String ubicacion;
    private RecursoTipo recursoTipo;
    private int capacidad;
    private String identificadorInterno;
    private boolean estado;

    public RecursoBean(){
        serviciosBiblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getIdentificadorInterno() {
        return identificadorInterno;
    }

    public void setIdentificadorInterno(String identificadorInterno) {
        this.identificadorInterno = identificadorInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RecursoTipo getRecursoTipo() {
        return recursoTipo;
    }

    public RecursoTipo[] recursoTipos(){
        return RecursoTipo.values();
    }

    public void setRecursoTipo(RecursoTipo recursoTipo) {
        this.recursoTipo = recursoTipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void registrarRecurso() {
        try{
            System.out.println("si");
            Recurso recurso = new Recurso(nombre, ubicacion, recursoTipo, capacidad);
            System.out.println("recurso ");
            serviciosBiblioteca.registrarRecurso(recurso);
            System.out.println("fin");
            facesError("Registro exitoso");

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
