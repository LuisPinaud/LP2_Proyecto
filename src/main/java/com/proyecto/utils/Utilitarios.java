package com.proyecto.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class Utilitarios {
    public static String guardarImagen(MultipartFile imagen){
        try {
            Path pathDire = Paths.get("src/main/resources/static/img/guardados/");
            if (!Files.exists(pathDire)) {
                Files.createDirectories(pathDire);
            }

            byte[] bytes = imagen.getBytes();
            Path path = Paths.get("src/main/resources/static/img/guardados/"+imagen.getOriginalFilename());

            Files.write(path, bytes);
            
            return imagen.getOriginalFilename();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }
}
