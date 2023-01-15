package pl.kuczdev.files;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;

        try {
            in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("files\\test.dat")));

            // PRZY ODCZYCIE PLIKU BINARNEGO NALEŻY PAMIĘTAĆ O KOLEJNOŚCI BAJTÓW W ZAPISANYM PLIKU DAT
            // W TAKIEJ KOLEJNOŚCI JAKIEJ ZAPISUJEMY - TO W TAKIEJ MUSIMY ODCZYTAĆ, PONIEWAŻ NIEKTÓRE TYPY ZAJMUJĄ WIĘCEJ BAJTÓW NIŻ INNE
            // W PRZYPADKU POMYŁKI KOLEJNOŚCI - ODCZYTAJĄ SIĘ POTEM INNE BAJTY I BĘDZIE WYKRZACZONY WYNIK
            // ZAWSZE MOŻEMY POMINĄĆ ILEŚ BAJTÓW, JEŻELI KTÓRYŚ TYP CHCEMY POMINĄĆ Z ODCZYTU ZA POMOCĄ METODY SKIP
            System.out.println("READ UTF = " + in.readUTF());          //out.writeUTF("Testowy strumień binarny");
            System.out.println("READ SHORT = " + in.readShort());        //out.writeShort(32000);
            // ZAŁÓŻMY, ŻE NIE CHCEMY ODCZYTYWAĆ LONGA TO MOŻEMY SKIPNĄĆ 8 BAJTÓW, BO TYLE MA LONG
            // System.out.println("READ LONG = " + in.readLong());         //out.writeLong(143104141401L);
            in.skipBytes(8);
            System.out.println("READ FLOAT = " + in.readFloat());        //out.writeFloat(235.0f);
            System.out.println("READ DOUBLE = " + in.readDouble());       //out.writeDouble(13003.3);
            System.out.println("READ BYTE = " + in.readByte());         //out.writeByte(12);
            System.out.println("READ CHAR = " + in.readChar());         //out.writeChar('A');

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
        }
    }
}

//    OUTPUT:
//        READ UTF = Testowy strumień binarny
//        READ SHORT = 32000
//        READ FLOAT = 235.0
//        READ DOUBLE = 13003.3
//        READ BYTE = 12
//        READ CHAR = A