/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author 2152972
 */
public class Usuario {
    
	private String correo;
	private String area;
	private String nombre;

	public Usuario(String correo, String area, String nombre) {
		
		this.correo = correo;
		this.area = area;
		this.nombre = nombre;
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
}
