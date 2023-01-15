package pl.kuczdev.__work_questions.equals_and_hashcode.devcave.hashcode;
/*
https://devcave.pl/effective-java/metoda-hashcode

hashCode to metoda, która powinna zawierać algorytm hashujący, który na podstawie danych obiektu wylicza liczbę całkowitą (hash), reprezentujący ten obiekt.

Hash jest wykorzystywany pod spodem przez niektóre kolekcje (np. HashMap i HashSet) do przechowywania referencji do obiektów,
co w rezultacie daję bardzo wydajną kolekcję o stałym czasie dostępu do danych.
Ten czas w dużej mierze zależy od wydajności naszego algorytmu hashującego, więc warto na to zwracać uwagę.

Niezbędne jest nadpisywanie metody hashCode za każdym razem, gdy nadpisujesz equals.

Jest to spowodowane tym, że między nimi zawarty jest nienaruszalny kontrakt. Jeśli zostanie naruszony, to obiekty nie będą działać prawidłowo w kolekcjach
takich jak HashMap i HashSet czy w każdej innej klasie, która polega na hash kodach obiektów.

Kontrakt dla samej metody hashCode jest następujący:

Jeśli informacje używane w equals nie są modyfikowane, to metoda hashCode musi zawsze konsekwentnie zwracać tę samą wartość.
Jeśli metoda equals stwierdzi, że dwa obiekty są równe, to wywoływanie hashCode na obu tych obiektach musi zwrócić tę samą wartość.
Jeśli dwa obiekty nie są równe według metody equals, to nie jest wymagane, aby hashCode na każdym z obiektów zwracał różne wyniki. Jednak jest to pożądane, bo ma to znaczenie wydajnościowe dla hash tablic (jeśli będą dwa takie same hashe, to będzie musiała wywołać metody equals, aby rozróżnić obiekty).


Jak poprawnie napisać metodę hashCode?
Dobra metoda hashCode powinna dawać różne hash kody, dla różnych obiektów. Osiągniecie tego może być trudne, ale możemy uzyskać przybliżony efekt.

Od Javy 7, mamy klasę Objects, która posiada statyczną metodę hash. Przyjmuje ona dowolną liczbę argumentów i zwraca dla nich hash code.
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

    Zadeklaruj zmienną int result i zainicjuj ją hash kodem c dla pierwszego znaczącego pola.
    Dla każdego pozostałego znaczącego pola f, które jest używane w metodzie equals :
    Przelicz hash codec:
        Jeśli jest to prymityw używaj Type.hashCode(f), gdzieType to odpowiednia klasa opakowująca. Np. dla int - Integer.hashCode(f).
        Jeśli pole jest obiektem i w metodzie equals jest wywoływane equals tego obiektu, to analogicznie powinniśmy wywołaś hashCode tego obiektu.
        Jeśli pole jest null to użyj0 .
        Jeśli pole jest tablicą, to przelicz hash code dla każdego znaczącego elementu. Jeśli tablica nie ma znaczących pól, użyj stałej (ale nie0). Jeśli wszystkie elementy są znaczące użyj Arrays.hashCode.
        Połącz hash codecpoliczony w kroku 2.1 z result w następujący sposób result = 31 * result + c;.
        Zwróć result.
        Upewnij się, że obiekty równe sobie mają takie sam hash code.
        Mnożenie z kroku 2.2 zapewnia, że kolejność pól ma znaczenie. Jeśli pominęlibyśmy to, to np. w klasie String wszystkie anagramy miałyby identyczny hash code.



Ten przepis na hashCode daje nam całkiem dobre funkcje hashujące, odpowiednie dla większości użyć, jednak nie są one perfekcyjne.
Jeśli będziesz mieć naprawdę dobry powód, żeby twoje hash code-y miały jeszcze mniejsze prawdopodobieństwo na kolizję, zobacz rozwiązanie od Guava -com.google.common.hash.Hashing.
Jeśli klasa jest immutable, można rozważyć cachowanie hash kodu w zmiennej, zamiast przeliczać go za każdym razem od nowa.
 */

public class MainTest {
    public static void main(String[] args) {

    }
}
