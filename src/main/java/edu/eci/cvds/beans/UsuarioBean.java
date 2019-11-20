package edu.eci.cvds.beans;
import edu.eci.cvds.samples.entities.Usuario;
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
import java.util.List;

/**
 *
 * @author 2LateTeam
 *
 */
@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
    private ServiciosBiblioteca serviciosBiblioteca;

    private String correo;
    private String area;
    private String nombre;
    private String contraseña;
    //podria ser necesario tener una lista de usuarios ?

    public UsuarioBean() {
        serviciosBiblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void save(){
        try{
            Usuario usuario = new Usuario(correo,area,nombre,contraseña);
            serviciosBiblioteca.registrarUsuario(usuario);
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
