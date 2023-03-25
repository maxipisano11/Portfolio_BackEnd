
package com.portfolio.maxi_pisano.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String periodoEdu;
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String periodoEdu, String nombreEdu, String descripcionEdu) {
        this.periodoEdu = periodoEdu;
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }
    
    // Getters & Setters

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
