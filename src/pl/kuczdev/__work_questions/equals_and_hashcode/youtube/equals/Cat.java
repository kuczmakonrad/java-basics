package pl.kuczdev.__work_questions.equals_and_hashcode.youtube.equals;

/*
Equals() - metoda która znajduje się w klasie Object.
Służy do porównywania obiektów czy są sobie równe.
Jeżeli jej nie nadpiszemy to klasa porównuje obiekty za pomocą operatora ==, czyli sprawdza czy obiekty wskazują na to samo miejsce w pamięci.

Kontrakt equals (czyli zasady, które metoda equals musi spełniać):
	1. reflexive - dla każdej nie nullowej referencji a, a.equals(b) powinno zwrócić true.
	2. symmetric - dla każdej nie nullowej referencji a i b, a.equals(b) powinno zwrócić true, wtedy kiedy b.equals(a).
	3. transitive - dla każdej nie nullowej referencji a, b i c, jeśli a.equals(b) zwraca true i b.equals(c) zwraca true, to a.equals(c) również powinno zwrócić true.
	4. consistent - dla każdej nie nullowej referencji a i b, wielokrotne wywoływania a.equals(b) powinny za każdym razem zwracać true lub za każdym razem zwracać false, o ile w międzyczasie dane obiekty nie zostały zmienione.
	5. Dla każdej nie nullowej referencji a, a.equals(null) powinno zwracać false.

 */
public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        // sprawdzenie czy obiekt klasy wskazuje na przekazany obiekt
        if (this == object) {
            return true;
        }
        // sprawdzenie czy przekazany obiekt nie jest pusty
        if (object == null) {
            return false;
        }

        // sprawdzenie czy przekazany obiekt jest innej klasy
        if (!(object instanceof Cat)) {
            return false;
        } else {
            Cat o = (Cat) object;

        if (name.equals(o.name) && age == o.age) {          // sprawdzenie wartości w obiektach
                return true;
            } else {
                return false;
            }
        }
    }

    // Ta sama metoda wygenerowana przez inteliJ
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }
     */
}
