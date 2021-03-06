package com.fasecovidsp.userHandler.repositories;

import com.fasecovidsp.userHandler.models.Regras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RegraRepository extends JpaRepository<Regras,Long> {
    public Regras findByDataCorrida(LocalDate date);
}
