package pl.kuczdev.__fast_testing.array_delete_duplicate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> testArr = new ArrayList<>();
        testArr.add("Michał");
        testArr.add("Michał");
        testArr.add("Michał");
        testArr.add("Kamila");
        testArr.add("Konrad");
        testArr.add("Grażyna");


        System.out.println("Cała lista przed usunięciem: " + testArr);

        for (int i = 0; i < testArr.size(); i++) {
            System.out.println("Na indeksie " + i + " w liście znajduje się wartość: " + testArr.get(i));
        }

        System.out.println("-----------------");
        testArr.remove("Michał"); // usunięcie duplikatu za pomocą metody remove - metoda remove znajdzie pierwszy element (na indeksie 0) i usunie go
                                    // następnie przesunie pozostałe elementy w lewo o jeden indeks i pomniejszy listę (nie usunie wszystkich Michałów, jeżeli nie powtórzymy operacji jeszcze dwukrotnie).

        System.out.println("Cała lista po usunięciu: " + testArr);

        for (int i = 0; i < testArr.size(); i++) {
            System.out.println("Na indeksie " + i + " w liście znajduje się wartość: " + testArr.get(i));
        }


    }
}
