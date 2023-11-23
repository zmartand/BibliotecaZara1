package com.example.bibliotecazara1.repositorios;


import com.example.bibliotecazara1.entidades.Prestamo;
import com.example.bibliotecazara1.entidades.Lector;
import com.example.bibliotecazara1.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByLector(Lector lector);
    List<Prestamo> findByLibro(Libro libro);
}
