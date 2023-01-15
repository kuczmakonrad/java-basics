package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
Wyjątki możemy rzucać w dowolnych blokach kodu – także w sekcji try, catch, a także finally.

Dla przykładu, moglibyśmy pobrać od użytkownika wiek osoby do utworzenia.
Jeżeli ten wiek już w momencie pobrania od użytkownika jest nieprawidłowy (ujemny), to możemy rzucić w sekcji try wyjątek,
by przejść natychmiast do sekcji catch obsługującej taką sytuację:

W tym przykładzie korzystamy z metody getInt, której używamy już od kilku rozdziałów. W metodzie main pobieramy od użytkownika wiek osoby do utworzenia (1).
Zanim w ogóle przystąpimy do tworzenia obiektu typu Osoba w linii (3), najpierw sprawdzamy pobraną od użytkownika liczbę.
Jeżeli jest nieprawidłowym wiekiem, to w ogóle nie będziemy próbowali utworzyć obiektu typu Osoba.
Zamiast tego, od razu rzucimy wyjątek NieprawidlowyWiekException (2), a wykonanie programu przejdzie do sekcji catch, która ten wyjątek obsługuje (4).

Przykład wykonania z podaniem poprawnego i niepoprawnego wieku:
    Podaj wiek osoby: 35
    Obiekt utworzony!
    Podaj wiek osoby: -5
    Nieprawidlowy wiek!

Wyjątki mogą być też rzucane w sekcji catch. Czasem chcemy wykonać pewną akcję związaną z obsługą wyjątku, a potem rzucić go ponownie,
co zobaczymy w kolejnym rozdziale.

Wyjątki mogą równie dobrze być rzucone w sekcji finally – jeżeli wykonujemy w nich kod bądź wywołujemy metody,
które potencjalnie mogą zakończyć się wyjątkiem, to musimy mieć to na uwadze, opakowując taki kod ponownie w try..catch
lub sygnalizując metodom, które z naszego kodu korzystają, że to one powinny się tymi potencjalnymi wyjątkami zająć –
o tym zagadnieniu także porozmawiamy w jednym z kolejnych rozdziałów.
*/

import java.util.Scanner;

public class q06e_ThrowExceptionInTryCatchFinallyClause {
    public static void main(String[] args) {
        try {
            System.out.println("Podaj wiek: ");
            int age = getInt();

            if (age <= 0) {
                throw new NieprawidlowyWiekException();
            }

            Osoba osoba = new Osoba("Jan", "Nowak", age);
            System.out.println("Utworzono obiekt!");
        } catch (NieprawidlowyWiekException e) {
            e.printStackTrace();
        }
    }
    private static int getInt() {
       return new Scanner(System.in).nextInt();
    }
}
