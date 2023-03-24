
package com.portfolio.maxi_pisano.Controller;

import com.portfolio.maxi_pisano.Dto.dtoEducacion;
import java.util.List;
import com.portfolio.maxi_pisano.Entity.Educacion;
import com.portfolio.maxi_pisano.Security.Controller.Mensaje;
import com.portfolio.maxi_pisano.Service.ImpEducacionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/educacion")
@CrossOrigin(origins="http://localhost:4200")
public class EducacionController {
    @Autowired
    ImpEducacionService impEducacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getNombreEdu())){
            return new ResponseEntity(new Mensaje("Campo nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impEducacionService.existsByNombreEdu(dtoedu.getNombreEdu())){
            return new ResponseEntity(new Mensaje("Esa Educación existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoedu.getNombreEdu(), dtoedu.getDescripcionEdu(), dtoedu.getPeriodoEdu());
        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        if(!impEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if(impEducacionService.existsByNombreEdu(dtoedu.getNombreEdu()) && impEducacionService.getByNombreEdu(dtoedu.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);  
        }
        if(StringUtils.isBlank(dtoedu.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);  
        }
        
        Educacion educacion = impEducacionService.getOne(id).get();
        educacion.setNombreEdu(dtoedu.getNombreEdu());
        educacion.setDescripcionEdu(dtoedu.getDescripcionEdu());
        educacion.setPeriodoEdu(dtoedu.getPeriodoEdu());
        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        
        impEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia borrada"), HttpStatus.OK);
    }
}
