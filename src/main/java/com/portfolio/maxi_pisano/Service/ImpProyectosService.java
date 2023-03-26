
package com.portfolio.maxi_pisano.Service;

import com.portfolio.maxi_pisano.Entity.Proyectos;
import com.portfolio.maxi_pisano.Repository.IProyectosRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectosService {
    @Autowired
    IProyectosRepository iProyectosRepository;
    public List<Proyectos> list(){
        return iProyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return iProyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return iProyectosRepository.findByNombre(nombre);
    }
    
    public void save(Proyectos proyecto){
        iProyectosRepository.save(proyecto);
    }
    
    public void delete(int id){
        iProyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectosRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iProyectosRepository.existsByNombre(nombre);
    }
}
