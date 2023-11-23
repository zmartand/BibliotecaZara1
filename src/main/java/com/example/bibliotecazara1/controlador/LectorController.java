package com.example.bibliotecazara1.controlador;

import com.example.bibliotecazara1.entidades.Lector;
import com.example.bibliotecazara1.servicio.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectores")
public class LectorController {
    @Autowired
    private LectorService lectorService;

    // Crear un nuevo lector
    @PostMapping
    public ResponseEntity<Lector> crearLector(@RequestBody Lector lector) {
        Lector nuevoLector = lectorService.guardarLector(lector);
        return ResponseEntity.ok(nuevoLector);
    }

    // Obtener un lector por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Lector> obtenerLector(@PathVariable Long id) {
        return lectorService.obtenerLectorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un lector existente
    @PutMapping("/{id}")
    public ResponseEntity<Lector> actualizarLector(@PathVariable Long id, @RequestBody Lector lector) {
        return ResponseEntity.ok(lectorService.actualizarLector(id, lector));
    }

    // Eliminar un lector por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLector(@PathVariable Long id) {
        lectorService.eliminarLector(id);
        return ResponseEntity.ok().build();
    }

    // Buscar lectores por nombre
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Lector>> buscarPorNombre(@RequestParam String nombre) {
        List<Lector> lectores = lectorService.buscarPorNombre(nombre);
        return ResponseEntity.ok(lectores);
    }

    // Listar todos los lectores
    @GetMapping("/listar")
    public ResponseEntity<List<Lector>> listarTodosLosLectores() {
        List<Lector> lectores = lectorService.listarTodos();
        return ResponseEntity.ok(lectores);
    }
}