/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.exception;

import java.io.IOException;

/**
 *
 * @author Lila
 */
public class NotImageException extends IOException {
    public NotImageException() {
        super("El fichero enviado no es una imágen");
    }
    
    public NotImageException(String msg) {
        super(msg);
    }
}
