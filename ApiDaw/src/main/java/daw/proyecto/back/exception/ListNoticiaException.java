/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.exception;

/**
 *
 * @author Izan Lorenzo
 */
public class ListNoticiaException extends Exception{
    public ListNoticiaException() {
        super("No se pudo obtener el listado de noticias");
    }
}
