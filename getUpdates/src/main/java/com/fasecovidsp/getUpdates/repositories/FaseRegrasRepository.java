package com.fasecovidsp.getUpdates.repositories;

import com.fasecovidsp.getUpdates.models.FaseRegras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRegrasRepository extends JpaRepository<FaseRegras,Long> {
    public FaseRegras findByFase(String fase);
}
