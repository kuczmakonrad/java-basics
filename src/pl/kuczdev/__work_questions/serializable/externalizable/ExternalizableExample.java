package pl.kuczdev.__work_questions.serializable.externalizable;

import java.io.*;
/*
Istnieje jeszcze jeden, dużo mniej popularny sposób zapewnienia iż obiekt może być serializowany. Jest nim interfejs Externalizable.
W tym przypadku interfejs ten zawiera dwie metody, które musimy zaimplementować.
Dodatkowo takie klasy muszą mieć konstruktor bezparametrowy, reszta pozostaje bez zmian.
W przypadku tego podejścia cały protokół serializacji, kolejność zapisanych pól, format etc. leży po naszej stronie.
Poniżej prosty przykład, w którym używam właśnie takiego podejścia.

W tym przypadku do utworzenia obiektu mechanizm serializacji używa standardowego konstruktora bezparametrowego.
Po czym wywołuje na tej instancji metodę readExternal.
 */

public class ExternalizableExample implements Externalizable {
    private String field;

    // potrzebny konstruktor bezparametrowy, bo mechanizm serializacji najpierw tworzy z niego obiekt, a potem go odczytuje
    public ExternalizableExample() {
    }

    public ExternalizableExample(String field) {
        this.field = field;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableExample object = new ExternalizableExample("field value");

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("externalizable.bin"))) {
            output.writeObject(object);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("externalizable.bin"))) {
            ExternalizableExample readObject = (ExternalizableExample) input.readObject();
            System.out.println(readObject.field);
        }
    }

    // dwie metody, ktore musimy nadpisac - kolejnosc pol ma znaczenie
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(field);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        field = in.readUTF();
    }
}