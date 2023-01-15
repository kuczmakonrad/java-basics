package pl.kuczdev.__work_questions.serializable.custom_serializable;

import java.io.*;

public class CustomSerialization implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient int someField;
    private String otherField;

    public CustomSerialization(int someField, String otherField) {
        this.someField = someField;
        this.otherField = otherField;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomSerialization writtenObject = new CustomSerialization(10, "something");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("custom-serialization.bin"))) {
            outputStream.writeObject(writtenObject);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("custom-serialization.bin"   ))) {
            CustomSerialization readObject = (CustomSerialization) inputStream.readObject();
            System.out.println(readObject.someField);
            System.out.println(readObject.otherField);
        }
    }
/*
Warto tutaj zwrócić uwagę na to, że klasa ObjectInputStream posiada metodę defaultReadObject, która przeprowadza standardową deserializację, którą możesz rozszerzyć.
Podobnie wygląda to w przypadku klasy ObjectOutputStream i metody defaultWriteObject. Metody te mogą być wywołane wyłącznie w trakcie (de)serializacji obiektu.
Zajmują się one (de)serializacją atrybutów klasy, które nie są oznaczone jako static lub transient.
 */
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        someField = stream.readInt();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(someField + 1000);
    }
}