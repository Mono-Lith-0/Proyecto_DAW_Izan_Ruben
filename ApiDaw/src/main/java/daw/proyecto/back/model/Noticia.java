/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.proyecto.back.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Imagen imagen;
    
    @Column(nullable=true)
    private String cuerpo;
    
    @Column(length=2048, nullable=false)
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn(name="autor")
    private Autor autor;
    
    
}
