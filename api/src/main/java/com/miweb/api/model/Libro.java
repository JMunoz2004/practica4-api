package com.miweb.api.model;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int anio;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
}
