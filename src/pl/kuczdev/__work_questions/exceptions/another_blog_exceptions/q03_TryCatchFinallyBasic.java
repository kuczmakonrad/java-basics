package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
Mechanizm łapania wyjątków ma następującą składnię:

    try {
      // instrukcje ktore moga potencjalnie zakonczyc sie wyjatkiem
    } catch (TypWyjatku dowolnaNazwa) {
      // instrukcje, gdy zajdzie wyjątek TypWyjatku
    } catch (KolejnyTypWyjatku dowolnaNazwa2) {
      // instrukcje, gdy zajdzie wyjątek KolejnyTypWyjatku
    } finally {
      // instrukcje, ktore maja byc wykonane niezaleznie od tego,
      // czy wyjatek zostal zlapany, czy nie
    }

Jak widzimy, możemy zdefiniować obsłużenie większej liczby wyjątków poprzez dopisywanie kolejnych bloków catch – może ich być dowolnie wiele.
W nawiasach dla każdego z bloków catch podajemy, jaki typ wyjątku chcemy obsłużyć
oraz nadajemy mu nazwę, ponieważ sam wyjątek jest obiektem (zmienną), którą możemy odpytać o informacje związane z zaistniałym błędem.
Dla przykładu, możemy wyświetlić komunikat błędu:

    try {
      System.out.println(podziel(10, 0));
    } catch (ArithmeticException e) {
      System.out.println("Nie wolno dzielic przez 0!");
      System.out.println("Wystapil blad: " + e.getMessage());
    }

W wyniku czego zobaczymy na ekranie:

    Nie wolno dzielic przez 0!
    Wystapil blad: / by zero

Fragment wypisanego tekstu "/ by zero" to opis błędu, który wystąpił.
Opis ten przechowywany jest w obiekcie-wyjątku, który nazwaliśmy e.
Metoda getMessage zwraca ten opis.


Mechanizm łapania wyjątków oferuje jeszcze jedną funkcjonalność –
możemy w opcjonalnym bloku finally umieścić instrukcje, które mają zawsze się wykonać, niezależnie od tego, czy wyjątek zostanie złapany, czy nie.
Blok finally zazwyczaj używany jest do czyszczenia zasobów, np. zamykania połączeń z bazą danych czy zamykania otwartych plików.

Istotne jest zrozumienie kolejności wykonywania instrukcji w blokach try..catch..finally:
    1. Najpierw wywoływane są instrukcje w bloku try. Jeżeli któraś z instrukcji spowoduje rzucenie wyjątku, to:
        1.a) Wykonanie bloku try zostaje przerwane – wszystkie instrukcje następujące po instrukcji, która spowodowała wyjątek, nie zostaną wykonane.
        1.b) Typ rzuconego wyjątku jest dopasowywany do wyjątków zdefiniowanych w sekcjach catch.
                Zostają wykonane instrukcje przyporządkowane do pierwszej sekcji catch, do której rzucony wyjątek został dopasowany.
                Jeżeli wyjątek, który wystąpił, nie jest obsługiwany w żadnym z bloków catch, to przechodzimy do kroku 2.
    2. Wywoływane są instrukcje z bloku finally, jeżeli blok ten jest obecny, niezależnie od tego, czy wyjątek wystąpił, czy nie.

Spójrzmy na dwa poniższe przykłady:
1 przykład:
    try {
      System.out.println("Zaraz podzielimy 10 przez 2");
      System.out.println("Wynik dzielenia: " + podziel(10, 2));
      System.out.println("Podzielilismy 10 przez 2");
    } catch (ArithmeticException e) {
      System.out.println("Wystapil blad podczas dzielenia przez 2!");
    } finally {
      System.out.println("Blok try..catch..finally zakonczony!");
    }

OUTPUT:
    Zaraz podzielimy 10 przez 2
    Wynik dzielenia: 5
    Podzielilismy 10 przez 2
    Blok try..catch..finally zakonczony!

Jak widzimy, komunikat z sekcji catch nie został wypisany, ponieważ żaden wyjątek nie wystąpił.

2 przykład:
    try {
      System.out.println("Zaraz podzielimy 10 przez ZERO!");
      System.out.println("Wynik dzielenia: " + podziel(10, 0));          // TO SIĘ NIE WYŚWIETLA, BO MAMY TUTAJ BŁĄD
      System.out.println("Podzielilismy 10 przez ZERO!");                // (1) TO SIĘ NIE WYKONUJE, BO PRZECHODZIMY DO CATCHA
    } catch (ArithmeticException e) {
      System.out.println("Wystapil blad podczas dzielenia przez ZERO!");    // (2)
    } finally {
      System.out.println("Blok try..catch..finally zakonczony!");
    }

OUTPUT:
    Zaraz podzielimy 10 przez ZERO!
    Wystapil blad podczas dzielenia przez ZERO!
    Blok try..catch..finally zakonczony!

Tym razem nie została wykonana instrukcja (1), która następowała po instrukcji dzielenia.
Nie zobaczyliśmy na ekranie napisu "Podzielilismy 10 przez ZERO!", ponieważ w momencie rzucenia wyjątku wykonanie programu przeszło od razu do obsługi wyjątku.
Z racji tego, że wyjątek wystąpił, zobaczyliśmy napis wypisywany w obsłudze wyjątku (2).

Zwróćmy uwagę, że niezależnie od tego, czy wyjątek wystąpił, czy nie, w obu przykładach wykonany został kod z części finally.
Kod z bloku finally nie zostanie wykonany w szczególnym przypadku – gdy użyjemy metody exit z klasy System, ponieważ natychmiast kończy ona nasz program.

Zakres zmiennych definiowanych w bloku try

 */
public class q03_TryCatchFinallyBasic {
    public static void main(String[] args) {
        try {
            System.out.println("Zaraz podzielimy 10 przez 2");
            System.out.println("Wynik dzielenia: " + (10/2));
            System.out.println("Podzielilismy 10 przez 2");
        } catch (ArithmeticException e) {
            System.out.println("Wystapil blad podczas dzielenia przez 2!");
        } finally {
            System.out.println("Blok try..catch..finally zakonczony!");
        }

        System.out.println("-------");

        try {
            System.out.println("Zaraz podzielimy 10 przez ZERO!");
            System.out.println("Wynik dzielenia: " + (10/0));                   // TO SIĘ NIE WYŚWIETLA, BO MAMY TUTAJ BŁĄD
            System.out.println("Podzielilismy 10 przez ZERO!");                 // (1) TO SIĘ NIE WYKONUJE, BO PRZECHODZIMY DO CATCHA
        } catch (ArithmeticException e) {
            System.out.println("Wystapil blad podczas dzielenia przez ZERO!");    // (2)
        } finally {
            System.out.println("Blok try..catch..finally zakonczony!");
        }
    }
}
