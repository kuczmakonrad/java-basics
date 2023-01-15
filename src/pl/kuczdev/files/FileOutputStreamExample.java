package pl.kuczdev.files;

import java.io.FileOutputStream;
import java.io.IOException;

// ZAPIS DANYCH Z TABLICY ZNAKÓW DO PLIKU
public class FileOutputStreamExample {
    public static void main(String[] args) throws IOException  {
        FileOutputStream out = null;
        char[] saveCharsToFile = {'A','B','C','D','E'};
        try {
            out = new FileOutputStream("files\\original_FileInputStream.txt");
            for (char c: saveCharsToFile) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) out.close();
        }
    }
}
