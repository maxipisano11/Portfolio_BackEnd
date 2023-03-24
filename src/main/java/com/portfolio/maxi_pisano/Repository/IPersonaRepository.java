
package com.portfolio.maxi_pisano.Repository;

import com.portfolio.maxi_pisano.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
    
}

