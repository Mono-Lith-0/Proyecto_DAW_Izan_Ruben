/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.model;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Izan Lorenzo
 */
public class Permiso implements GrantedAuthority {
    
    public final String permiso = "AUTOR";

    @Override
    public String getAuthority() {
        return this.permiso;
    }
    
    
}
