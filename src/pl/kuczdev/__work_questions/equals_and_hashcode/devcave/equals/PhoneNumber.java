package pl.kuczdev.__work_questions.equals_and_hashcode.devcave.equals;
/*
https://devcave.pl/effective-java/metoda-equals

W tym wpisie zajmiemy się metodą public boolean equals(Object obj), która, jak sama nazwa wskazuje, służy do określania czy dany obiekt jest równy innemu, według określonych przez nas warunków.

    Domyślnie implementacja wygląda tak:

    public boolean equals(Object obj) {
        return (this == obj);
    }

Kiedy nadpisywać metodę equals?
    Kiedy klasa nadaje się do logicznego porównywania, które nie polega tylko na unikatowym identyfikatorze i nie istnieje nadklasa, która już to robi w poprawny sposób.
    Kiedy klasa reprezentuje wartość (np. klasy takie jak Integer lub String).
    Również wiele klas zależy od metody equals i jej dobra implementacja jest wymagana do poprawnego funkcjonowania tych klas.

Kiedy nie nadpisywać metody equals?
    Każda instancja klasy jest unikatowa w systemie (np. Thread).
    Logiczne porównywanie klasy nie ma sensu i jest zbędne (np. Pattern).
    Jeśli istnieje nadklasa, która nadpisuje już equals i to zachowanie jest poprawne dla naszej klasy (np. większość implementacji Set, List czy Map dziedziczy implementację metody equals odpowiednio z AbstractSet, AbstractList i AbstractMap.
    Kiedy klasa sama zarządza swoimi instancjami i zapewnia, że istnieje co najwyżej jedna instancja tej klasy (np. Enum należy do tej kategorii).
    Klasa jest private lub package-private i jesteśmy pewni, że equals nie zostanie nigdy wywołane.


Nadpisując metodę equals musimy zawsze nadpisać również metodę hashCode!

Argument powinien być zawsze typu Object.
 1. Użyj operatora == żeby sprawdzić, czy argument jest referencją do obiektu. Jeśli tak zwróć true.
 2. Użyj operatora instanceof żeby sprawdzić, czy argument jest odpowiedniego typu. Jeśli nie jest, zwróć false.
        Rzutuj argument na odpowiedni typ.
        Dla każdego znaczącego pola w tym obiekcie sprawdź, czy to pole jest równe odpowiadającemu polu w argumencie. Jeśli wszystkie pola się zgadzają, zwróć true, w przeciwnym wypadku false.
        Dla prymitywów z wyjątkiem float i double używaj operatora == do porównywania.
        Dla pól przechowujących referencje do obiektów wywołuj ich equals.
        Dla pól typu float używaj metody Float.compare, a dla double używaj Double.compare.
        Dla tablic stosuj te wskazówki dla każdego elementu. Jeśli każdy element tablicy ma znaczenie, użyj metody Arrays.equals.
        Niektóre z pól mogą być null. Aby uniknąć NullPointerException użyj do porównywania Objects.equals(Object, Object).
        Wydajność metody equals zależy od kolejności kolejnych sprawdzeń. Aby uzyskać najlepszą wydajność, najpierw sprawdzaj pola, które najczęściej będą się różnić i ich porównywanie jest mniej kosztowne.
        Nie porównuj obiektów, które nie są częścią stanu logicznego obiektu.
        Nie porównuj pól, które są pochodnymi innych (ich wynik zależy od innych pól, które już sprawdzasz).
        Sprawdź, czy twoja metoda equals spełnia wszystkie 5 warunków (kontrakt)

KONTRAKT:
Metoda equals dla każdej wartości x, y, z różnej od null powinna być:

        Reflexive - czyli dla x.equals(x) musi zwrócić true.
        Symmetric - czyli dla x.equals(y) musi zwrócić true wtedy i tylko wtedy gdy y.equals(x) zwraca true.
        Transitive - czyli jeśli x.equals(y) zwraca true i y.equals(z) zwraca true to x.equals(z) też musi zwracać true.
        Consistent - czyli wielokrotne wywołanie x.equals(y) bez zmiany parametrów używanych w equals zawsze konsekwentnie zwraca true lub false.
        “Non-nullity” - czyli dla x.equals(null) musi zostać zwrócone false.

Jeśli te warunki nie zostaną spełnione, to wszystkie klasy, które polegają na metodzie equals obiektów (np. klasy kolekcji), będą zachowywać się nieregularnie, niepoprawnie i powodować błędy, dla których może być ciężko znaleźć przyczynę.

*/


public class PhoneNumber {
    private String name;
    private float price;
    private short size;

    public PhoneNumber(String name, double price, int size) {
        this.name = name;
        this.price = rangeCheck(price, 10000.00, "PRICE");
        this.size = rangeCheck(size, 500, "SIZE");
    }

    private static float rangeCheck(double value, double max, String arg) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException(arg + ": " + value);
        }
        return (float) value;
    }

    private static short rangeCheck(int value, int max, String arg) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException(arg + ": " + value);
        }
        return (short) value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof PhoneNumber)) return false;

        PhoneNumber phoneNumber = (PhoneNumber) object;
        return this.name.equals(phoneNumber.name) && this.price == phoneNumber.price && this.size == phoneNumber.size;
    }

    // Jeżeli wiemy, że nie potrzebujemy nadpisywać equals i chcemy być super ostrożni
    /*
    @Override
    public boolean equals(Object o) {
        throw new AssertionError(); // Method is never called
    }
     */
}
