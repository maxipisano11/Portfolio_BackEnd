
package com.portfolio.maxi_pisano.Repository;

import com.portfolio.maxi_pisano.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreEx(String nombreEx);
    public boolean existsByNombreEx(String nombreEx);
}
