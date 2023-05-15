/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daw.proyecto.back.repository;

import daw.proyecto.back.model.Noticia;
import daw.proyecto.back.model.outputDto.ListNoticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Izan Lorenzo
 */
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    
    public static final String LIST_NOTICIA = "SELECT id, titulo, fecha FROM noticia";
    
    @Query(value=LIST_NOTICIA, nativeQuery=true)
    List<ListNoticia> findNoticias();
}
