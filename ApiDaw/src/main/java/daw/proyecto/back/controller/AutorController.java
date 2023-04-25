/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package daw.proyecto.back.controller;

import daw.proyecto.back.model.authentication.AuthenticationRequest;
import daw.proyecto.back.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izan Lorenzo
 */
@RestController("/api/autor")
@RequiredArgsConstructor
public class AutorController {
    
    private final AutorService autorService;
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest credenciales) {
       
        return new ResponseEntity<>(autorService.authenticate(credenciales), HttpStatus.OK);
    }
    
    /*
    @PostMapping()
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.crearAutor(autor);
    }
    */
}
