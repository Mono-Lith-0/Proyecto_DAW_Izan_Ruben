/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.service;

import daw.proyecto.back.exception.NotImageException;
import daw.proyecto.back.model.Imagen;
import daw.proyecto.back.repository.ImagenRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Lila
 */
@Service
@RequiredArgsConstructor
public class imagenService {
    
    private final ImagenRepository imagenRepository;
    
    public Imagen saveImagen(MultipartFile sent) throws NotImageException, IOException {
        
        if (!sent.isEmpty()) {
            if (!"image".equals(sent.getContentType().split("/")[0])) {
                throw new NotImageException();
            } else {
                Imagen imagen = new Imagen();
                
                Pattern pattern = Pattern.compile("(\\.[^.]+)$");
                Matcher matcher = pattern.matcher(sent.getOriginalFilename());
                matcher.find();
                String extension = matcher.group(1);
                imagen.setExtension(extension);
                
                Imagen saved = imagenRepository.save(imagen);
                
                File file = new File("imagenes/" + saved.getId() + extension);
                FileOutputStream writer = new FileOutputStream(file);
                writer.write(sent.getBytes());
                
                return saved;
            }
        } else return null;
    }
}
