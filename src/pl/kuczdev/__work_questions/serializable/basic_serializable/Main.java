package pl.kuczdev.__work_questions.serializable.basic_serializable;
/*
Serializacja polega na przekształceniu obiektu/ów w javie na sekwencje bajtów.
Sekwencja bajtów zawiera kompletne odwzorowanie tego obiektu.

Jak to rozumieć?
Procesem odwrotnym do serializacji jest deseralizacja, czyli przekształcenie sekwencji bajtów w obiekt (i musi to być dokładnie ten sam obiekt).
Chyba, że będziemy chcieli zaimplementować własny mechanizm serializacji.

Do czego się przydaje?
Możemy zapisywać obiekty do ciągu bajtów w pliku i przesyłać je przez sieć do innego komputera, który może odczytać obiekty z ciągu bajtów w otrzymanym pliku.
Komputer odbiorcy musi mieć JVM.

Również możemy zapisywać obiekty do plików.

Pola, których nie możemy serializować to:
    - pola statyczne
    - wszystkie klasy, które nie implementują interfejsu Serializable (np. jeżeli byśmy zrobili zamiast Listy Stringów, Listę Objectów to nie będziemy mogli serializować, bo Object nie implementuje tego interfejsu)
 */

import java.io.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        // serializacja poprzez zapis obiektu do pliku
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("files\\serialized.file"));
        MyObject objectToSave = new MyObject("nameField", Collections.singletonList("one"),"secret");
        objectOutputStream.writeObject(objectToSave);

        MyObject.VALUE = "2000";        // jak widać statyczne wartości po zmianie nie zostały odczytane (bo się nie zapisują - tylko są częścią klasy)
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("files\\serialized.file"));
        MyObject objectLoaded = (MyObject) objectInputStream.readObject();
        System.out.println(objectLoaded + " " + MyObject.VALUE);
    }

}