/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package daw.proyecto.back.controller;

import daw.proyecto.back.exception.AutorNotFoundException;
import daw.proyecto.back.exception.BadNoticiaException;
import daw.proyecto.back.model.Autor;
import daw.proyecto.back.model.Noticia;
import daw.proyecto.back.model.inputDto.NoticiaInputDto;
import daw.proyecto.back.service.AutorService;
import daw.proyecto.back.service.NoticiaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lila
 */
@RestController
@RequestMapping("/noticia")
@RequiredArgsConstructor
public class NoticiaController {
    
    private final NoticiaService noticiaService;
    
    private final AutorService autorService;
    
    @PostMapping
    public ResponseEntity addNoticia(@RequestBody NoticiaInputDto inputNoticia, HttpServletRequest request) {
        
        String jwt = request.getHeader("Authorization").substring(7);
        Autor autor;
        try {
            autor = autorService.getAutorFromToken(jwt);
        } catch (AutorNotFoundException e) {
            return new ResponseEntity<>("Autor from bearer token was not a registered Autor", HttpStatus.FORBIDDEN);
        }
        
        try {
            Noticia noticia = noticiaService.addNoticia(inputNoticia, autor);
            return new ResponseEntity<>(noticia, HttpStatus.OK);
        } catch (BadNoticiaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity getListNoticia() {
        
        List<ListNoticia> rawNoticias = noticiaService.getNoticias();
    }
}
