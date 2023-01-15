package pl.kuczdev.files;

import java.io.*;

// Zapis danych do pliku za pomocą zbuforowanych strumieni (szybsze - bo działa na większych partiach bajtów, przez co mniej systemowych wywołań funkcji)
public class BufferedOutputStreamExample {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream out = null;
        String test = "Testowy String";
        char[] chars =  test.toCharArray();
        try {
            out = new BufferedOutputStream(new FileOutputStream("files//BufferedOutputStream_output.txt"));
            for (char c: chars) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }
}
