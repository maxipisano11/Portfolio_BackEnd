
package com.portfolio.maxi_pisano.Controller;
import com.portfolio.maxi_pisano.Dto.dtoSkills;
import com.portfolio.maxi_pisano.Entity.Skills;
import com.portfolio.maxi_pisano.Security.Controller.Mensaje;
import com.portfolio.maxi_pisano.Service.ImpSkillsService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Skills")
public class SkillsController {
    @Autowired 
    ImpSkillsService impSkillsService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = impSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!impSkillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skills = impSkillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("Campo nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impSkillsService.existsByNombre(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("Esa Skill existe"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(dtoskills.getNombre(), dtoskills.getPorcentaje());
        impSkillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        if(!impSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if(impSkillsService.existsByNombre(dtoskills.getNombre()) && impSkillsService.getByNombre(dtoskills.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);  
        }
        if(StringUtils.isBlank(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);  
        }
        
        Skills skills = impSkillsService.getOne(id).get();
        skills.setNombre(dtoskills.getNombre());
        skills.setPorcentaje(dtoskills.getPorcentaje());
        impSkillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill Actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        
        impSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia borrada"), HttpStatus.OK);
    }
}
