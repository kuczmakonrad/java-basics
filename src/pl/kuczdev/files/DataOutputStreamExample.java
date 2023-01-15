package pl.kuczdev.files;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("files\\test.dat")));

            out.writeUTF("Testowy strumień binarny");
            out.writeShort(32000);
            out.writeLong(143104141401L);
            out.writeFloat(235.0f);
            out.writeDouble(13003.3);
            out.writeByte(12);
            out.writeChar('A');

            out.flush();            // Wymuszenie zapisu z bufora
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }
}
