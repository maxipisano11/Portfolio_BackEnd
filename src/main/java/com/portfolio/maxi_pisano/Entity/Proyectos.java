
package com.portfolio.maxi_pisano.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String periodo;
    private String nombre;
    private String descripcion;
    @Size(min = 0, max = 255, message = "No cumple con la longitud")
    private String enlace;
    
    // Constructores
    public Proyectos() {
    }
      
    public Proyectos(String periodo, String nombre, String descripcion, String enlace) {
        this.periodo = periodo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
    }
     
}