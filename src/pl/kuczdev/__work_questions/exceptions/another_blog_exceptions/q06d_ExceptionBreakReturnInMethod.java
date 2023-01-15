package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
Rzucanie wyjątków a wartość zwracana z metody¶
Gdy poznawaliśmy metody, dowiedzieliśmy się, że metoda zawsze musi zwrócić wartość jeżeli definiuje typ zwracany inny niż void.
W przeciwnym razie kompilacja naszego kodu zakończy się błędem:

    public class BrakReturn {
      public static void main(String[] args) {
        int liczbaDoKwadratu = kwadratLiczby(5);
      }
      public static int kwadratLiczby(int x) {
        int wynik = x * x;
        // ups! zapomnielismy zwrocic wynik!
      }
    }

Ten kod kończy się błędem kompilacji missing return statement – zapomnieliśmy zwrócić wartość z metody kwadratLiczby,
a musimy to zrobić – sygnatura metody wskazuje, że metoda ta zwraca wartość int.

W rozdziale o metodach wspomniałem o wyjątku od tej reguły – metoda nie musi zwrócić wartości, jeżeli rzuci wyjątek.
Ma to taki sens, że skoro coś w metodzie poszło nie tak, skoro wystąpił jakiś błąd, to metoda zamiast zwrócić wartość może rzucić wyjątek:

Poniższy kod kompiluje się bez błędów pomimo, że istnieje taka ścieżka wykonania metody podziel,
której nie zwróci ona wartości – jeżeli y będzie równe zero, to rzucony zostanie wyjątek IllegalArgumentException.
Rzucenie wyjątku powoduje natychmiastowe zakończenie działania metody podziel bez zwracania jakiejkolwiek wartości z metody.
Wykonanie programu powraca do metody main, gdzie działanie kontynuowane jest w sekcji catch, w której obsługujemy złapany wyjątek.
Metoda podziel nie zwraca co prawda wartości, ale rzuca wyjątek, co stanowi wyjątek od reguły, że metoda zawsze musi zwracać wartość,
jeżeli definiuje zwracany typ inny niż void.

Zauważ, że wcześniej w tym rozdziale mówiłem, że jeżeli metoda rzuca wyjątek,
to musimy go zdefiniować dodając po nazwie i argumentach metody słowo kluczowe throws oraz nazwy wyjątków, które metoda może rzucić.
W powyższym przykładzie jednak nie ma throws, a kod działa – jak już wspomniałem w tym rozdziale, istnieją dwa rodzaje wyjątków –
takie,które trzeba definiować za pomocą throws i te, których nie trzeba – porozmawiamy o tym w jednym z kolejnych rozdziałów.
 */

public class q06d_ExceptionBreakReturnInMethod {
    public static void main(String[] args) {
        try {
            System.out.println(podziel(10, 0));
        } catch (IllegalArgumentException e) {
            System.out.println("Wystpil wyjatek " + e.getMessage());
        }
    }
    public static int podziel(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Dzielnik nie moze byc rowny 0.");
        }
        return x / y;
    }
}