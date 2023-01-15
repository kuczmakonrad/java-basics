package pl.kuczdev.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

// ODCZYT DANYCH Z PLIKU
public class FileInputStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        ArrayList<Character> result = new ArrayList<>();
        try {
            in = new FileInputStream("files\\original_FileInputStream.txt");
            int num = 0;
            while ((num = in.read()) != -1) {
                System.out.print((char) num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) in.close();
        }
    }
}
