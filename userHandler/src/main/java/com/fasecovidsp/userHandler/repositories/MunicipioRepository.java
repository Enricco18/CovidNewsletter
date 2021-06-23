package com.fasecovidsp.userHandler.repositories;

import com.fasecovidsp.userHandler.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,Long> {
    public Municipio findByName(String name);
}
