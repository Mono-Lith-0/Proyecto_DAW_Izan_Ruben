/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package daw.proyecto.back.controller;

import daw.proyecto.back.model.Autor;
import daw.proyecto.back.service.AutorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Izan Lorenzo
 */
@RestController
public class AutorController {
    
    AutorService autorService;
    
    @PostMapping(value="/api/autor")
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.crearAutor(autor);
    }
}
