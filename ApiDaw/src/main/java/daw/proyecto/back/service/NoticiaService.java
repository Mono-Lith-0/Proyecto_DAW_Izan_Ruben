/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.service;

import daw.proyecto.back.exception.BadNoticiaException;
import daw.proyecto.back.exception.ListNoticiaException;
import daw.proyecto.back.model.Autor;
import daw.proyecto.back.model.Noticia;
import daw.proyecto.back.model.inputDto.NoticiaInputDto;
import daw.proyecto.back.model.outputDto.ListNoticia;
import daw.proyecto.back.repository.NoticiaRepository;
import io.micrometer.common.util.StringUtils;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Izan Lorenzo
 */
@Service
@RequiredArgsConstructor
public class NoticiaService {
    
    private final NoticiaRepository noticiaRepository;

    public Noticia addNoticia(NoticiaInputDto inputNoticia, Autor autor) throws BadNoticiaException {
        
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(inputNoticia.getTitulo());
        noticia.setAutor(autor);
        noticia.setFecha(LocalDate.now());
        noticia.setCuerpo(inputNoticia.getCuerpo());
        
        if (noticia.getAutor() == null || StringUtils.isBlank(noticia.getTitulo())) {
            throw new BadNoticiaException();
        }

        return noticiaRepository.save(noticia);
    }
    
    public List<ListNoticia> getNoticias() throws ListNoticiaException {
        
        List<ListNoticia> list = noticiaRepository.findNoticias();
        
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ListNoticiaException();
        }
    }
    
    public List<ListNoticia> groupByYear(List<ListNoticia> noticias, Year anno) {
        
        List<ListNoticia> list = new ArrayList<>();
        
        for (ListNoticia noticia : noticias) {
            
            if (anno.equals(noticia.getFecha().getYear())) {
                list.add(noticia);
            }
        }
        
        return list;
    }
    
    public List<ListNoticia> groupByMonth(List<ListNoticia> noticias, Month mes) {
        
        List<ListNoticia> list = new ArrayList<>();
        
        for (ListNoticia noticia : noticias) {
            if (mes.equals(noticia.getFecha().getMonth())) {
                list.add(noticia);
            }
        }
        
        return list;
    }


}
