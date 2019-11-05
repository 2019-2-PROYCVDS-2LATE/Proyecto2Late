/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;

/**
 *
 * @author 2152972
 */
public class Recurso implements Serializable {

    private String nombre;
    private String ubicacion;
    private RecursoTipo tipo;
    private int capacidad;
    private int identificadorInterno;
    private boolean estado;

    public Recurso(String nombre,String ubicacion,RecursoTipo tipo,int capacidad){
        this.capacidad = capacidad;
        this.estado = true;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RecursoTipo getTipo() {
        return tipo;
    }

    public void setTipo(RecursoTipo tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
