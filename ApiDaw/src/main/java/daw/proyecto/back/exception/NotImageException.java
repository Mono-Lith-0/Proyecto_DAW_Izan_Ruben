/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.exception;

/**
 *
 * @author Lila
 */
public class NotImageException extends Exception {
    public NotImageException() {
        super("El fichero enviado no es una imágen");
    }
}
