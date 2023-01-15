package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
Zakres zmiennych definiowanych w bloku try:
    Wielokrotnie przy okazji omawiania instrukcji warunkowych, pętli, metod itp.
    widzieliśmy, że zmienne definiowane wewnątrz bloków kodu są niewidoczne poza tymi blokami, jeżeli nie wskazuje na nie żadna referencja spoza tego bloku.
    Jeżeli zdefiniujemy zmienną w bloku try, to po zakończeniu tego bloku przestanie ona istnieć
     – nie będziemy mieli do niej dostępu nawet w sekcjach catch i finally – spójrzmy na przykład:

            try {
              int wynik = podziel(10, 2);
            } catch (ArithmeticException e) {
              System.out.println("Blad dzielenia, zmienna wynik ma wartosc: " + wynik);
            } finally {
              System.out.println("Sekcja finally: wynik wynosi " + wynik);
            }

    Ten fragment kodu powoduje następujące błędy kompilacji
            C:\Users\...\IdeaProjects\DesignPatterns\src\pl\kuczdev\__work_questions\exceptions\another_blog_exceptions\q04_RangeOfVariableInTryClause.java:37:79
            java: cannot find symbol
              symbol:   variable wynik
              location: class pl.kuczdev.__work_questions.exceptions.another_blog_exceptions.q04_RangeOfVariableInTryClause


W sekcjach catch i finally próbujemy odnieść się do nieistniejącej zmiennej – zmienna wynik istnieje jedynie w bloku try, bo w nim została zdefiniowana.
W praktyce często zachodzi potrzeba korzystania "na zewnątrz" sekcji try z tworzonych w niej zmiennych, czy też w sekcji finally.
W takich przypadkach należy zdefiniować zmienną przed sekcją try:

    int wynik = 0;
    try {
      wynik = podziel(10, 2);
    } catch (ArithmeticException e) {
      System.out.println("Blad dzielenia, zmienna wynik ma wartosc: " + wynik);
    } finally {
      System.out.println("Sekcja finally: wynik wynosi " + wynik);
    }
    System.out.println("Po try wynik wynosi " + wynik);


Wynik działania:
    Sekcja finally: wynik wynosi 5
    Po try wynik wynosi 5

Zauważmy jeszcze jedną istotną cechę powyższego kodu – zmienna wynik została zainicjalizowana wartością 0.
Jeżeli byśmy tego nie zrobili, to kod ponownie by się nie skompilował.
Kompilator zgłosiłby błąd variable wynik might not have been initialized.
Powodem błędu byłby fakt, że metoda podziel może rzucić wyjątek i nie zwrócić żadnej wartości
– w takim przypadku zmiennej wynik nie zostałaby przypisana żadna wartość, a jak wiemy z rozdziału o zmiennych
– zmienne lokalne muszą być zainicjalizowane wartością przed użyciem. Dlatego przed blokiem try, w linii,
w której definiujemy zmienną wynik, nadajemy jej od razu wstępną wartość.
Jeżeli korzystalibyśmy z zmiennej typu złożonego, to jako wartość domyślną moglibyśmy przypisać np. null.

 */

public class q04_RangeOfVariableInTryClause {
    public static void main(String[] args) {
        int wynik = 0;
        try {
            wynik = 10/2;
        } catch (ArithmeticException e) {
            System.out.println("Blad dzielenia, zmienna wynik ma wartosc: " + wynik);
        } finally {
            System.out.println("Sekcja finally: wynik wynosi " + wynik);
        }
        System.out.println("Po try wynik wynosi " + wynik);
/*
        try {
            int wynik = 10/2;
        } catch (ArithmeticException e) {
            System.out.println("Blad dzielenia, zmienna wynik ma wartosc: " + wynik);
        } finally {
            System.out.println("Sekcja finally: wynik wynosi " + wynik);
        }
*/
    }
}
