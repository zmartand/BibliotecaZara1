package com.example.bibliotecazara1.servicio;
import com.example.bibliotecazara1.entidades.Libro;
import com.example.bibliotecazara1.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizado) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroActualizado.getTitulo());
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setIsbn(libroActualizado.getIsbn());
                    libro.setAnioPublicacion(libroActualizado.getAnioPublicacion());
                    libro.setCantidad(libroActualizado.getCantidad());
                    libro.setEstado(libroActualizado.getEstado());
                    return libroRepository.save(libro);
                })
                .orElseGet(() -> {
                    libroActualizado.setId(id);
                    return libroRepository.save(libroActualizado);
                });
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContaining(titulo);
    }

    public Libro buscarPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

}
