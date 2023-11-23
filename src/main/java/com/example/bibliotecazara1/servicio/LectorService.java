package com.example.bibliotecazara1.servicio;

import com.example.bibliotecazara1.entidades.Lector;
import com.example.bibliotecazara1.repositorios.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectorService {
    @Autowired
    private LectorRepository lectorRepository;

    public Lector guardarLector(Lector lector) {
        return lectorRepository.save(lector);
    }

    public void eliminarLector(Long id) {
        lectorRepository.deleteById(id);
    }

    public List<Lector> buscarPorNombre(String nombre) {
        return lectorRepository.findByNombreContaining(nombre);
    }

    public Lector actualizarLector(Long id, Lector lectorActualizado) {
        return lectorRepository.findById(id)
                .map(lector -> {
                    lector.setNombre(lectorActualizado.getNombre());
                    lector.setIdentificacion(lectorActualizado.getIdentificacion());
                    lector.setContacto(lectorActualizado.getContacto());
                    return lectorRepository.save(lector);
                })
                .orElseGet(() -> {
                    lectorActualizado.setId(id);
                    return lectorRepository.save(lectorActualizado);
                });
    }
    public Optional<Lector> obtenerLectorPorId(Long id) {
        return lectorRepository.findById(id);
    }
    public List<Lector> listarTodos() {
        return lectorRepository.findAll();
    }



}
