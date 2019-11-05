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
    private RecursoTipo tipo;
    private int capacidad;
    private boolean estado;


	public Recurso(String nombre, String ubicacion, RecursoTipo tipo, int capacidad){
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.estado = true;
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

	public RecursoTipo getTipo() {
		return tipo;
	}

	public int getTiempo_prestamo() {
		return capacidad;
	}

	public void setTiempo_prestamo(int tp) {
		this.capacidad = tp;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
