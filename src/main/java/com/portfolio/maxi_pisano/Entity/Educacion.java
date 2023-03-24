
package com.portfolio.maxi_pisano.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String periodoEdu;
    private String nombreEdu;
    private String descripcionEdu;

    //Constructores
    public Educacion() {
    }

    public Educacion(String periodoEdu, String nombreEdu, String descripcionEdu) {
        this.periodoEdu = periodoEdu;
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }
    
    //Getters & Setters

    public int getId() {
        return id;
    }

    public String getPeriodoEdu() {
        return periodoEdu;
    }

    public void setPeriodoEdu(String periodoEdu) {
        this.periodoEdu = periodoEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }
      
}
