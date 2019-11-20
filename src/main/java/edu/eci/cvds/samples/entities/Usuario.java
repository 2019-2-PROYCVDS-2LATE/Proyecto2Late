/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
/**
 *
 * @author 2LateTeam
 *
 */
public class Usuario implements Serializable{

	private String correo;
	private String area;
	private String nombre;
	private String contraseña;

	public Usuario(String correo, String area, String nombre,String contraseña) {

		this.correo = correo;
		this.area = area;
		this.nombre = nombre;
		this.contraseña=contraseña;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
