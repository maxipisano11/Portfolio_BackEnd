
package com.portfolio.maxi_pisano.Service;

import com.portfolio.maxi_pisano.Entity.Experiencia;
import com.portfolio.maxi_pisano.Repository.IExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
    @Autowired
    IExperienciaRepository iExperienciaRepository;
    
    public List<Experiencia> list(){
        return iExperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreEx(String nombreEx){
        return iExperienciaRepository.findByNombreEx(nombreEx);
    }
    
    public void save(Experiencia exp){
        iExperienciaRepository.save(exp);
    }
    
    public void delete(int id){
        iExperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreEx(String nombreEx){
       return iExperienciaRepository.existsByNombreEx(nombreEx);
    }
}
