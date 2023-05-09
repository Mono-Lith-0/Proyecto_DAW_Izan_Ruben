/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.model.inputDto;

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
public class AutorInputDto {
    
    private String nombre;
    private String apellidos;
    private String username;
    private String password;
}
