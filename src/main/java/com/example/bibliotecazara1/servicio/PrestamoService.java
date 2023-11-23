package com.example.bibliotecazara1.servicio;

import com.example.bibliotecazara1.entidades.Prestamo;
import com.example.bibliotecazara1.repositorios.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    public Prestamo registrarPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
    public Optional<Optional<Prestamo>> actualizarPrestamo(Long id, Prestamo prestamoActualizado) {
        return prestamoRepository.findById(id)
                .map(prestamo -> {
                    prestamo.setLibro(prestamoActualizado.getLibro());
                    prestamo.setLector(prestamoActualizado.getLector());
                    prestamo.setFechaPrestamo(prestamoActualizado.getFechaPrestamo());
                    prestamo.setFechaDevolucion(prestamoActualizado.getFechaDevolucion());
                    return Optional.of(prestamoRepository.save(prestamo));
                });
    }


}
