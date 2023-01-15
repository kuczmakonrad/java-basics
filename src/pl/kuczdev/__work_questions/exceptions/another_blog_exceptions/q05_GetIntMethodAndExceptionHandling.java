package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/*

Metoda getInt i obsługa wyjątków
W poprzednich rozdziałach wielokrotnie korzystaliśmy z metody getInt, która miała za zadanie zwrócić pobraną od użytkownika liczbę.
Co się jednak działo w sytuacjach, gdy przez przypadek podaliśmy nieprawidłową liczbę?

    public class q05_GetIntMethodAndExceptionHandling {
        public static void main(String[] args) {
            System.out.println("Podaj liczbę: ");
            int x = getInt();

            System.out.println("Kwadrat tej liczby wynosi: " + (x * x));
        }

        private static int getInt() {
            return new Scanner(System.in).nextInt();
        }
    }

Jeżeli po uruchomieniu powyższego programu podamy np. "kot" zamiast liczby, to program zakończy się następującym błędem:

    Exception in thread "main" java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q05_GetIntMethodAndExceptionHandling.getInt(q05_GetIntMethodAndExceptionHandling.java:21)
        at pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q05_GetIntMethodAndExceptionHandling.main(q05_GetIntMethodAndExceptionHandling.java:16)

Teraz już wiemy, że ten błąd to rzucony wyjątek.
W tym przypadku, nazywa się on InputMismatchException, które zdefiniowany jest w bibliotece standardowej w pakiecie java.util.

Wiedząc już, jak obsługiwać wyjątki, możemy zmodyfikować nasz program, by brał pod uwagę możliwość podania przez użytkownika nieprawidłowej liczby.
Jak jednak powinniśmy taką sytuację obsłużyć?

Możemy w pętli próbować pobrać od użytkownika liczbę –
jeżeli wyjątek zostanie rzucony, poinformujemy użytkownika o nieprawidłowo podanej wartości i spróbujemy pobrać ją kolejny raz w następnym obiegu pętli.
Gdy użytkownik poda poprawną liczbę, zmienimy zmienną warunkującą wykonanie pętli, by pętla już więcej się nie wykonywała.

Poniżej możemy zobaczyć, jak powinna wyglądać implementacja:

Najpierw dodajemy importowanie typu wyjątku, który będziemy łapać (1).
Wyjątek ten nie znajduje się w pakiecie java.lang, lecz java.util, dlatego musimy sami dodać jego import do naszego programu.

Następnie definiujemy w metodzie main zmienne wartoscPodana i x (2).
Pierwsza będzie wskazywała, czy użytkownik podał już poprawną wartość, czy jeszcze nie.
Druga zmienna przechowuje wartość od użytkownika.

W pętli while (3) wykonujemy próbę pobrania liczby od użytkownika (4) tak długo, aż nie poda on poprawnej liczby.
Jeżeli użytkownik poda poprawną liczbę, to w linii (5) ustawimy wartoscPodana na true, dzięki czemu pętla nie wykona się więcej razy.
Jeżeli jednak użytkownik poda np. literę zamiast liczby, to wywołanie metody getInt zakończy się rzuceniem wyjątku InputMismatchException,
który obsługujemy w linii (6).
W tym przypadku informujemy użytkownika, że podał nieprawidłową liczbę. Instrukcja try..catch się kończy i przechodzimy do kolejnego obiegu pętli –
w zależności od tego, jaką wartość podał użytkownik, wykona się ona ponownie lub zakończy działanie.

Na końcu programu liczymy kwadrat pobranej liczby i wypisujemy wynik.

Przykładowe wykonanie tego programu:
    Podaj liczbe: kot
    To nie jest liczba!
    Podaj liczbe: pies
    To nie jest liczba!
    Podaj liczbe: 5
    Kwadrat tej liczby wynosi 25

 */
public class q05_GetIntMethodAndExceptionHandling {
    public static void main(String[] args) {
        boolean wartoscPodana = false; // 2
        int x = 0;
        while (!wartoscPodana) { // 3
            try {
                System.out.print("Podaj liczbe: ");
                x = getInt(); // 4
                wartoscPodana = true; // 5
            } catch (InputMismatchException e) { // 6
                System.out.println("To nie jest liczba!");
            }
        }
        int kwadrat = x * x;
        System.out.println("Kwadrat tej liczby wynosi " + kwadrat);
    }
    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }
}