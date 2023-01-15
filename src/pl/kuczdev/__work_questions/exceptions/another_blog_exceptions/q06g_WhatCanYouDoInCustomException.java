package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;

/*
Treść wyjątku, stack trace i inne pola i metody

Wyjątki to klasy jak wszystkie inne – mogą mieć własne konstruktory, metody, i pola. Ich cechą specjalną jest to, że rozszerzają klasę Exception.

Najprostszym wyjątkiem jest klasa, która nie definiuje żadnych pól ani metod (pamiętajmy, że klasa ta otrzyma automatycznie domyślny konstruktor):
    class WyjatekBezTresciException extends Exception {}

Ta klasa jest już gotowa do użycia – możemy rzucać wyjątki tego typu za pomocą throw i łapać za pomocą catch.
Mogłoby się wydawać, że taka klasa nie jest specjalnie przydatna, ale jest całkiem odwrotnie – dobrze nazwana klasa wyjątku bez żadnej dodatkowej treści
może tak samo spełniać swoje zadanie, jak klasy wyjątków ze szczegółowymi komunikatami o błędzie.
W poprzednim rozdziale widzieliśmy taki właśnie przypadek – klasa NieprawidlowyWiekException była pusta – sama jej nazwa i rzucenie takiego wyjątku
daje nam wystarczającą informację, co i dlaczego się stało.

Klasy wyjątków dziedziczą po klasie Exception kilka metod. Jedną z nich jest getMessage, która zwraca treść (komunikat) wyjątku.
Ta treść może być podana podczas rzucania wyjątku – musimy wtedy udostępnić w klasie naszego wyjątku konstruktor, który przyjmie tą wiadomość
i przekaże ją do konstruktora klasy bazowej. Spójrzmy na kolejny przykład wyjątku, który pozwala na zapisanie w wyjątku komunikatu:

    class WyjatekZKomunikatemException extends Exception {
      public WyjatekZKomunikatemException(String message) {
        // przekaz tresc wyjatku do konstruktora klasy bazowej,
        // ktory umiesci ja w polu message, ktore bedzie dostepne
        // za pomoca metody getMessage
        super(message);
      }
    }

Przykładowe utworzenie wyjątku z komunikatem:
    try {
      throw new WyjatekZKomunikatemException("Co tu sie wyprawia?!");
    } catch (WyjatekZKomunikatemException e) {
      System.out.println("Wyjatek zawiera komunikat: " + e.getMessage());
    }

Wynik:
    Wyjatek zawiera komunikat: Co tu sie wyprawia?!


Jeżeli utworzymy wyjątek bez komunikatu, to getMessage zwróci null – zobaczymy to na przykładzie wyjątku WyjatekBezTresciException:
    try {
      throw new WyjatekBezTresciException();
    } catch (WyjatekBezTresciException e) {
      System.out.println("Wyjatek zawiera komunikat: " + e.getMessage());
    }

Wynik:
    Wyjatek zawiera komunikat: null

Czasem tworząc nowy typ wyjątku chcemy w nim mieć możliwość zapisać dodatkowe informacje, którą mogą pomóc podczas próby jego obsługi,
lub by móc zapisać je do pliku logu w celu późniejszej analizy, co poszło nie tak.
Nic nie stoi na przeszkodzie, aby klasa wyjątku definiowała nowe pola, które takie dane będą przechowywać:

    class WyjatekZDodatkowymiDanymiException extends Exception {
      private int pewnaWartosc;
      private String innaWartosc;
      public WyjatekZDodatkowymiDanymiException(
          int pewnaWartosc, String innaWartosc) {
        this.pewnaWartosc = pewnaWartosc;
        this.innaWartosc = innaWartosc;
      }
      public String getMessage() {
        return "Wartosci zapisane w tym wyjatku: " +
            pewnaWartosc + " " + innaWartosc;
      }
    }


Ta klasa wyjątku pozwala na skojarzenie z nim wartości int oraz String poprzez przekazanie ich do konstruktora.
Te wartości możemy potem zobaczyć korzystając z przeładowanej metody getMessage (o przeładowaniu metod mówiliśmy w rozdziale o dziedziczeniu).
Przykładowe użycie mogłoby wyglądać następująco:

    try {
      int pewnaWartosc = 10;
      String innaWartosc = "test";
      throw new WyjatekZDodatkowymiDanymiException(pewnaWartosc, innaWartosc);
    } catch (WyjatekZDodatkowymiDanymiException e) {
      System.out.println("Wyjatek zawiera komunikat: " + e.getMessage());
    }

Wynik:
    Wyjatek zawiera komunikat: Wartosci zapisane w tym wyjatku: 10 test

Moglibyśmy też dodać do powyższej klasy gettery, które zwracałyby wartość pola liczbowego i typu String,
jeżeli potrzebowalibyśmy mieć możliwość bezpośredniego odniesienia się do nich.

Inną metodą, którą wyjątki dziedziczą z klasy bazowej, jest printStackTrace.
Metoda ta wypisuje na standardowe wyjście hierarchię wywołań metod w programie do momentu wystąpienia wyjątku:
    try {
      throw new WyjatekZKomunikatemException("Co tu sie wyprawia?!");
    } catch (WyjatekZKomunikatemException e) {
      System.out.println("Wyjatek zawiera komunikat: " + e.getMessage());
      e.printStackTrace();
    }

Wywołanie e.printStackTrace spowoduje pojawienie się na standardowym wyjściu następujących komunikatów:
    WyjatekZKomunikatemException: Co tu sie wyprawia?!
        at ZawartoscWyjatkowPrzyklady.main(ZawartoscWyjatkowPrzyklady.java:32)

Stack trace opisywałem na początku rozdziału o wyjątkach.
W pierwszej linii znajduje się nazwa klasy wyjątku, po której następuje komunikat wyjątku.
Następnie podane są metody i numery linii, który były po kolei wywoływane do momentu, w którym wystąpił wyjątek
(te metody posortowane są, patrząc od góry, od ostatniej wywołanej do pierwszej).
Umożliwia to prześledzenia wykonania programu aż do zaistnienia błędu i ułatwia analizę okoliczności, w jakich napotkany został problem.
 */


class WyjatekZDodatkowymiDanymiException extends Exception {
    private int pewnaWartosc;
    private String innaWartosc;
    public WyjatekZDodatkowymiDanymiException(
            int pewnaWartosc, String innaWartosc) {
        this.pewnaWartosc = pewnaWartosc;
        this.innaWartosc = innaWartosc;
    }
    public String getMessage() {
        return "Wartosci zapisane w tym wyjatku: " +
                pewnaWartosc + " " + innaWartosc;
    }
}

class WyjatekBezTresciException extends Exception {}

class WyjatekZKomunikatemException extends Exception {
    public WyjatekZKomunikatemException(String message) {
        // przekaz tresc wyjatku do konstruktora klasy bazowej,
        // ktory umiesci ja w polu message, ktore bedzie dostepne
        // za pomoca metody getMessage
        super(message);
    }
}

public class q06g_WhatCanYouDoInCustomException {
    public static void main(String[] args) {
        try {
            throw new WyjatekZKomunikatemException("Co tu sie wyprawia?!");
        } catch (WyjatekZKomunikatemException e) {
            System.out.println("Wyjatek zawiera komunikat: " + e.getMessage());
        }

        try {
            throw new WyjatekBezTresciException();
        } catch (WyjatekBezTresciException ex) {
            System.out.println("Wyjatek zawiera komunikat: " + ex.getMessage());
        }

        try {
            int pewnaWartosc = 10;
            String innaWartosc = "test";
            throw new WyjatekZDodatkowymiDanymiException(pewnaWartosc, innaWartosc);
        } catch (WyjatekZDodatkowymiDanymiException et) {
            System.out.println("Wyjatek zawiera komunikat: " + et.getMessage());
        }
    }
}