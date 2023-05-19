/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package daw.proyecto.back.controller;

import daw.proyecto.back.exception.AutorNotFoundException;
import daw.proyecto.back.exception.BadNoticiaException;
import daw.proyecto.back.exception.ListNoticiaException;
import daw.proyecto.back.exception.NotImageException;
import daw.proyecto.back.model.Autor;
import daw.proyecto.back.model.Imagen;
import daw.proyecto.back.model.inputDto.NoticiaInputDto;
import daw.proyecto.back.model.outputDto.DatosNoticia;
import daw.proyecto.back.service.AutorService;
import daw.proyecto.back.service.NoticiaService;
import daw.proyecto.back.service.imagenService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lila
 */
@RestController
@RequestMapping("/api/noticia")
@RequiredArgsConstructor
public class NoticiaController {
    
    private final NoticiaService noticiaService;
    private final imagenService imagenService;
    
    private final AutorService autorService;
    
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity addNoticia(HttpServletRequest request,  @ModelAttribute NoticiaInputDto inputNoticia) {
        
        String jwt = request.getHeader("Authorization").substring(7);
        Autor autor;
        Imagen imagen;
        
        try {
            autor = autorService.getAutorFromToken(jwt);
        } catch (AutorNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
        
        try {
            imagen = imagenService.saveImagen(inputNoticia.getImagen());
        } catch (NotImageException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            return new ResponseEntity<>(new IOException("Fallo del servidor inesperado").getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        try {
            DatosNoticia noticia = noticiaService.addNoticia(inputNoticia, imagen, autor);
            return new ResponseEntity<>(noticia, HttpStatus.OK);
        } catch (BadNoticiaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity getListNoticia() {
        
        List<DatosNoticia> rawNoticias;
        
        try {
            rawNoticias = noticiaService.getNoticias();
            return new ResponseEntity<>(noticiaService.groupByDate(rawNoticias), HttpStatus.OK);
        } catch (ListNoticiaException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
