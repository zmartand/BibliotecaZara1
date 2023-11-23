package com.example.bibliotecazara1.repositorios;

import com.example.bibliotecazara1.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByAutor(String autor);
    Libro findByIsbn(String isbn);
}