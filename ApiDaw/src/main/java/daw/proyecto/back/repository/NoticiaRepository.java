/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daw.proyecto.back.repository;

import daw.proyecto.back.entidad.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lila
 */
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    
}
