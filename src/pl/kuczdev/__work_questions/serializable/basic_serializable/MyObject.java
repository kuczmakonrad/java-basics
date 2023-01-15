package pl.kuczdev.__work_questions.serializable.basic_serializable;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class MyObject implements Serializable {
    private static final long serialVersionUID = 1706543832126629912L;  // Generate -> SerialVersionUID (plugin, który zainstalowałem)
    // Po to wygenerowana jest ta zmienna, bo ona sprawdza klasę w serializacji
    // Po zmianie nazwy obiektu w trakcie działania programu (co jest raczej mało możliwe) - bez wygenerowania odpowiedniego UID dla klasy może być problem z serializacją
    // Pokazałem to na przykładzie z zakomentowanym zapisem do pliku i po zmianie nazwy zmiennej - jednakże samo dodanie UID nie pomoże.

    private String name;
    private List<String> objectList;
    public static String VALUE = "20";      // nie można statycznych serializować
    private transient String password;      // pola których nie chcemy serializować oznaczamy słówkiem kluczowym transient

    // to drugi sposób (dwie metody - w których kolejność w obu metodach jest zależna od siebie - inaczej pola będą w innej kolumnie)
    // te metody należy nadpisać
    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        name = stream.readUTF();
        objectList = (List<String>) stream.readObject();
        password = stream.readUTF();
    }

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        stream.writeUTF(name);
        stream.writeObject(objectList);
        stream.writeUTF(password);
    }

    public MyObject(String name, List<String> objectList, String password) {
        this.name = name;
        this.objectList = objectList;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<String> objectList) {
        this.objectList = objectList;
    }

    public static String getVALUE() {
        return VALUE;
    }

    public static void setVALUE(String VALUE) {
        MyObject.VALUE = VALUE;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", objectList=" + objectList +
                ", password='" + password + '\'' +
                '}';
    }
}