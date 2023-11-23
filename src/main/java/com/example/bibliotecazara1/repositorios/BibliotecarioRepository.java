package com.example.bibliotecazara1.repositorios;
import com.example.bibliotecazara1.entidades.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    List<Bibliotecario> findByNombreContaining(String nombre);
}
