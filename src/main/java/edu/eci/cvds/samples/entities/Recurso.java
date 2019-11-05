/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Recurso implements Serializable{
    private int identificadorInterno;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private String estado;


	public Recurso(int id, String nombre, String ubicacion, String tipo, int capacidad, String estado) {
		this.identificadorInterno = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.estado = estado;
	}

	public int getId() {
		return identificadorInterno;
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
		return capacidad;
	}
	public void setTiempo_prestamo(int tp) {
		this.capacidad = tp;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
