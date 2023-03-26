
package com.portfolio.maxi_pisano.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoProyectos {
    @NotBlank
    private String periodo;
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    private String enlace;
    
    // Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String periodo, String nombre, String descripcion, String img) {
        this.periodo = periodo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
    }
    
    // Getters & Setters

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    
    
    
}
