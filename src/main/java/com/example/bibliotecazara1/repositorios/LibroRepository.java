package com.example.bibliotecazara1.repositorios;

import com.example.bibliotecazara1.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}