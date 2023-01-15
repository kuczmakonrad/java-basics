package pl.kuczdev.files;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("files\\testFile.txt");

        if (!file.exists()) {
            boolean created = file.createNewFile();
            System.out.println("Wynik utworzenia pliku: " + created);
        } else {
            System.out.println("Plik już istnieje!");

            System.out.println("Czy można czytać plik: " + file.canRead());
            System.out.println("Czy można zapisać do pliku: " + file.canWrite());
            System.out.println("Czy to zwykły plik: " + file.isFile());
            System.out.println("Czy plik jest katalogiem: " + file.isDirectory());
            System.out.println("Nazwa pliku: " + file.getName());
            System.out.println("Katalog, w którym jest plik: " + file.getParent());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Czy jest to ukryty plik: " + file.isHidden());
            System.out.println("Wielkość pliku (w bajtach): " + file.length());

            long lastModified = file.lastModified();
            System.out.println("Ostatnio zmodyfikowany: " + new Date(lastModified) );

            // wylistowanie plików z katalogu
            File filesDir = new File("files");

            if (filesDir.exists()) {
                String files[] = filesDir.list();
                System.out.println("\n\nLista plików w katalogu files: ");

                for (String f : files) {
                    System.out.println(f);
                }
            }


            // tworzenie nowego podkatalogu
            File dir = new File("files\\test_dir");

            if (!dir.exists()) {
                dir.mkdir();
            }
        }
    }
}