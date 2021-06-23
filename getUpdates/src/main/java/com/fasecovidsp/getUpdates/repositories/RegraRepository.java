package com.fasecovidsp.getUpdates.repositories;

import com.fasecovidsp.getUpdates.models.Regras;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RegraRepository extends JpaRepository<Regras,Long> {
    public Regras findByDataCorrida(LocalDate date);

    public Regras findByMunicipio_Name(String nome , Sort sort);
}
