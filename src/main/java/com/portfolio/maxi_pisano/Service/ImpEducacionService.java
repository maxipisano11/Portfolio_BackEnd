
package com.portfolio.maxi_pisano.Service;

import com.portfolio.maxi_pisano.Entity.Educacion;
import com.portfolio.maxi_pisano.Repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list(){
        return iEducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return iEducacionRepository.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion edu){
        iEducacionRepository.save(edu);
    }
    
    public void delete(int id){
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByNombreEdu(String nombreEdu){
       return iEducacionRepository.existsByNombreEdu(nombreEdu);
    }
}
