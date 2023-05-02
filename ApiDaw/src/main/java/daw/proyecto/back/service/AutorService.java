/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.service;

import daw.proyecto.back.model.Autor;
import daw.proyecto.back.model.inputDto.AuthRequest;
import daw.proyecto.back.model.outputDto.AuthResponse;
import daw.proyecto.back.repository.AutorRepository;
import daw.proyecto.back.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author p-ilorenzo
 */
@RequiredArgsConstructor
public class AutorService {
    
    private final AutorRepository autorRepository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = autorRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwt = jwtService.generateToken(user);
        
        return  new AuthResponse(jwt);
        
    }
    
    public Autor crearAutor(Autor autor) {
        
        autor.setPassword(encoder.encode(autor.getPassword()));
        
        return autorRepository.save(autor);
    }
}
