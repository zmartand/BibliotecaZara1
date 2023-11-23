package com.example.bibliotecazara1.repositorios;
import com.example.bibliotecazara1.entidades.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    
}
