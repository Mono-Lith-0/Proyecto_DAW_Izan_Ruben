/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.repository;

import daw.proyecto.back.model.Autor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Izan Lorenzo
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {
     
    public Optional<Autor> findByUsername(String username);
}
