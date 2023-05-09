/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author p-ilorenzo
 */
@Data
@Entity
@Table(name="noticia")
@AllArgsConstructor
@NoArgsConstructor
public class Noticia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private long id;
    
    @Column(length=50, nullable=false)
    private String titulo;
    
    @Column(length=20, nullable=true)
    private String ruta;
    
    @Column(nullable=false)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name="autor")
    private Autor autor;
    
    
}
