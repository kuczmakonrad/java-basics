package pl.kuczdev.devcaveblog.a36_varargs_nulls_and_optionals;

/*
Używanie varargs:
    Co to są varargs?
    Jest to po prostu zmienna ilość parametrów zadeklarowana jako jeden argument.
    Można to porównać do tablicy - może przechowywać zero lub więcej argumentów.
    Pod spodem działa to tak że tworzona jest tablica wielkości liczby podanych elementów,
    a następnie te wartości są w niej umieszczane i do metody przekazywana jest tablica.

    Przykładowe proste użycie varargs:

        // Simple use of varargs
        static int sum(int... args) {
            int sum = 0;
            for (int arg : args)
                sum += arg;
            return sum;
        }


    Varargs deklaruje się za pomocą ... dodanym do typu. I np. sum(1, 2, 3) zwróci 6, a sum() zero.
    Myślę, że działanie jest dosyć jasne.

    Varargs nie nadają się jednak w przypadku, gdy chcemy mieć przynajmniej jeden argument, np. chcąc policzyć minimum.
    Musielibyśmy wtedy dodać specjalne sprawdzenie:

        // The WRONG way to use varargs to pass one or more arguments!
        static int min(int... args) {
            if (args.length == 0)
                throw new IllegalArgumentException("Too few arguments");
            int min = args[0];
            for (int i = 1; i < args.length; i++)
                if (args[i] < min)
                    min = args[i];
            return min;
        }


    Jednak to rozwiązanie nie jest dobre:
        * sprawdzenie odbywa się dopiero w runtime, więc nie widać błedu podczas pisania kodu,
        * jest brzydkie i nadmiarowe.

    Jest na to dużo lepszy sposób - zadeklarować metodę przyjmującą pierwszy argument, a jako drugi argument podać varargs:

        // The right way to use varargs to pass one or more arguments
        static int min(int firstArg, int... remainingArgs) {
            int min = firstArg;
            for (int arg : remainingArgs)
                if (arg < min)
                    min = arg;
            return min;
        }

    W super ekstremalnych warunkach (w których prawdopodobnie nigdy nie będziesz), gdzie liczy się wydajność i wiemy,
    że np. 90% wywołań ma mniej niż 3 argumenty, możemy użyć kilku przeciążeń metody, aby uniknąć nadmiarowego tworzenia tablic:

        public void foo() { }
        public void foo(int a1) { }
        public void foo(int a1, int a2) { }
        public void foo(int a1, int a2, int a3) { }
        public void foo(int a1, int a2, int a3, int... rest) { }


   Statyczne fabryki dla EnumSet w standardowej bibliotece używają tej techniki.

Zwracaj puste kolekcje, nie nulle:
    Czasem można spotkać metody podobne do tej:

        // Returns null to indicate an empty collection. Don't do this!
        private final List<Cheese> cheesesInStock = ...;

        // @return a list containing all of the cheeses in the shop, or null if no cheeses are available for purchase.
        public List<Cheese> getCheeses() {
                return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
        }


    Nie ma powodu, aby traktować puste kolekcje w specjalny sposób i zwracać null, jeśli są puste.
    Na pewno nie jest to też dobra praktyka. Dodatkowo zmusza to klienta, by obsłużyć tę sytuację w miejscach, gdzie normalnie by tego nie robił:

        List<Cheese> cheeses = shop.getCheeses();
        if (cheeses != null && cheeses.contains(Cheese.STILTON))
            System.out.println("Jolly good, just the thing.");


    Argumenty typu, że powinny być preferowane nulle, ponieważ wtedy nie alokujemy pamięci na pusty kontener, nie mają sensu w dzisiejszych aplikacjach.
    Martwienie się wydajnością na tym poziomie jest zbędną przedwczesną optymalizacją, która w 95% nie przyniesie żadnej korzyści.

    Ponadto używając niemutowalnych pustych kolekcji typu Collections.emptyList, Collections.emptySet czy Collections.emptyMap całkowicie eliminujemy ten problem,
    bo wtedy reużywamy jedną i tą samą pustą kolekcję.

    Podobnie wygląda sytuacja dla tablic, nie powinno się zwracać nulli zamiast pustej tablicy.

    Lekcja z tego tematu jest jasna - nie zwracaj nulli zamiast pustych kolekcji czy tablic. Pogarsza to tylko kod klienta i nie ma żadnych sensownych korzyści.


Zwracanie Optional:
    Przed Java 8 mieliśmy dwa sposoby na pisanie metod, które nie mogłyby zwrócić danej wartości w określonych warunkach.
    Można było albo rzucić wyjątkiem, albo po prostu zwrócić null (jeśli zwracany typ nie był prymitywem).
    Żaden z nich nie był idealnym sposobem.
    Wyjątki powinny być stosowane tylko w wyjątkowych sytuacjach, a do tego rzucanie wyjątku jest nieco kosztowne,
    bo wraz z wyjątkiem tworzony jest cały stack trace.

    Zwracanie nulla nie ma tych wad, jednak tak samo wymaga od klienta specjalnego obsłużenia, które czasem nie jest oczywiste.

    Od Javy 8 jest też trzeci wbudowany sposób - klasa Optional<T>.
    Reprezentuje ona niemutowalny kontener, który może przetrzymywać pojedynczą referencję do obiektu (która nie jest nullem) lub nic, czyli może być pusty.

    Więc gdy metoda zwraca T, ale jak pod jakimiś warunkami może nie być w stanie zwrócić T, to wtedy może zadeklarować zwracany typ jako Optional<T>.

    Metoda, która zwraca Optional jest nieco bardziej elastyczna i łatwiejsza w użyciu niż rzucanie i obsługa wyjątku czy zwracanie nulla + obsługa.
    Czasem może nie być oczywiste, że metoda może zwrócić null, zwłaszcza gdy nie mamy dostępu do dokumentacji lub jej po prostu nie ma.
    Dzięki Optional mamy tę informację bezpośrednio w API i jest jasne, że metoda może nie być w stanie zwrócić tej wartości.

    Przykładowe użycie:

        // Returns maximum value in collection as an Optional<E>
        public static <E extends Comparable<E>>
                Optional<E> max(Collection<E> c) {
            if (c.isEmpty())
                return Optional.empty();

            E result = null;
            for (E e : c)
                if (result == null || e.compareTo(result) > 0)
                    result = Objects.requireNonNull(e);

            return Optional.of(result);
        }


    Jak widać, jest to całkiem proste.
    Bez Optional metoda mogłaby rzucić IllegalArgumentException, gdyby kolekcja z parametru była pusta, jednak wtedy kod klienta nie byłby tak czysty w użyciu,
    bo wymagałby boilerplatu try catch.

    Jest też wariant, który może przyjąć null: Optional.ofNullable(value) i zwraca pusty Optional, jeśli został podany null.

    Użycie Optional można spotkać w standardowej blibliotece np. używając streamów.

    Czy zawsze jednak warto stosować Optional zamiast null czy rzucenia wyjątkiem?

    Optionale są podobne w założeniu co rzucanie checked exception - oba jasno informują klienta API, że wartość może być nie zwrócona,
    jednak te drugie wymagają od niego więcej boilerplate-u.

    Optionale oferują nam do dyspozycji kilka pomocnych metod, które pozwalają pisać zwięzły kod. Np.: możemy podać domyślną wartość:

        // Using an optional to provide a chosen default value
        String lastWordInLexicon = max(words).orElse("No words...");


    lub rzucić wyjątkiem:

        // Using an optional to throw a chosen exception
        Toy myToy = max(toys).orElseThrow(TemperTantrumException::new);


    Zauważ, że podawana jest referencja do konstruktora, więc wyjątek nie zostanie utworzony, dopóki nie zajdzie taka potrzeba.

    Inne przykłady to orElseGet, który przyjmuje Supplier<T>, by uniknąć kosztu tworzenia obiektu zbyt wcześnie oraz filter, map, flatMap czy ifPresent.

    W Javie 9 dodano także or i ifPresentOrElse.

    Warto znać te inne metody, bo czasem można zwięźle zastąpić nimi zwykłe sprawdzania isPresent.
    Dla przykładu metoda, która pokazuje ID parenta danego procesu lub N/A, jeśli go nie ma:

        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("Parent PID: " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "N/A"));


    A tak wygląda to samo z wykorzystaniem metody map:

        System.out.println("Parent PID: " +  ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));


    Optionalów nie powinno się używać do opakowywania kolekcji, podobnie jak w przypadku zwracania null, gdy są puste.

    Odpowiadając wreszcie na pytanie - Optionale są bardzo dobrą alternatywą dla nulli i rzucania wyjątków, gdy metoda nie może zwrócić danej wartości.
    Jedyna opcja gdzie mógłoby to być nieodpowiednie, to w sytuacjach, gdzie wydajność jest krytyczna i takie mikro optymalizacje mają sens,
    ale w 95% przypadkach tak nie jest.


Dokumentacja:
    Jeśli publiczne API ma być użyteczne, powinno być udokumentowane, dlatego zwieńczeniem naszej pracy powinna być dokumentacja.

    W Javie mamy narzędzie Javadoc, które ułatwia nam to, generując dokumentację API automatycznie z kodu źródłowego.

    Konwencje dokumentacji nie są częścią języka, jednak są swojego rodzaju API, które każdy programista powinien znać.
    Te konwencje są opisane na stronie How to Write Doc Comments (https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
    jednak nie była ona updatowana od Javy 4 i nie ma opisanych kilku tagów dodanych w Javie:

        9 - {@index}
        8 - {@implSpec}
        5 - {@literal}, {@code}

    Publiczne API powinno mieć udokumentowane co najmniej każdą publiczną klasę, interfejs, konstruktor, metodę i pole.

    Resztę szczegółów z tego tematu pozwoliłem sobie pominąć - jakby ktoś chciał zobaczyć przykłady i wprowadzenie w temat to odsyłam do Introduction to Javadoc:
         https://www.baeldung.com/javadoc




*/

public class VarargsNullsAndOptionals {
}
