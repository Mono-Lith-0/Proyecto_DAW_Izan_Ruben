/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.service;

import daw.proyecto.back.exception.AutorNotFoundException;
import daw.proyecto.back.model.Autor;
import daw.proyecto.back.model.authentication.AuthenticationRequest;
import daw.proyecto.back.model.authentication.AuthenticationResponse;
import daw.proyecto.back.model.inputDto.AutorInputDto;
import daw.proyecto.back.model.outputDto.AutorOutputDto;
import daw.proyecto.back.repository.AutorRepository;
import daw.proyecto.back.security.JwtService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author p-ilorenzo
 */
@Service
@RequiredArgsConstructor
public class AutorService {
    
    private final AutorRepository autorRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = autorRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwt = jwtService.generateToken(user);
        
        return  new AuthenticationResponse(jwt);
        
    }
    
    // POST
    public AutorOutputDto crearAutor(AutorInputDto data) {
        
        Autor autor = modelMapper.map(data, Autor.class);
        
        System.out.println(data.getPassword());
        
        autor.setPassword(encoder.encode(autor.getPassword()));
        
        Autor created = autorRepository.save(autor);
        
        return modelMapper.map(created, AutorOutputDto.class);
    }

    public Autor getAutorFromToken(String jwt) throws AutorNotFoundException {

        long id = jwtService.getUserId(jwt);
        Optional<Autor> autor = autorRepository.findById(id);
        
        if (autor.isPresent()) {
            return autor.get();
        } else {
            throw new AutorNotFoundException(id);
        }
    }
}
