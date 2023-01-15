package pl.kuczdev.__work_questions.serializable.avoid_serializable_subclass;

import java.io.*;

class Engine implements Serializable {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DieselEngine extends Engine {
    public DieselEngine(String name) {
        super(name);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException("DieselEngine isn't serializable!");
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new NotSerializableException("DieselEngine isn't serializable!");
    }
}

public class AvoidSerializableInSubclass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Engine writtenObject = new Engine("something");
        //DieselEngine writtenObject = new DieselEngine("something"); -- Exception in thread "main" java.io.NotSerializableException: DieselEngine isn't serializable!

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("custom-serialization.bin"))) {
            outputStream.writeObject(writtenObject);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("custom-serialization.bin"   ))) {
            Engine readObject = (Engine) inputStream.readObject();
            System.out.println(readObject.getName());
        }
    }

}
