package pl.kuczdev.files;

import java.io.*;

public class ObjectInputStreamSerialization {
    public static void main(String[] args) throws IOException {
        ObjectInputStream input = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("files\\cars.dat")));

        try {
            while (true) {
                CarObject car = (CarObject) input.readObject();
                System.out.println(car);
            }
        } catch (EOFException e) {
            // koniec pliku
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) input.close();
        }
    }
}
