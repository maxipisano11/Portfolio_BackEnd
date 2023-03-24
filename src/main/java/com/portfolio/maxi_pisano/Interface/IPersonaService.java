
package com.portfolio.maxi_pisano.Interface;

import com.portfolio.maxi_pisano.Entity.Persona;
import java.util.List;


public interface IPersonaService {
//Obtener Personas
    public List<Persona> getPersona();
    
// Guardar Persona
    public void savePersona(Persona persona);
    
//Eliminar Persona por ID
    public void deletePersona(Long id);

// Buscar Persona por ID
    public Persona findPersona(Long id);
    
}
