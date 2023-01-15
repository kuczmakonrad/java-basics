package pl.kuczdev.__work_questions.final_finalize_finally;

import java.util.ArrayList;
import java.util.List;

/*
1 -
final - ma kilka zastosowań w zależności od miejsca użycia
    * jeżeli klasa jest finalna - to nie może być rozszerzona (nie można po niej dziedziczyć)
    * jeżeli metoda jest finalna - to nie można nadpisać metody (jeżeli dziedziczymy po tej klasie i spróbujemy nadpisać metodę to otrzymamy błąd)
    * jeżeli zmienna jest finalna - to po ustawieniu wartości nie możemy jej zmienić, LECZ:
        ** w przypadku list nie możemy zmienić instancji przypisanej listy, lecz możemy manipulować listą
        ** w przypadku obiektów możemy manipulować danymi obiektu, lecz nie możemy przypisać nowego obiektu (po wcześniejszym przypisaniu)
        ** w przypadku typu prostego nie możemy zmienić wartości po ustawieniu jej

finally - część łańcucha znaków try...catch...finally.
    Blok finally wykona się zawsze niezależnie od tego czy w bloku try...catch zostanie złapany błąd (przydatne np. podczas zamykania zasobów przy połączeniu z DB).

finalize - metoda z klasy Object, która niejawnie rozszerza wszystkie klasy w Javie.
    Metoda ta jest już deprecioned (przestarzała) od stosunkowo niedawna, lecz nie powinniśmy jej używać nigdy.
    Zostaje ona wykonana podczas czyszczenia obiektu przez Garbage Collector - np. służyła do zamknięcia połączeń z DB itd.
    Jej problemem jest to, że obiekty czasami zostają w pamięci.
    Ewentualnie kompilator może stwierdzić, że obiekt nie będzie już używany i uzna, żeby zwolnić jego pamięć - nie ma nad tym zbyt dużej kontroli.
 */


// jeżeli klasę oznaczymy jako final to nie moglibyśmy po niej dziedziczyć w innych klasach
public class BasicNonFinalClass {
    private String name;
    private int lo;
    private final List<String> strList = new ArrayList<>();
    private static final int ID_LETTER = 420;

    // jeżeli metodę oznaczymy jako final to w klasach, które dziedziczą nie możemy jej nadpisać (IDE da nam błąd)
    protected void testingOverride() {
        System.out.println("BASIC NON FINAL CLASS - OVERRIDE!");
    }

    public BasicNonFinalClass(String name, int lo) {
        this.name = name;
        this.lo = lo;

        strList.add("Kasia");
        strList.clear();            // możemy dodawać/czyścić/modyfikować listę oraz obiekty, która jest final, lecz nie możemy przypisać do niej nowej listy
        //strList = new ArrayList<>();  - tego nie możemy zrobić (przypisanie nowej listy, a jedna lista została już zainicjalizowana)
        //ID_LETTER = 4200;   - tego nie możemy zrobić (przypisanie nowej wartości, a wartość została już zainicjalizowana)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }
}
