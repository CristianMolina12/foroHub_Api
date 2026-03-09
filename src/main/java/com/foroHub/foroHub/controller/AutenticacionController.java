package com.foroHub.foroHub.controller;

import com.foroHub.foroHub.domain.usuario.DatosAutentificacion;
import com.foroHub.foroHub.domain.usuario.Usuario;
import com.foroHub.foroHub.infra.security.DatosTokenJWT;
import com.foroHub.foroHub.infra.security.TokenServices;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutentificacion datos){

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());

        var autentificacion = manager.authenticate(authenticationToken);

        var tokenJWT = tokenServices.generarToken((Usuario) autentificacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}