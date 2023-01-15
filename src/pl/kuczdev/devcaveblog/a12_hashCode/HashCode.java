package pl.kuczdev.devcaveblog.a12_hashCode;

/*
HashCode to metoda, która powinna zawierać algorytm hashujący, który na podstawie danych obiektu wylicza liczbę całkowitą (hash), reprezentujący ten obiekt.

Hash jest wykorzystywany pod spodem przez niektóre kolekcje (np. HashMap i HashSet) do przechowywania referencji do obiektów,
co w rezultacie daję bardzo wydajną kolekcję o stałym czasie dostępu do danych.
Ten czas w dużej mierze zależy od wydajności naszego algorytmu hashującego, więc warto na to zwracać uwagę.

W poprzednim poście podkreśliłem, że niezbędne jest nadpisywanie metody hashCode za każdym razem, gdy nadpisujesz equals.

Jest to spowodowane tym, że między nimi zawarty jest nienaruszalny kontrakt.
Jeśli zostanie naruszony, to obiekty nie będą działać prawidłowo w kolekcjach takich jak HashMap i HashSet czy w każdej innej klasie,
która polega na hash kodach obiektów.


Kontrakt dla samej metody hashCode jest następujący:
    * Jeśli informacje używane w equals nie są modyfikowane, to metoda hashCode musi zawsze konsekwentnie zwracać tę samą wartość.
    * Jeśli metoda equals stwierdzi, że dwa obiekty są równe, to wywoływanie hashCode na obu tych obiektach musi zwrócić tę samą wartość.
    * Jeśli dwa obiekty nie są równe według metody equals, to nie jest wymagane, aby hashCode na każdym z obiektów zwracał różne wyniki.
        Jednak jest to pożądane, bo ma to znaczenie wydajnościowe dla hash tablic
        (jeśli będą dwa takie same hashe, to będzie musiała wywołać metody equals, aby rozróżnić obiekty).

Szczególnie ważny jest 2 punkt.
- jeśli nie nadpiszemy również metody hashCode wraz z equals to według metody equals dwa obiekty są sobie równe,
 a dla metody hashCode te same obiekty nie mają nic ze sobą wspólnego.
 Zwracane są dwa różne numery, zamiast dwóch identycznych.


Teraz dla przykładu załóżmy, że będziemy chcieli użyć PhoneNumber z poprzedniego postu jako klucze w HashMap bez definiowania hashCode:

    Map<PhoneNumber, String> map = new HashMap<>();
    map.put(new PhoneNumber(707, 867, 5309), "Jenny");

Dostaniemy "Jenny", ale tak się nie stanie, bo dostaniemy null.
Zauważ, że są używane dwie instancje PhoneNumber.
Są one identyczne, ale z punktu widzenia hashCode, na którym bazuje HashMap, nie są.

Napisanie poprawnej implementacji hashCode dla PhoneNumber rozwiązuje problem.



Jak poprawnie napisać metodę hashCode?
Podobnie jak pisałem we wcześniejszym poście, jeśli nie potrzebujesz specyficznej implementacji,
to możesz zdać się na automatyczne wygenerowanie tej metody przez IDE czy odpowiednią bibliotekę jak np. Lombok.

Dobra metoda hashCode powinna dawać różne hash kody, dla różnych obiektów.
Osiągniecie tego może być trudne, ale możemy uzyskać przybliżony efekt.

Od Javy 7, mamy klasę Objects, która posiada statyczną metodę hash.
Przyjmuje ona dowolną liczbę argumentów i zwraca dla nich hash code.
Pozwala to napisać implementację metody hashującej w jednej linijce. Dla przykładowej klasy PhoneNumber będzie wyglądać tak:

    // One-line hashCode method - mediocre performance
    @Override public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }

Jej jakość jest podobna do tych napisanych ręcznie według przepisu, który zaraz przedstawię, jednak jest delikatnie mniej wydajna,
jeśli częstotliwość jej wywołań jest wysoka i używane są wartości prymitywne.
Spowodowane jest to tym, że pod spodem używana jest tablica, a prymitywy muszą być autoboxowane.
Jednak w większości wypadków, gdy wydajność nie ma dla nas aż takiego znaczenia, możemy śmiało tego używać.


Jeśli zdecydujemy się na ręczne napisanie implementacji metody hashCode, to tu jest przepis:
    1. Zadeklaruj zmienną int result i zainicjuj ją hash kodem c dla pierwszego znaczącego pola.
    2. Dla każdego pozostałego znaczącego pola f, które jest używane w metodzie equals:
        2.1. Przelicz hash code c:
            ** Jeśli jest to prymityw używaj Type.hashCode(f), gdzieType to odpowiednia klasa opakowująca. Np. dla int - Integer.hashCode(f).
            ** Jeśli pole jest obiektem i w metodzie equals jest wywoływane equals tego obiektu, to analogicznie powinniśmy wywołaś hashCode tego obiektu.
            ** Jeśli pole jest null to użyj 0.
            ** Jeśli pole jest tablicą, to przelicz hash code dla każdego znaczącego elementu.
                Jeśli tablica nie ma znaczących pól, użyj stałej (ale nie0). Jeśli wszystkie elementy są znaczące użyj Arrays.hashCode.
        2.2. Połącz hash code c policzony w kroku 2.1 z result w następujący sposób: result = 31 * result + c;
    3. Zwróć result.
    4. Upewnij się, że obiekty równe sobie mają takie sam hash code.

Mnożenie z kroku 2.2 zapewnia, że kolejność pól ma znaczenie.
Jeśli pominęlibyśmy to, to np. w klasie String wszystkie anagramy miałyby identyczny hash code.

Aplikując powyższe wskazówki metoda hashCode klasy PhoneNumber będzie wyglądać tak:

    // Typical hashCode method
    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

W tej prostej implementacji jasno widać, że identyczne klasy PhoneNumber będą miały identyczny hashCode.

Ten przepis na hashCode daje nam całkiem dobre funkcje hashujące, odpowiednie dla większości użyć, jednak nie są one perfekcyjne.
Jeśli będziesz mieć naprawdę dobry powód, żeby twoje hash code-y miały jeszcze mniejsze prawdopodobieństwo na kolizję,
zobacz rozwiązanie od Guava -com.google.common.hash.Hashing.


** Jeśli klasa jest immutable, można rozważyć cachowanie hash kodu w zmiennej, zamiast przeliczać go za każdym razem od nowa.
** Dlaczego 31?
    Bo jest to nieparzysta liczba pierwsza.
    Gdyby była to liczba parzysta i mnożenie skutkowałoby przepełnieniem, to informacje zostałyby utracone,
    bo mnożenie przez 2 jest tym samym, co przesuniecie bitowe w lewo. (np. 4 * 2 == 4 << 1).
    Używanie liczby pierwszej jest mniej uzasadnione, ale to już tradycja.
    Fajną właściwością liczby 31 jest to, że mnożenie może być zastąpione przez przesunięcie bitowe w lewo i odejmowanie 31 * i == (i << 5) - i,
    co ma wpływ na wydajność.
    Tego typu optymalizacje są robione automatycznie przez nowoczesne wirtualne maszyny.
*/

final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    // Typical hashCode method
    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    // Remainder omitted
}

public class HashCode {
}