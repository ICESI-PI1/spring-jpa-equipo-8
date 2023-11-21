package com.compunet.bookstore.dto;

public class AuthorDTO {
    private Long id;
    private String nombre;

    public AuthorDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public AuthorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
