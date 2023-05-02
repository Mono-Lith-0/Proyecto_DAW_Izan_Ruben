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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Izan Lorenzo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="autor")
public class Autor implements UserDetails{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(length=50, nullable=false)
    private String nombre;
    
    @Column(length=50, nullable=false)
    private String apellidos;
    
    @Column(name="usuario", length=20, nullable=false, unique=true)
    private String username;
    
    @Column(name="passwd", length=20, nullable=false)
    private String password;
    
    private final String authority = "AUTOR";
    
    @OneToMany(mappedBy="autor")
    private List<Noticia> noticias;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Permiso> authorities = new ArrayList();
        
        authorities.add(new Permiso());
        
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   
    
    
    
    
}
