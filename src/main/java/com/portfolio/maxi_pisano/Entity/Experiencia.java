
package com.portfolio.maxi_pisano.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String periodoEx;
    private String nombreEx;
    private String descripcionEx;
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String periodoEx, String nombreEx, String descripcionEx) {
        this.periodoEx = periodoEx;
        this.nombreEx = nombreEx;
        this.descripcionEx = descripcionEx;
        
    }
    
    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPeriodoEx() {
        return periodoEx;
    }

    public void setPeriodoEx(String periodoEx) {
        this.periodoEx = periodoEx;
    }

    public String getNombreEx() {
        return nombreEx;
    }

    public void setNombreEx(String nombreEx) {
        this.nombreEx = nombreEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }
    
    
}
