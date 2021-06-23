package com.fasecovidsp.getUpdates.repositories;

import com.fasecovidsp.getUpdates.models.Regras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RegraRepository extends JpaRepository<Regras,Long> {
    public Regras findByDataCorrida(LocalDate date);
}
