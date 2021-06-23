package com.fasecovidsp.userHandler.repositories;

import com.fasecovidsp.userHandler.models.FaseRegras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRegrasRepository extends JpaRepository<FaseRegras,Long> {
    public FaseRegras findByFase(String fase);
}
