/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.exception;

/**
 *
 * @author Izan Lorenzo
 */
public class AutorNotFoundException extends Exception {
    public AutorNotFoundException(long id) {
        super("Autor with id \"" + id + "\" was not found");
    }
}
