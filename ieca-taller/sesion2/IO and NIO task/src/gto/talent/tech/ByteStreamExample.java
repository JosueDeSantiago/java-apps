package gto.talent.tech;

import java.io.*;

public class ByteStreamExample {
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
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String content = "Este es el contenido del archivo original.";
            fos.write(content.getBytes());
            System.out.println("Archivo creado: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println("Leyendo archivo: " + filePath);
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println(); // Para nueva línea después de leer el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String sourceFilePath, String destinationFilePath) {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            System.out.println("Copiando archivo de " + sourceFilePath + " a " + destinationFilePath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Archivo copiado: " + destinationFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

