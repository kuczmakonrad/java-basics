package pl.kuczdev.devcaveblog.a01_static_factory_method;
/*
Tradycyjny sposób na tworzenie instancji klasy to użycie publicznego konstruktora. W tym wpisie przyjrzymy się innemu sposobowi, który również powinien być znany każdemu programiście.

Static Factory Method:
    Jest to po prostu statyczna metoda, która zwraca instancję danej klasy:
        public static final SomeClass staticFactoryMethod(){
            return new SomeClass();
        }

    Na pewno już to kiedyś spotkałeś, choćby w standardowej bibliotece. To nie jest to samo co wzorzec projektowy Factory Method znana z wzorców GOF.

    Jeden z najpopularniejszych przykładów to:
        Integer number = Integer.valueOf("123");

    A tu implementacja:
        public static Integer valueOf(String s) throws NumberFormatException {
            return Integer.valueOf(parseInt(s, 10));
        }

    Która korzysta z:
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }

    Inny, trochę bardziej prosty przykład to:
        public static Boolean valueOf(boolean b) {
            return b ? Boolean.TRUE : Boolean.FALSE;
        }

Static factory method może być jako dodatek do publicznych konstruktorów lub całkowicie je zastąpić. Ma to swoje wady i zalety.


ZALETY:
    1. Ma swoją nazwę.
        Dzięki temu jaśniej może opisać obiekt, który zwraca lub w jaki sposób go tworzy, przez co kod jest łatwiejszy w użyciu jak i łatwiej go zrozumieć.

    2. Można zrobić kilka metod z parametrami o tym samym typie.
        W przypadku konstruktorów nie jest to możliwe.
        Widać też, że nazwy jasno określają intencję, czego nie możemy osiągnąć używając konstruktorów.

        Dokładny przykład i różnice pokazałem w klasach:
            * p02_CoordinateByConstructor.java
            * p03_CoordinateByStaticFactoryMethod.java

    3. Nie jest wymuszone tworzenie nowego obiektu z każdym wywołaniem.
        W przeciwieństwie do konstruktorów, statyczną fabryką możemy zwracać cały czas ten sam obiekt.
        Dzięki temu klasy niemutowalne mogą używać wcześniej stworzonych instancji lub cachować instancję podczas jej tworzenia i później ją zwracać z każdym wywołaniem tej metody,
        co eliminuje tworzenie niepotrzebnych duplikatów danego obiektu.
        Przykładem tu jest wcześniej pokazywana metoda Boolean.valueOf(boolean), która nigdy nie tworzy nowego obiektu lub Integer.valueOf(int i),
        która zwraca “scacheowaną” instancję Integer, jeśli jest w zakresie od -128 do 127, a w inny przypadku tworzy nową.
        Liczby w tym przedziale występują znacznie częściej, więc taka optymalizacja ma sens.

    4. Może zwracać każdy podtyp zwracanego obiektu.
        Mamy możliwość zwrócenia dowolnego podtypu, co ważne - bez konieczności deklarowania go jako publiczny.
        Dzięki temu możemy zdefiniować metodę na interfejsie, która zwróci nam konkretną implementację tego interfejsu.
        Przed Java 8 nie było możliwe definiowanie statycznych metod w interfejsach.
        Wtedy takie metody np. dla interfejsu Type lądowały w nieinstancjonowalnej klasie Types.
        Dosyć popularnym przykładem jest java.util.Collections.
        W Java 8+ możemy umieścić wszystkie statyczne fabryki bezpośrednio w interfejsie.
        I tak też zrobiono w Javie 9 na interfejsach List, Set i Map.

    5. Z każdym wywołaniem może być zwrócona inna implementacja.
        A to dzięki przekazywanemu parametrowi na podstawie którego może zostać wybrana implementacja.
        Pozwala to np. na zwrócenie wydajniejszej implementacji dla konkretnego przypadku. Jest to niewidoczne dla klienta i może być rozszerzalne.

        Przykładem może być EnumSet z standardowej biblioteki.
        Nie posiada publicznego konstruktora, tylko statyczne fabryki, które zwracają różne implementację w zależności od wielkości Enuma.
        Jeśli ma mniej niż 64 elementy zwracany jest RegularEnumSet, w przeciwnym wypadku JumboEnumSet.
        Wszystko po to żeby zadbać o wydajność.

            public static <E extends Enum<E>> EnumSet<E> of(E first, E... rest) {
                EnumSet<E> result = noneOf(first.getDeclaringClass());
                result.add(first);
                for (E e : rest)
                    result.add(e);
                return result;
            }

            public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
                Enum<?>[] universe = getUniverse(elementType);
                if (universe == null)
                    throw new ClassCastException(elementType + " not an enum");

                if (universe.length <= 64)
                    return new RegularEnumSet<>(elementType, universe);
                else
                    return new JumboEnumSet<>(elementType, universe);
            }

WADY:
Static factory method nie ma żadnych poważnych wad. Jeśli można by się do czegoś przyczepić to:
    1. Klasa bez konstruktora nie może być rozszerzana.
        Jednak może to wyjść też na korzyść, bo zachęca to do używania kompozycji zamiast dziedziczenia oraz jest wymagane przez klasy immutable.

    2. Jest wymieszana razem z innymi metodami.
        Mały minusem jest też to, że statyczne fabryki nie są traktowane inaczej niż zwykłe metody, a więc są z nimi wymieszane.
        Trzeba więc przelecieć całą listę dostępnych metod w obiekcie w poszukiwaniu takiej, która zwraca ten obiekt.
        Przy szukaniu/tworzeniu takich metod warto zaznajomić się z konwencją nazewniczą takich metod, a najczęściej wyglądają tak:
            ** from - konwersja                                                         np.: Date d = Date.from(instant);
            ** of - agregacja                                                           np.: Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
            ** valueOf - bardziej rozwlekła wersja from lub of                          np.: BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
            ** instance lub getInstance - może zwracać obiekt opisany przez parametr    np.: StackWalker luke = StackWalker.getInstance(options);
            ** create lub newInstance - podobnie jak instance lub getInstance, tyle, że tu za każdym razem powinien być to nowy obiekt np.: Object newArray = Array.newInstance(classObject, arrayLen);
            ** getType - podobnie jak getInstance, tyle, że używamy wtedy kiedy metoda-fabryka jest w innej klasie np.: FileStore fs = Files.getFileStore(path);
            ** newType - podobnie jak newInstance, tyle, że używamy wtedy kiedy metoda-fabryka jest w innej klasie np.: BufferedReader br = Files.newBufferedReader(path);
            ** type - zwięzła alternatywa dla getType i newType                         np.: List<Complaint> litany = Collections.list(legacyLitany);
        Jak widać statyczne fabryki mają dużo zalet, dlatego warto rozważyć ich implementowanie.
        Z kolei kiedy używamy jakiegoś API i są dostępne zarówno konstruktory jak i statyczne fabryki, w większości przypadków powinniśmy użyć tych drugich.
        Często wewnątrz uruchamiane są funkcje inicjujące, które są niezbędne do stworzenia danego obiektu lub mają znaczenie wydajnościowe.
 */

public class p01_StaticFactoryMethodBasic {

}
