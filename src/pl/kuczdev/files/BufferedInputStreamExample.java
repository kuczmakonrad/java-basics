package pl.kuczdev.files;

import java.io.*;

// Odczyt danych z pliku za pomocą zbuforowanych strumieni (szybsze - bo działa na większych partiach bajtów, przez co mniej systemowych wywołań funkcji)
public class BufferedInputStreamExample {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("files//original_FileInputStream.txt"));
            int v;
            while ( (v = in.read()) != -1) {
                System.out.print((char) v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
        }
    }
}
