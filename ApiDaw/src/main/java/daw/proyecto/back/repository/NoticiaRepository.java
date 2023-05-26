/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daw.proyecto.back.repository;

import daw.proyecto.back.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Izan Lorenzo
 */
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    
    public static final String LIST_NOTICIA = "SELECT id, titulo, fecha FROM noticia";
    
}