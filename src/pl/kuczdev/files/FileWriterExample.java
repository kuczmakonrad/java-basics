package pl.kuczdev.files;

import java.io.FileWriter;
import java.io.IOException;

//zapis do pliku za pomocą FileWriter
public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String textToSave = "ĄBćDĘF_!#(@$_(ŹŹŻŻ";
        char[] charList = textToSave.toCharArray();
        FileWriter out = null;

        System.out.println("SAVING TO FILE_NAME: FW_test_save.txt\nBELOW TEXT:\n" + textToSave);

        try {
            out = new FileWriter("files\\FileWriter_test_save.txt");
            // CO CIEKAWE out.write(textToSave); - tez działa zapisanie całego Stringa bez rozbijania na pętlę
            for (char c: charList) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }
}
