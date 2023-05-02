/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.service;

import daw.proyecto.back.entidad.Autor;
import daw.proyecto.back.repository.AutorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lila
 */
@Service("AutorService")
public class AutorService {
    
    private final AutorRepository autorRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
    // POST
    public Autor crearAutor(Autor autor) {
        
        autor.setPasswd(encoder.encode(autor.getPasswd()));
        
        Autor saved = autorRepository.save(autor);
        
        return saved;
    }
}
 