package com.miweb.api.controller;

import com.miweb.api.model.Libro;
import com.miweb.api.repository.LibroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // CREATE
    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    // READ - obtener todos
    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    // READ - por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(libroActualizado.getTitulo());
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setAnio(libroActualizado.getAnio());
                    libroRepository.save(libro);
                    return ResponseEntity.ok(libro);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (!libroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        libroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
