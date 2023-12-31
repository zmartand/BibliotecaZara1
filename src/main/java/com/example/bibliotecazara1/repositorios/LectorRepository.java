package com.example.bibliotecazara1.repositorios;

import com.example.bibliotecazara1.entidades.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    List<Lector> findByNombreContaining(String nombre);
    Lector findByIdentificacion(String identificacion);
}