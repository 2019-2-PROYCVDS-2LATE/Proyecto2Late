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
public class Recurso {
    private int id;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int tiempo_prestamo;
    private String estado;
    
    
	public Recurso(int id, String nombre, String ubicacion, String tipo, int capacidad, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.tiempo_prestamo = capacidad;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public int getTiempo_prestamo() {
		return tiempo_prestamo;
	}
	public void setTiempo_prestamo(int tp) {
		this.tiempo_prestamo = tp;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
