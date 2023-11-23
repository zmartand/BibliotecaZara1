package com.example.bibliotecazara1.controlador;
import com.example.bibliotecazara1.entidades.Libro;
import com.example.bibliotecazara1.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    // Crear un nuevo libro
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.guardarLibro(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    // Obtener un libro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibro(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.actualizarLibro(id, libro));
    }

    // Eliminar un libro por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok().build();
    }

    // Buscar libros por título
    @GetMapping("/buscarPorTitulo")
    public ResponseEntity<List<Libro>> buscarPorTitulo(@RequestParam String titulo) {
        List<Libro> libros = libroService.buscarPorTitulo(titulo);
        return ResponseEntity.ok(libros);
    }

    // Buscar libros por autor
    @GetMapping("/buscarPorAutor")
    public ResponseEntity<List<Libro>> buscarPorAutor(@RequestParam String autor) {
        List<Libro> libros = libroService.buscarPorAutor(autor);
        return ResponseEntity.ok(libros);
    }

    // Buscar libro por ISBN
    @GetMapping("/buscarPorIsbn")
    public ResponseEntity<Libro> buscarPorIsbn(@RequestParam String isbn) {
        Libro libro = libroService.buscarPorIsbn(isbn);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    // Listar todos los libros
    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listarTodosLosLibros() {
        List<Libro> libros = libroService.listarTodos();
        return ResponseEntity.ok(libros);
    }
}
