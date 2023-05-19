/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.model.outputDto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Izan Lorenzo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputNoticia {
    
    private long id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
    private byte[] imagen;
}
