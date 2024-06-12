package gto.talent.tech;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class CharacterStreamsNIOExample {
    public static void main(String[] args) {
        String originalFilePath = "originalFile.txt";
        String copiedFilePath = "copiedFile.txt";

        // Crear un archivo
        createFile(originalFilePath);

        // Leer un archivo
        readFile(originalFilePath);

        // Copiar un archivo
        copyFile(originalFilePath, copiedFilePath);

        // Leer archivo copiado
        readFile(copiedFilePath);
    }

    private static void createFile(String filePath) {
        Path path = Paths.get(filePath);
        String content = "Este es el contenido del archivo original.";
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Archivo creado: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            String content = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println("Leyendo archivo: " + filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String sourceFilePath, String destinationFilePath) {
        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationFilePath);
        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado de " + sourceFilePath + " a " + destinationFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

