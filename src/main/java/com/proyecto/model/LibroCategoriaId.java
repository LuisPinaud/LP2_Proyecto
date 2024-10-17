package com.proyecto.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class LibroCategoriaId implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String isbn;
    private Integer idCategoria;
	public LibroCategoriaId(String isbn, Integer idCategoria) {
		super();
		this.isbn = isbn;
		this.idCategoria = idCategoria;
	}
	public LibroCategoriaId() {
		super();
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroCategoriaId that = (LibroCategoriaId) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(idCategoria, that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, idCategoria);
    }
}
