package com.fasecovidsp.userHandler.repositories;

import java.util.List;

import com.fasecovidsp.userHandler.models.Municipio;
import com.fasecovidsp.userHandler.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    public List<Usuario> findAllByMunicipio(Municipio municipio);
}

