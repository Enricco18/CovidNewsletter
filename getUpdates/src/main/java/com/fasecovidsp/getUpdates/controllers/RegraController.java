package com.fasecovidsp.getUpdates.controllers;

import java.util.List;
import com.fasecovidsp.getUpdates.models.Regras;
import com.fasecovidsp.getUpdates.repositories.FaseRegrasRepository;
import com.fasecovidsp.getUpdates.repositories.MunicipioRepository;
import com.fasecovidsp.getUpdates.repositories.RegraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegraController {
    @Autowired
    private FaseRegrasRepository faseRegrasRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private RegraRepository regraRepository;

    @GetMapping
    public List<Regras> getAllRegras(){
        return null;
    }
}
