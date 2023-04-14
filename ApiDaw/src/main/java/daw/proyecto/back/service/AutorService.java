/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.service;

import daw.proyecto.back.model.Autor;
import daw.proyecto.back.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author p-ilorenzo
 */
@RequiredArgsConstructor
public class AutorService {
    
    private final AutorRepository autorRepository;
    private final PasswordEncoder encoder;
    
    // POST
    public Autor crearAutor(Autor autor) {
        
        autor.setPassword(encoder.encode(autor.getPassword()));
        
        return autorRepository.save(autor);
    }
}
