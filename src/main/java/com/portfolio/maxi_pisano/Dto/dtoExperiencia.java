
package com.portfolio.maxi_pisano.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String periodoEx;
    @NotBlank
    private String nombreEx;
    @NotBlank
    private String descripcionEx;
    
    // Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String periodoEx, String nombreEx, String descripcionEx ) {
        this.periodoEx = periodoEx;
        this.nombreEx = nombreEx;
        this.descripcionEx = descripcionEx;
    }
    
    // Getters & Setters

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
