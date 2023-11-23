package com.example.bibliotecazara1.entidades;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String identificacion;
    private String contacto;

    // Relación con Prestamo
    @OneToMany(mappedBy = "lector", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Prestamo> prestamos;

    // Getters y setters ...
}
