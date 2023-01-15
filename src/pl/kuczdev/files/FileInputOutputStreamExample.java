package pl.kuczdev.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//KOPIOWANIE Z PLIKU DO PLIKU
public class FileInputOutputStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("files\\original_FileInputStream.txt");
            out = new FileOutputStream("files\\copy_FileOutputStream.txt");
            int i = 0;
            while( (i = in.read()) != -1) {
                out.write(i);
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}
