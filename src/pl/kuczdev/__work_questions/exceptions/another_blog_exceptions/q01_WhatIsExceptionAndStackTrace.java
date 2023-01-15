package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;

public class q01_WhatIsExceptionAndStackTrace {
    public static void main(String[] args) {
        System.out.println("Wynik dzielenia to: " + divideTwoInts(25,0));
    }

    private static int divideTwoInts(int x, int y) {
        return x/y;
    }
}

/*
Exception:
    divideTwoInts - metoda ta zwraca nam błąd, gdyż dzielimy przez zero.
    Ten błąd to właśnie wyjątek, który został spowodowany nieprawidłowym działaniem naszego programu.
    W tym przypadku, Maszyna Wirtualna Java poinformowała nas, że wystąpił błąd dzielenia przez zero, a ten konkretny wyjątek nazywa się ArithmeticException.

    Wyjątki (exceptions) to sytuacje, w których coś w programie poszło nie tak.
    Gdy zajdzie taka sytuacja, mówimy, że został rzucony wyjątek.
    Wyjątki mogą być rzucane zarówno przez Maszynę Wirtualna Java, jak i przez nas – programistów – co zobaczymy w dalszej części rozdziału.

    Bardzo ważną cechą wyjątków jest to, że są to tak naprawdę klasy – mają one swoją nazwę, konstruktory, pola i metody.
    Co cechuje klasę, że może być traktowana jako wyjątek?
    Klasa taka musi rozszerzać klasę Throwable lub jedną z jej pochodnych, o czym wkrótce dokładniej sobie opowiemy.
    Rzucanie wyjątków sprowadza się do utworzenia słowem kluczowym new obiektu konkretnej klasy wyjątku i "rzucenie" go za pomocą słowa kluczowego throw.


    Z wyjątkami spotkaliśmy się już w poprzednich rozdziałach – widzieliśmy m. in. wyjątki:
            ** StringIndexOutOfBoundsException – gdy próbowaliśmy odnieść się do znaku w zmiennej typu String za pomocą metody charAt przekazując indeks znaku
                                                    wychodzący poza zakres stringu,
            ** ArrayIndexOutOfBoundsException – gdy odnosiliśmy się do nieistniejącego elementu tablicy,
            ** NullPointerException – gdy próbowaliśmy odnosić się do pól bądź metod niezainicjalizowanego obiektu,
                                        tzn. gdy zmienna typu złożonego wskazywała na null.

    Inne sytuacje, w których moglibyśmy natknąć się na wyjątek, to na przykład:
        * podanie ujemnego wieku podczas tworzenia obiektu typu Osoba,
        * próba otwarcia pliku, który nie istnieje,
        * zerwanie połączenia z internetem podczas próby wysłania danych na serwer,
        * podanie nieprawidłowego hasła podczas łączenia się do serwera baz danych,
        * wiele innych.

    Sytuacje wyjątkowe możemy obsługiwać dzięki mechanizmowi łapania wyjątków, które można znaleźć w q02_CatchClauseBasic.


Stack trace:

    Zauważmy w przykładzie powyżej, jak Maszyna Wirtualna Java prezentuje wyjątek:
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	        at pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q01_WhatIsException.divideTwoInts(q01_WhatIsException.java:10)
	        at pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q01_WhatIsException.main(q01_WhatIsException.java:6)

    Po rodzaju wyjątku i skojarzonym z nim komunikatem w pierwszej linii, następują informacje o ścieżce wykonania programu,
    która doprowadziła do występienia tego wyjątku.

    Jest to tzw. stack trace – ścieżka wykonań metod, które doprowadziły do błędu. Często będziemy analizować stack trace'y programując w Javie.

    Stack trace powinno się śledzić się od dołu, ponieważ prezentowana w nim kolejność metod jest odwrotna do kolejności wykonywania tych metod.
    Ostatnia metoda (ta na dole stack trace'a) została wywołana jako pierwsza, a ta na samej górze – jako ostatnia – i to w niej rzucony został wyjątek.

    W praktyce jednak patrzymy zazwyczaj na kilka pierwszych linii stack trace'a, bo zazwyczaj wystarczają nam one do zrozumienia dlaczego,
    a przynajmniej gdzie, wystąpił wyjątek.


    W naszym przypadku najpierw wywołana została metoda main z klasy q1_WhatIsException:
        at pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q01_WhatIsException.main(q01_WhatIsException.java:6)

    W nawiasach mamy dodatkowo podany plik, z którego klasa pochodzi, a także linię kodu, w której wykonanie metody przeszło do kolejnej metody.
    Ta metoda, jak widzimy patrząc dalej na stack trace, to divideTwoInts:
        at pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q01_WhatIsException.divideTwoInts(q01_WhatIsException.java:10)

    Jeżeli spojrzymy ponownie na kod naszej klasy to zobaczymy, że:
        * linia nr 6 umieszczona w nawiasach w stack trace odnosi się do:  System.out.println("Wynik dzielenia to: " + divideTwoInts(25,0));
        * linia nr 10 umieszczona w nawiasach w stack trace odnosi się do:  return x/y;


    Oznaczenia linii w stack trace zgadzają się z wykonaniem programu, które doprowadziło do zaistnienia wyjątku ArithmeticException:
        1. Program zostaje uruchomiony – rozpoczyna się wykonywanie metody main.
        2. W drugiej linii metody main (zauważmy, że jest to jednocześnie trzecia linia całego programu) następuje wywołanie metody podziel z argumentami 25 i 0.
        3. Wykonanie programu przechodzi do metody divideTwoInts.
        4. Z racji tego, że podaliśmy 0 jako argument y, Maszyna Wirtualna Java rzuca wyjątek ArithmeticException,
            gdy próbujemy wykonać dzielenie przez 0 – dzieje się to w ósmej linii programu.
        5. Program kończy działanie, a na ekran zostaje wypisany zaistniały błąd: typ wyjątku, jego komunikat, oraz omówiony już stack trace.
*/