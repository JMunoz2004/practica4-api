package com.apiweb.controller;

import com.apiweb.model.Producto;
import com.apiweb.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Crear
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Leer todos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Leer por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto detalles) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre(detalles.getNombre());
            p.setPrecio(detalles.getPrecio());
            return ResponseEntity.ok(productoRepository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
