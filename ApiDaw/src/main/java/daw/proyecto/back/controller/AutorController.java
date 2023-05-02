/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package daw.proyecto.back.controller;

import daw.proyecto.back.entidad.Autor;
import daw.proyecto.back.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lila
 */
@RestController
public class AutorController {
    
    @Autowired
    AutorService autorService;
    
    public Autor crearAutor(@RequestBody Autor autor) {
        
        return autorService.crearAutor(autor);
    }
}
