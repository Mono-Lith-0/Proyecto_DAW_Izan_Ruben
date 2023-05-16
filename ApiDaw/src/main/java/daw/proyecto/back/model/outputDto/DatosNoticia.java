/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.model.outputDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Izan Lorenzo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosNoticia {
    
    private long id;
    
    private String titulo;
    
    private String fecha;
}
