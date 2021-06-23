package com.fasecovidsp.userHandler.controllers;

import com.fasecovidsp.userHandler.controllers.form.UserForm;
import com.fasecovidsp.userHandler.models.Municipio;
import com.fasecovidsp.userHandler.models.Usuario;
import com.fasecovidsp.userHandler.repositories.MunicipioRepository;
import com.fasecovidsp.userHandler.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    MunicipioRepository municipioRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> createUser(UserForm userForm){
        Usuario usuario = new Usuario();
        usuario.setCel(userForm.getCel());
        usuario.setName(userForm.getName());

        Municipio municipio = municipioRepository.findByName(userForm.getMunicipioText());
        usuario.setMunicipio(municipio);

        usuarioRepository.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }
}
