
package com.portfolio.maxi_pisano.Controller;

import com.portfolio.maxi_pisano.Dto.dtoProyectos;
import com.portfolio.maxi_pisano.Entity.Proyectos;
import com.portfolio.maxi_pisano.Security.Controller.Mensaje;
import com.portfolio.maxi_pisano.Service.ImpProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"http://localhost:4200", "https://portfolio-maxipisano.web.app"})
@RequestMapping("/proyectos")
public class ProyectosController {
    
    @Autowired 
    ImpProyectosService impProyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = impProyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!impProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = impProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("Campo nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impProyectosService.existsByNombre(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("Ese Proyecto existe"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(dtoproyectos.getPeriodo(), dtoproyectos.getNombre(), dtoproyectos.getDescripcion(), dtoproyectos.getEnlace());
        impProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        if(!impProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if(impProyectosService.existsByNombre(dtoproyectos.getNombre()) && impProyectosService.getByNombre(dtoproyectos.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);  
        }
        if(StringUtils.isBlank(dtoproyectos.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);  
        }
        
        Proyectos proyectos = impProyectosService.getOne(id).get();
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setPeriodo(dtoproyectos.getPeriodo());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());
        proyectos.setEnlace(dtoproyectos.getEnlace());
        impProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        
        impProyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto borrado"), HttpStatus.OK);
    }
    
}
