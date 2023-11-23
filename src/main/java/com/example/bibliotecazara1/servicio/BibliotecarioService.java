package com.example.bibliotecazara1.servicio;

import com.example.bibliotecazara1.entidades.Bibliotecario;
import com.example.bibliotecazara1.repositorios.BibliotecarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService {
    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public Bibliotecario guardarBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public void eliminarBibliotecario(Long id) {
        bibliotecarioRepository.deleteById(id);
    }

    public List<Bibliotecario> buscarPorNombre(String nombre) {
        return bibliotecarioRepository.findByNombreContaining(nombre);
    }
    public Optional<Optional<Bibliotecario>> actualizarBibliotecario(Long id, Bibliotecario bibliotecarioActualizado) {
        return bibliotecarioRepository.findById(id)
                .map(bibliotecario -> {
                    bibliotecario.setNombre(bibliotecarioActualizado.getNombre());
                    bibliotecario.setIdentificacion(bibliotecarioActualizado.getIdentificacion());
                    bibliotecario.setContacto(bibliotecarioActualizado.getContacto());
                    return Optional.of(bibliotecarioRepository.save(bibliotecario));
                });
    }

}