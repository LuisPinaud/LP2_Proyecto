package com.proyecto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.model.LibroEntity;
import com.proyecto.repository.LibroRepository;
import com.proyecto.service.LibroService;
import com.proyecto.utils.Utilitarios;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService{
    private final LibroRepository libroRepository;

    @Override
    public List<LibroEntity> listadoLibros() {
        // TODO Auto-generated method stub
        return libroRepository.findAll();
    }

    @Override
    public void registrarLibro(LibroEntity nuevoLibro, MultipartFile imagen) {
        // TODO Auto-generated method stub
        String nombreImagen = Utilitarios.guardarImagen(imagen);
        nuevoLibro.setUrlImagen(nombreImagen);

        libroRepository.save(nuevoLibro);
    }

    @Override
    public LibroEntity buscarLibroPorId(String isbn) {
        // TODO Auto-generated method stub
        return libroRepository.findById(isbn).get();
    }

    @Override
    public void actualizarLibro(String isbn, LibroEntity libroActualizado, MultipartFile imagen) {
        // TODO Auto-generated method stub
        LibroEntity libroEncontrado = buscarLibroPorId(isbn);

        if (libroEncontrado==null) {
            throw new RuntimeException("Libro no encontrado");
        }
        try {
            
            String nombreImagen = Utilitarios.guardarImagen(imagen);
            libroActualizado.setUrlImagen(nombreImagen);

            libroEncontrado.setAutorEntity(libroActualizado.getAutorEntity());
            libroEncontrado.setEditorialEntity(libroActualizado.getEditorialEntity());
            libroEncontrado.setFechapublicacion(libroActualizado.getFechapublicacion());
            libroEncontrado.setCategorias(libroActualizado.getCategorias());
            libroEncontrado.setPrecio(libroActualizado.getPrecio());
            libroEncontrado.setResenia(libroActualizado.getResenia());
            libroEncontrado.setRestriccionEdad(libroActualizado.getRestriccionEdad());
            libroEncontrado.setStock(libroActualizado.getStock());
            libroEncontrado.setTitulo(libroActualizado.getTitulo());
            libroEncontrado.setUrlImagen(libroActualizado.getUrlImagen());
            libroRepository.save(libroEncontrado);
        }catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error al actualizar");
		}
    }

    @Override
    public void eliminarLibro(String isbn) {
        // TODO Auto-generated method stub
        LibroEntity libroEncontrado = buscarLibroPorId(isbn);

        if (libroEncontrado==null) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.delete(libroEncontrado);
    }
}
