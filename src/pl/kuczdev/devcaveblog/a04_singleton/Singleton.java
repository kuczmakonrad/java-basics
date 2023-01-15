package pl.kuczdev.devcaveblog.a04_singleton;

/*
Czasem może się zdarzyć, że:
    * klasa ma być unikatowa w systemie;
    * chcemy zarządzać jednym spójnym obiektem dostępnym z wielu miejsc aplikacji;
Wtedy warto zastosować wzorzec projektowy Singleton.

Singleton jest to po prostu klasa, która jest instancjonowana w systemie tylko jeden raz. Każde użycie takiej klasy odnosi się do tej samej instancji.
Jest kilka sposobów implementacji Singletona.

1. Public final field Singleton:
    Dwa pierwsze polegają na deklarowaniu konstruktora jako prywatny i udostępnianiu statycznego dostępu do obiektu:

        public class Singleton {
            public static final Singleton INSTANCE = new Singleton();

            private Singleton() {
            }
        }


    Prywatny konstruktor jest wywołany tylko raz, aby zainicjalizować Singleton.INSTANCE.
    Brak publicznego konstruktora zapewnia, że w systemie będzie istnieć tylko jedna instancja tego obiektu.
    No chyba, że użyjemy refleksji i metody setAccessible().
    Możemy wykluczyć taką opcję rzucając wyjątek w konstruktorze - jeśli instancja już istnieje:

        private Singleton() {
            if (INSTANCE != null) {
                throw new IllegalStateException("Singleton already constructed");
            }
        }


2. Static factory method Singleton:
    Drugi sposób różni się od pierwszego tym, że udostępniania static factory method w celu zwracania INSTANCE, tym samym zadeklarowania tego pola jako prywatne:
    Singleton.getInstance(); zawsze zwróci ten sam obiekt.

        public class Singleton {
            private static final Singleton INSTANCE = new Singleton();

            private Singleton() {
            }

            public static Singleton getInstance() {
                return INSTANCE;
            }
        }

    + Bardziej elastyczny sposób. - Pozwala nam w każdym momencie zmienić zdanie np. możemy sprawić, że ta klasa nie będzie już Singletonem bez zmieniania API.
    + Możliwość napisania generycznej fabryki Singletonów.
    + Referencja do metody może być użyta jako Supplier. (Singleton::instance)


3. Singleton i lazy loading:
    Obie powyższe implementacje tworzą instancję klasy już w momencie załadowania klasy (chciwa inicjalizacja),
    nawet jeżeli nigdy nie zajdzie potrzeba jej wykorzystania.

    Dzięki implementacji leniwego tworzenia obiektu można odwlec w czasie moment budowania instancji oraz potencjalnie oszczędzić zasoby,
    jeżeli nie będzie wcale potrzeby jego utworzenia.
    Dzięki temu możemy też używać jej statycznych metod bez tworzenia instancji tej klasy.
    Można to zrobić w prosty sposób:

        public class Singleton {
            private static Singleton INSTANCE;

            private Singleton() {
            }

            public static Singleton getInstance() {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
                return INSTANCE;
            }
        }


4. Singleton i Serializable:
    Dodanie implements Serializable do klasy nie jest wystarczające, aby singleton był rzeczywiście singletonem.
    Aby zagwarantować, że w systemie będzie tylko jedna klasa, musimy zadeklarować wszystkie pola jako transient oraz zdefiniować metodę:

        private Object readResolve() {
            return getInstance();
        }

    (lub return INSTANCE; w przypadku gdy nie korzystamy z leniwej inicjalizacji)

    Jeżeli klasa posiada taką metodę, to podczas deserializacji zwracany jest wynik jej działania.
    W przeciwnym wypadku, za każdym razem kiedy serializowana klasa zostanie deserializowana, zostanie utworzona nowa instancja singletona.


5. Singleton i wielowątkowość:
    Aby zabezpieczyć nasz naszą klasę singletona przed wielowątkowością, musimy nieco zmodyfikować metodę getInstance():
    Jest to tak zwany double-check-locking pattern.
    Jeśli dwa wątki jednocześnie przejdą pierwszego ifa i będą chciały pobrać instancję to zakolejkują się przed synchronized().
    Dodatkowy zagnieżdżony if wyeliminuję próbę stworzenia duplikatu.

    Zwróć uwagę, że zmienna INSTANCE jest oznaczona jako volatile. Jest to niezbędne.
    W przeciwnym wypadku double-check-locking nie działa.
    Jeśli interesuje Cię dlaczego tak musi być to na razie odsyłam do tematu Double-Checked Locking is Broken.
    W rozdziale 11 (Concurrency) serii będzie poświęcony temu osobny wpis.

        public class Singleton {
            private static volatile Singleton INSTANCE;

            public static Singleton getInstance() {
                if (INSTANCE == null) {
                    synchronized (Singleton.class) {
                        if (instance == null) {
                            INSTANCE = new Singleton();
                        }
                    }
                }
                return INSTANCE;
            }
        }


6. Static holder Singleton:
    Jest to bezpieczne rozwiązanie, które działa zgodnie z oczekiwaniami w wielowątkowym środowisku.
    Dzięki niemu mamy również zapewnione leniwe tworzenie instancji.
    W tym rozwiązaniu cały trud poprawnej implementacji wzorca zrzucamy na maszynę wirtualną Javy.
    Zmienna INSTANCE zostanie zainicjowana dopiero w momencie załadowania klasy Holder, czyli podczas pierwszego wywołania metody getInstance().
    W konstruktorze opcjonalnie bronimy się przed refleksją.

        + Static factory method
        + Lazy initialization
        + Thread safe
        + Dobry zamiennik za double-check-locking pattern, który jest uważany za antywzorzec.

    public class Singleton {
        private Singleton() {
            if (Holder.INSTANCE != null) {
                throw new IllegalStateException("Singleton already constructed");
            }
        }

        public static Singleton getInstance() {
            return Holder.INSTANCE;
        }

        private static class Holder {
            private static final Singleton INSTANCE = new Singleton();
        }
    }


7. Enum Singleton
    Korzystając z tego rozwiązania, osiągniemy wynik bardzo podobny do klasy Public final field Singleton.
    Ten sposób jednak:
        + Jest bardziej zwięzły.
        + Zapewnia odpowiednią serializację od razu.
        + Zapewnia nienaruszalna gwarancję jednej instancji.
        + Jest odporny na refleksję.
        + Jest odporny na klonowanie.

    Jeśli można się do czegoś przyczepić to:
        - Brak lazy loading.
        - Enum nie może rozszerzać innej klasy.

    Ale za to może implementować interfejs.
    Ten sposób wydaję się nieco nienaturalny, ale w książce Effective Java autor mówi, że często jest to najlepszy sposób implementacji Singletona.
    Jednak Singleton static holder też jest całkiem dobrym rozwiązaniem - jest podobnie łatwy w implementacji,
    również cały ciężar poprawnej implementacji zrzucamy na mechanizmy Javy i wydaje się być bardziej naturalnym rozwiązaniem.


    public enum Singleton {
        INSTANCE;
        //...
    }


8. Singleton jako antywzorzec:
    Singleton przez wielu programistów uważany jest za antywzorzec projektowy.
    Dzieje się tak głównie dlatego, że jest on dość często nadużywany lub często niepoprawnie implementowany.
    Większość z zarzutów wobec niego przy odrobienie elastyczności można obejść lub nawet odrzucić.

    - Utrudnia testowanie aplikacji.
        Testy są tylko utrudnione, jeżeli w singletonie przechowywany jest stan.
        Należy wtedy pamiętać, by był on odpowiednio zainicjowany lub wyczyszczony przed każdym wywołaniem testu.
        Może też być problem w zmockowaniu Singletona, chyba, że implementuje interfejs, który służy jako jego typ.
    - Zwiększa powiązania w kodzie (tight coupling).
    - Łamie zasadę jednej odpowiedzialności (single responsibility principle)
        Klasa zaimplementowana jako singleton z założenia jest już odpowiedzialna za dwie rzeczy: za realizację swoich funkcji biznesowych oraz zarządzanie instancją.
    - Jest to obiektowy zamiennik zmiennej globalnej - a jak wiemy zmienne globalne to zło…
    - Łamie zasadę otwarte-zamknięte (Open/Closed principle), ponieważ nie można go rozszerzać.
        W pierwotnej wersji wzorca rzeczywiście ciężko jest go rozszerzać.
        Można jednak połączyć singleton z fabryką i nie będzie stanowiło to już problemu.

            interface Singleton {
            }

            public class SingletonFactory {

                private static Singleton instance;

                public static Singleton getInstance() {
                    if (instance == null) {
                        instance = new Singleton() {
                            // singleton implementation
                        };
                    }

                    return instance;
                }
            }


Podsumowanie:
Singleton nie musi być wcale zły, pod warunkiem, że zaimplementujemy go w odpowiedni sposób.
Należy jednak pamiętać, by go nie nadużywać i nie starać się go wprowadzać wszędzie na siłę.
Wzorzec ten powinien być stosowany raczej sporadycznie.

Również z rozwagą trzeba podejść do przedstawianych zabezpieczeń przed różnymi atakami.
W przypadku prostych aplikacji, szczególnie jeśli zajmujemy się nią tylko my, najprostsza implementacja w zupełności wystarczy.


 */
public class Singleton {
}
