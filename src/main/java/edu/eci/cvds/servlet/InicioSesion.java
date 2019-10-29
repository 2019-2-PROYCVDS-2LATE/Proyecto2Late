package edu.eci.cvds.servlet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.*;

@ManagedBean(name="InicioBean")
@ApplicationScoped
public class InicioSesion{
	private String correo;
	private String contrasena;
	
	public InicioSesion(){
		correo = "";
		contrasena="";
	}
	public String getCorreo(){
		return correo;
	}
	public String getContrasena(){
		return contrasena;
	}
	public void setCorreo(String correo){
		this.correo = correo;
	}
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}	
	
	public String iniciar(String correo,String contrasena){
		boolean ban = true;
		if(ban){
			return "Home";
		}
		return "InicioSesion";
	}
}