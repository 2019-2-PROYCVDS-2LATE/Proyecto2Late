/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

public class Recurso implements Serializable{
    private int identificadorInterno;
    private String nombre;
    private String ubicacion;
    private RecursoTipo tipo;
    private int capacidad;
    private String estado;


	public Recurso(String nombre, String ubicacion, RecursoTipo tipo, int capacidad){
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.estado = "Disponible";
	}
	public Recurso(int identificadorInterno,String nombre, String ubicacion, String tipo, int capacidad,String estado) {
		if (RecursoTipo.EQUIPO_COMPUTO.name().equals(tipo)) {
			this.tipo = RecursoTipo.EQUIPO_COMPUTO;
		} else if (RecursoTipo.EQUIPO_MULTIMEDIA.name().equals(tipo)) {
			this.tipo = RecursoTipo.EQUIPO_MULTIMEDIA;
		} else {
			this.tipo = RecursoTipo.SALA_ESTUDIO;
		}
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.estado = estado;
		this.identificadorInterno = identificadorInterno;
	}


	public int getIdentificadorInterno() {
			return identificadorInterno;
	}

	public void setIdentificadorInterno(int identificadorInterno) {
		this.identificadorInterno = identificadorInterno;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(RecursoTipo tipo) {
		this.tipo = tipo;
	}
}
