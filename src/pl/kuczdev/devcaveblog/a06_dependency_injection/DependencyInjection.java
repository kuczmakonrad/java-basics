package pl.kuczdev.devcaveblog.a06_dependency_injection;

/*
Statyczne klasy utility i singletony nie powinny być stosowane tam, gdzie zachowanie klasy jest sparametryzowane przez wewnętrzne zależności.
W książce pokazane jest to na przykładzie spellcheckera:

    // Inappropriate use of static utility - inflexible & untestable!
    public class SpellChecker {
        private static final Lexicon dictionary = ...;

        private SpellChecker() {} // Noninstantiable

        public static boolean isValid(String word) { ... }
        public static List<String> suggestions(String typo) { ... }
    }


    // Inappropriate use of singleton - inflexible & untestable!
    public class SpellChecker {
        private final Lexicon dictionary = ...;

        private SpellChecker(...) {}
        public static INSTANCE = new SpellChecker(...);

        public boolean isValid(String word) { ... }
        public List<String> suggestions(String typo) { ... }
    }


Oba rozwiązania są niepoprawne, bo zakładają, że istnieje tylko jeden słownik, który jest warty używania.
W praktyce każdy język ma swój własny, a tu nie mamy możliwości reużycia tego kodu z innym.
Również podczas testowania moglibyśmy chcieć użyć jakiegoś specjalnego słownika.

Takie klasy powinny wspierać różne typy tych zależności. To klient powinien je dostarczać.
W takich sytuacjach powinniśmy preferować wstrzykiwanie zależności zamiast definiować je na sztywno.


Wstrzykiwanie zależności (Dependency Injection)
Jest kilka sposobów wstrzykiwania zależności. Dwa najbardziej popularne to:

Constructor injection:
    Najprostszy i zarazem najczęściej wykorzystywany sposób na wstrzykiwanie zależności polega na podaniu ich poprzez konstruktor:

        Client(Service service) {
            this.service = service;
        }


    Jest to preferowany sposób.
        + Zapewnia, że obiekt zawsze jest spójny, bo zależności są wymuszone.
        - Zależności nie mogą zostać zmienione.

    Co wcale nie musi być minusem, bo jest to pierwszy krok, aby klasa była immutable i thread safe.

    Innym wariantem tego wzorca jest podanie fabryki zależności (wzorzec Factory Method) do konstruktora.
    Interfejs Supplier<T> nadaję się do tego idealnie.

Setter injection:
    Tu zależności ustawiamy setterem:

        public void setService(Service service) {
            this.service = service;
        }

    + Elastyczność
        Dzięki temu możemy zmieniać zależności w dowolnym czasie, jednak może się to przerodzić w coś niepożądanego, szczególnie w wielowątkowym środowisku.

    - Brak przymusu podania tej zależności
        Może to prowadzić do niespójnej klasy, bo nic nie wymusza żeby tą zależność podać.
        Aby to osiągnąć trzeba by utworzyć metodę, która sprawdzałaby przed każdym użyciem zależnej funkcji czy ta zależność została ustawiona.

Wstrzykiwanie zależności w dużych projektach z mnóstwem zależności może stać się problematyczne,
dlatego w takich przypadkach warto korzystać z przeznaczonych do tego frameworków, takich jak Spring, Guice czy Dagger, które automatyzują i upraszczają ten proces.

Wstrzykiwanie zależności w Springu:
Różne frameworki mogą dostarczać zautomatyzowany sposób wstrzykiwania zależności.
Np. w Springu wykorzystując adnotację @Autowired, możemy wstrzyknąć zależność będące beanami na 3 sposoby:

    @Component
    public class FooFormatter {

        public String format() {
            return "foo";
        }
    }


1. Wstrzykiwanie bezpośrednio w pole:

        public class FooService {

            @Autowired
            private FooFormatter fooFormatter;

            public void doSomething() {
                fooFormatter.format();
                //...
            }
        }

    Dzięki adnotacji @Autowired obiekt fooFormatter będzie automatycznie wstrzykiwany przez Springa i od razu dostępny do użycia.
    Nie ma potrzeby ręcznego podawania zależności.

    Jest to najczęściej nadużywana opcja, szczególnie przez początkujących i nie jest zalecaną praktyką.

    Minusy:
        - Uniemożliwia ręczne wstrzyknięcie zależności bez automagii framworka (refleksja) np. podczas testowania.
        - Używając tego rozwiązania nie jesteśmy też w stanie zadeklarować zmiennej jako final.
        - Ukrywany jest fakt, że klasa ma zależność. Nic nie stoi na przeszkodzie, żeby zrobić coś takiego:

                FooService fooService = new FooService();
                fooService.doSomething();

        Co oczywiście skutkuje NullPointerException.

    Jest to najłatwiejszy sposób dodawania zależności, bo wystarczy dodać kolejne pole @Autowired, jednak nie koniecznie jest to zaleta.
    Przez to jesteśmy kuszeni, aby dodawać bezboleśnie kolejne zależności, aż w końcu nasz klasa będzie God klasą z 10+ zależnościami.
    Używając wstrzykiwania przez konstruktor od razu widać, kiedy przesadzamy z liczbą zależności.
    Generalnie jeśli klasa ma więcej niż 4-5 zależności trzeba się zastanowić czy przypadkiem nie robi za dużo i nie narusza Single Responsibility Principle.


2. Wstrzykiwanie poprzez konstruktor:

    public class FooService {

        private FooFormatter fooFormatter;

        @Autowired
        public FooService(FooFormatter fooFormatter) {
            this.fooFormatter = fooFormatter;
        }
    }


    Od Spring 4.3, jeśli klasa posiada tylko jeden konstruktor, to adnotacja @Autowired nie jest wymagana.
    Z kolei jeśli klasa definiuje kilka konstruktorów, to musimy oznaczyć jeden z nich, aby pokazać kontenerowi DI, którego ma użyć.

    Jest to najbardziej preferowana opcja.
    W niektórych framworkach (patrz Angular) jest to tak faworyzowany sposób, że jest on jedynym sposobem wstrzykiwania zależności.

    Plusy:
        + Nie utrudnia testowania
        + Nie jesteśmy uzależnieniu od adnotacji @Autowired
        + Można łatwo zobaczyć kiedy przesadzamy z zależnościami
        + Zależności mogą być immutable - możemy zadeklarować zależności jako final.
        + Zalecany przez twórców springa - link


3. Wstrzykiwanie poprzez setter

    public class FooService {

        private FooFormatter fooFormatter;

        @Autowired
        public void setFooFormatter(FooFormatter fooFormatter) {
            this.fooFormatter = fooFormatter;
        }
    }


Ten wariant ma podobne minusy co wstrzykiwanie bezpośrednio w pole,
ale przynajmniej nie ukrywa, że klasa zależy od FooFormatter i umożliwia podanie jej w łatwy sposób.
To rozwiązanie może być stosowane do podawania opcjonalnych zależności (bo nie jest to wymuszone jak w przypadku konstruktora),
jednak w większości wypadków preferowane jest wstrzykiwanie zależności przez konstruktor.



Dlaczego wstrzykiwać zależności:
Wstrzykiwanie zależności niesie ze sobą wiele korzyści i sprawia, że klasy:

    + Są bardziej elastyczne (decoupling)
        Klasa jest uniezależniona od konkretnej implementacji. Dzięki temu jest konfigurowalna przez klienta, co sprzyja reużywalności i łatwości w utrzymaniu.

    + Są łatwiejsze do przetestowania
        Można w łatwy sposób mockować takie zależności i testować je w izolacji.

Podsumowując, świadome korzystanie z wstrzykiwania zależności ma niemal same zalety,
a preferowanym sposobem wstrzykiwania zależności jest ten z wykorzystaniem konstruktora.
*/

public class DependencyInjection {
}
