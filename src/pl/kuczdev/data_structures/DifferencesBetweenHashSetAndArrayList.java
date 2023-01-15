package pl.kuczdev.data_structures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
RÓŻNICE:
1. Implementacja:
   Implementujemy dwa różne interfejsy tj. Set i List podczas tworzenia HashSeta oraz ArrayListy
     a) Set<Integer> setExample = new HashSet<>();
     b) List<Integer> list = new ArrayList<>();

2. Kolejność:
    a) HashSet - jest nieuporządkowaną kolekcją, nie utrzymuje żadnej kolejności wstawiania elementów
    b) ArrayList - utrzymuje kolejność wstawiania elementów

3. Duplikaty:
    a) HashSet - nie pozwala na wstawianie duplikatów
    b) ArrayList - pozwala na wstawianie duplikatów

4. W przypadku obiektów null:
    a) HashSet - obsłuży tylko jeden obiekt null
    b) ArrayList - obsługuje nieskończenie dużą liczbę obiektów null

5. Indeksy i obiekty
    a) HashSet - nie posiada indeksów (nie możemy użyć .get() do pobrania)
    b) ArrayList - używa indeksów, co oznacza, że możemy pobrać indeks za pomocą metody list.getIndex() lub list.remove()
 */

class ListSample {
    public static void main(String[] args) {
        int n = 5;
        List<Integer> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        list.add(null);
        list.add(null);
        list.add(6);
        list.add(6);

        System.out.println(list);
        list.remove(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}

public class DifferencesBetweenHashSetAndArrayList {
    public static void main(String[] args) {
        Set<Integer> setExample = new HashSet<>();
        setExample.add(1);
        setExample.add(2);
        setExample.add(3);
        setExample.add(4);
        setExample.add(4);
        setExample.add(4);          // nie przyjmuje duplikatów wartości, więc będzie tylko pojedyncza 4 w HashSecie
        setExample.add(null);       // nie przyjmuje duplikatów nulli, więc będzie tylko jeden null w HashSecie
        setExample.add(null);

        for (Integer i:setExample) {
            System.out.println(i);
        }
    }
}
