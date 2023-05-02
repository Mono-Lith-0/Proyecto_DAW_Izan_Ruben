/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daw.proyecto.back.repository;

import daw.proyecto.back.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lila
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
