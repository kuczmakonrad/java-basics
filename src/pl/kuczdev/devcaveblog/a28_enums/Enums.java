package pl.kuczdev.devcaveblog.a28_enums;

/*
Ten rozdział zawiera rady dotyczące używania enumów i adnotacji.

Na początku myślałem, że pominę ten rozdział jako że nie wnosi zbyt dużo, ale część porad jest przydatna, dlatego uznałem, że wyciągnę najważniejsze informacje
z każdego tematu i podzielę to na 2 posty - o enumach i adnotacjach.
Zacznijmy więc enumów:

Enumy zamiast stałych typu int:
    Typ enum reprezentuje stały zbiór wartości, który jest nam znany przed uruchomieniem programu, np. pory roku, planety, czy kolory kart.
    Zanim enumy były dodane do Javy, często deklarowano grupę podobnie nazwanych stałych typu int:

        // The int enum pattern - severely deficient!
        public static final int APPLE_FUJI         = 0;
        public static final int APPLE_PIPPIN       = 1;
        public static final int APPLE_GRANNY_SMITH = 2;
        public static final int ORANGE_NAVEL  = 0;
        public static final int ORANGE_TEMPLE = 1;
        public static final int ORANGE_BLOOD  = 2;


    Jest to znane jako int enum pattern i ma wiele wad i braków - nie powinniśmy już korzystać z tego typu stałych.
    Nie mamy tu żadnego bezpieczeństwa typów. Nie mają reprezentacji tekstowej, więc np. debuggując zobaczymy tylko cyferki.
    Nie mamy też możliwości iterowania po wszystkich elementach ani sprawdzenia ile ich jest.
    Wszystkie te problemy rozwiązują enumy, a nawet dają jeszcze więcej korzyści. Odpowiednik można zdefiniować tak:

        public enum Apple  { FUJI, PIPPIN, GRANNY_SMITH }
        public enum Orange { NAVEL, TEMPLE, BLOOD }


    Enumy w Javie to pełnoprawne klasy, więc oferują dużo więcej niż zwykłe wartości int.
    Są to klasy, które dostarczają tylko jedną instancję dla każdej stałej i udostępniają ją poprzez pole public static final.
    Enumy są niemutowalne, nie posiadają publicznego konstruktora.
    Dostajemy też type safty, jako że są to pełnoprawne klasy.
    Dostarczają również implementacje wszystkich metod z klasy Object (były omawiane w rozdziale 3) oraz implementują Comparable i Serializable.
    Co więcej, pozwalają też na zdefiniowanie własnych metod i pól.
    Przykład bogatej klasy enum:

        // Enum type with data and behavior
        public enum Planet {
            MERCURY(3.302e+23, 2.439e6),
            VENUS(4.869e+24, 6.052e6),
            EARTH(5.975e+24, 6.378e6),
            MARS(6.419e+23, 3.393e6),
            JUPITER(1.899e+27, 7.149e7),
            SATURN(5.685e+26, 6.027e7),
            URANUS(8.683e+25, 2.556e7),
            NEPTUNE(1.024e+26, 2.477e7);

            private final double mass;           // In kilograms
            private final double radius;         // In meters
            private final double surfaceGravity; // In m / s^2

            // Universal gravitational constant in m^3 / kg s^2
            private static final double G = 6.67300E-11;

            // Constructor
            Planet(double mass, double radius) {
                this.mass = mass;
                this.radius = radius;
                surfaceGravity = G * mass / (radius * radius);
            }

            public double mass() {
                return mass;
            }

            public double radius() {
                return radius;
            }

            public double surfaceGravity() {
                return surfaceGravity;
            }

            public double surfaceWeight(double mass) {
                return mass * surfaceGravity;  // F = ma
            }
        }


    Liczby w nawiasach po każdej planecie (stałej) to argumenty do konstruktora.
    Mając masę i promień planety, możemy policzyć jej przyspieszenie grawitacyjne (surfaceGravity), a to z kolei pozwala nam obliczyć,
    ile będzie ważył dany obiekt (o znanej masie na ziemi) na powierzchni każdej planety (metoda surfaceWeight(double mass)).

    Enumy z natury są niemutowalne, dlatego wszystkie jej pola powinny być zadeklarowane jako final.
    Pola mogą być publiczne, ale lepiej zadeklarować je jako prywatne z getterami (gettery i settery).

    Tak wygląda użycie:

        double earthWeight = 50;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", planet, planet.surfaceWeight(mass));
        }

        OUTPUT:
            Weight on MERCURY is 26.453469
            Weight on VENUS is 63.353571
            Weight on EARTH is 70.000000
            Weight on MARS is 26.572280
            Weight on JUPITER is 177.077561
            Weight on SATURN is 74.585988
            Weight on URANUS is 63.339884
            Weight on NEPTUNE is 79.53844


    Czasem potrzebujemy innego zachowania dla każdej stałej i jak najbardziej enumy to wspierają.
    Możemy to zrobić to tak:

        // Enum type with constant-specific method implementations
        public enum Operation {
          PLUS  {public double apply(double x, double y){return x + y;}},
          MINUS {public double apply(double x, double y){return x - y;}},
          TIMES {public double apply(double x, double y){return x * y;}},
          DIVIDE{public double apply(double x, double y){return x / y;}};

          public abstract double apply(double x, double y);
        }


    Robiąc to w ten sposób, za każdym razem, gdy dodajemy nowe pole, jesteśmy zmuszeni dodać implementację metody apply.

    Podsumowując, enumy są bardziej czytelne, bezpieczniejsze i mają dużo więcej możliwości niż zwykłe stałe, dlatego warto je stosować za każdym razem,
    gdy mamy zbiór stałych wartości ze wspólnej grupy, które znamy przed uruchomieniem programu.


Pola instancji enuma zamiast polegania na kolejności zadeklarowania stałych:
    Tutaj omawiany jest dosyć specyficzny przypadek użycia metody ordinal, która zwraca liczbę będącą pozycją stałej, na której nie powinniśmy polegać:

        // Abuse of ordinal to derive an associated value - DON'T DO THIS
        public enum Ensemble {
            SOLO,   DUET,   TRIO, QUARTET, QUINTET,
            SEXTET, SEPTET, OCTET, NONET,  DECTET;

            public int numberOfMusicians() { return ordinal() + 1; }
        }

    Obecna forma enuma będzie działać zgodnie z założeniami, jednak gdy będziemy chcieli coś w niej zmienić,
    to metoda numberOfMusicians nie będzie działać prawdiłowo, ponieważ polega na kolejności zadeklarowanych stałych.

    Jeśli chcielibyśmy dodać DOUBLE_QUARTET, który składa się z 8 osób, to nie ma już takiej opcji, bo jest to zajęte przez OCTET.
    Również nie możemy dodać opcji TRIPLE_QUARTE (12 osób), bo nie ma określenia na 11 osób.
    Dlatego nie powinno się korzystać z tej metody w takich przypadkach.
    Nawet w specyfikacji jest taka notka:
        “Most programmers will have no use for this method. It is designed for use by general-purpose enum-based data structures such as EnumSet and EnumMap.”

    W takich przypadkach lepiej skorzystać po prostu z pól instancyjnych:

        public enum Ensemble {
            SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
            SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
            NONET(9), DECTET(10), TRIPLE_QUARTET(12);

            private final int numberOfMusicians;
            Ensemble(int size) { this.numberOfMusicians = size; }
            public int numberOfMusicians() { return numberOfMusicians; }
        }


EnumSet zamiast pól bitowych:
    Bardzo prosty przekaz - używajmy klasy EnumSet, gdy chcemy przekazywać kilka stałych z jednej grupy.
    Kiedyś to można było robić ręcznie, używając operacji bitowych:

        // Bit field enumeration constants - OBSOLETE!
        public class Text {
            public static final int STYLE_BOLD          = 1 << 0;  // 1
            public static final int STYLE_ITALIC        = 1 << 1;  // 2
            public static final int STYLE_UNDERLINE     = 1 << 2;  // 4
            public static final int STYLE_STRIKETHROUGH = 1 << 3;  // 8

            // Parameter is bitwise OR of zero or more STYLE_ constants
            public void applyStyles(int styles) { ... }
        }

    Ta reprezentacja stałych pozwala łączyć je, używając operacji bitowej OR:

        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);


    A tak powinno to wyglądać w dzisiejszych czasach:

        // EnumSet - a modern replacement for bit fields
        public class Text {
            public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

            // Any Set could be passed in, but EnumSet is clearly best
            public void applyStyles(Set<Style> styles) { ... }
        }


    I użycie:

        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));


    Cały ciężar implementacji i poprawności operacji bitowych zrzucamy na EnumSet dodatkowo zyskując przejrzystość i type safty.


EnumMap zamiast indexowania metodą ordinal:
    Podobnie jak wyżej, używajmy EnumMap zamiast ręcznego indexowania tablicy za pomocą metody ordinal.
    Na przykładzie prostej klasy Plant:

        class Plant {
            enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

            final String name;
            final LifeCycle lifeCycle;

            Plant(String name, LifeCycle lifeCycle) {
                this.name = name;
                this.lifeCycle = lifeCycle;
            }

            @Override public String toString() {
                return name;
            }
        }


    Załóżmy, że mamy tablicę roślin i chcemy poukładać je według cyklu życia.
    Potrzebowalibyśmy 3 setów, jeden dla każdego cyklu, i przeiterować po tablicy wkładając rośliny do odpowiednich setów.
    Można byłoby to zrobić indexując tablice przy pomocy metody ordinal:

        // Using ordinal() to index into an array - DON'T DO THIS!
        Set<Plant>[] plantsByLifeCycle =
            (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }


    Jednak takie użycie nie jest zbyt dobre.
    Jest na to dużo lepszy sposób, który nie naraża nas na żadne błędy - użycie wydajnej implementacji mapy zaprojektowanej do pracy z enumami - EnumMap:

        // Using an EnumMap to associate data with an enum
        Map<Plant.LifeCycle, Set<Plant>>  plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);

    Program jest krótszy, czystszy, bezpieczniejszy i porównywalny w wydajności.
    Nie ma ostrzeżenia unsafe cast, wartości od razu przechowują swoją reprezentację tekstową i nie ma możliwości na błąd podczas przeliczania indexów.


Emuluowanie rozszerzalnych enumów za pomocą interfejsów:
    Enumy mają jedno duże ograniczenie - nie mogą być rozszerzane i tak jest “by design”. Nie ma też dużo przypadków kiedy byłoby to niezbędne.

    Jeden z use casów, gdzie moglibyśmy na tym skorzystać, to kody operacyjne, które reprezentują operację np. nasza klasa Operation.
    Czasami jest pożądane, aby użytkownicy API mogli podać swoją własną operację, rozszerzając te standardowe dostarczone przez API.

    Jest na to całkiem dobry sposób, a wykorzystuje on fakt, że enumy mogą implementować interfejsy.
    Możemy więc zdefiniować interfejs definiujący operację:

        // Emulated extensible enum using an interface
        public interface Operation {
            double apply(double x, double y);
        }


    i enum, który jest jego standardową implementacją:

            public enum BasicOperation implements Operation {
                PLUS("+") {
                    public double apply(double x, double y) { return x + y; }
                },
                MINUS("-") {
                    public double apply(double x, double y) { return x - y; }
                },
                TIMES("*") {
                    public double apply(double x, double y) { return x * y; }
                },
                DIVIDE("/") {
                    public double apply(double x, double y) { return x / y; }
                };
                private final String symbol;

                BasicOperation(String symbol) {
                    this.symbol = symbol;
                }

                @Override public String toString() {
                    return symbol;
                }
            }


    Warunkiem jest tutaj to, aby API używało wszędzie interfejsu jako typu operacji.
    Dzięki temu możemy stworzyć nowy enum, który implementuje ten interfejs i stworzyć dodatkowe implementacje np.:

        // Emulated extension enum
        public enum ExtendedOperation implements Operation {
            EXP("^") {
                public double apply(double x, double y) {
                    return Math.pow(x, y);
                }
            },
            REMAINDER("%") {
                public double apply(double x, double y) {
                    return x % y;
                }
            };

            private final String symbol;

            ExtendedOperation(String symbol) {
                this.symbol = symbol;
            }

            @Override public String toString() {
                return symbol;
            }
        }


    Tak by wyglądało użycie:

        public static void main(String[] args) {
            test(ExtendedOperation.class, 1, 2);
        }

        private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
            for (Operation op : opEnumType.getEnumConstants())
                System.out.printf("%f %s %f = %f%n",
                                  x, op, y, op.apply(x, y));
        }


    <T extends Enum<T> & Operation> Class<T> zapewnia, że przekazany obiekt Class<T> jest zarówno enumem jak i implementuje Operation,
    co jest wymagane, aby przeiterować elementy enuma i użyć jego metod.

    Alternatywnie moglibyśmy przekazać Collection<? extends Operation> zamiast tokenu klasy:

        public static void main(String[] args) {
            test(Arrays.asList(ExtendedOperation.values()), 1, 2);
        }

        private static void test(Collection<? extends Operation> opSet,
                double x, double y) {
            for (Operation op : opSet)
                System.out.printf("%f %s %f = %f%n",
                                  x, op, y, op.apply(x, y));
        }


    Jest to nieco mniej skomplikowane i pozwala przekazać operacje z różnych implementacji.

    Wadą tego rozwiązania jest to, że implementacje nie mogą być dziedziczone między enumami.

    Takie użycie możemy znaleźć też w bibliotece Javy np.: enum java.nio.file.LinkOption implementuje CopyOption i OpenOption.
*/

public class Enums {
}
