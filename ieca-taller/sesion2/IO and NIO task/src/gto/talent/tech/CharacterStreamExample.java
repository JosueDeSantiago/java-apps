package gto.talent.tech;

import java.io.*;

public class CharacterStreamExample {

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
        try (FileWriter writer = new FileWriter(filePath)) {
            String content = "Este es el contenido del archivo original.";
            writer.write(content);
            System.out.println("Archivo creado: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            System.out.println("Leyendo archivo: " + filePath);
            int content;
            while ((content = reader.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println(); // Para nueva línea después de leer el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String sourceFilePath, String destinationFilePath) {
        try (FileReader reader = new FileReader(sourceFilePath);
             FileWriter writer = new FileWriter(destinationFilePath)) {

            System.out.println("Copiando archivo de " + sourceFilePath + " a " + destinationFilePath);
            int content;
            while ((content = reader.read()) != -1) {
                writer.write(content);
            }
            System.out.println("Archivo copiado: " + destinationFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

