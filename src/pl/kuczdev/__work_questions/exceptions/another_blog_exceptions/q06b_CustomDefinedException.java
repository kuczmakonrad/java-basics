package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
Definiowanie własnych wyjątków¶
Możemy zdefiniować na własne potrzeby nowe typy wyjątków, ale najpierw wyjaśnijmy, czym w ogóle są wyjątki?

Wyjątki to pochodne klasy Throwable lub jednej z jej klas pochodnych, np. Exception lub RuntimeException.
Klasy te są zdefiniowane w bibliotece standardowej Java.
To właśnie jedna bądź druga z tych klas pochodnych jest używana jako klasa bazowa dla wyjątków definiowanych przez programistów.
Kiedy stosować każdą z nich zobaczymy w jednym z kolejnych rozdziałów, a w tym skupimy się na dziedziczeniu po klasie Exception.

Gdy definiujemy w blokach catch wyjątki do obsłużenia, muszą być one pochodnymi klasy Exception lub RuntimeException (pośrednio bądź bezpośrednio) –
inaczej kod się sie skompiluje. Spójrzmy na najprostszy przykład zdefiniowania własnego wyjątku:

    class NieprawidlowyWiekException extends Exception {
    }


Zdefiniowaliśmy tutaj nową klasę wyjątków – NieprawidlowyWiekException – od teraz możemy łapać wyjątki tego typu w blokach catch.
Aby wskazać, że nasz wyjątek dziedziczy po (rozszerza) klasę Exception, użyliśmy słowa kluczowego extends, poznanego w poprzednim rozdziale.

Zgodnie z konwencją nazewniczą klas wyjątków, na końcu nazwy wyjątku dodaliśmy słowo Exception.
Możemy także w prosty sposób umożliwić zapisywanie w wyjątku naszego typu komunikatu błędu. Utwórzmy jeszcze jedną klasę wyjątków:

    public class NieprawidlowaWartoscException extends Exception {
      public NieprawidlowaWartoscException(String message) {
        // wywolaj konstruktor z klasy bazowej (czyli z Exception)
        super(message);
      }
    }


W tej klasie zdefiniowaliśmy konstruktor, który przyjmuje jako argument komunikat błędu – przesyłamy go do konstruktora klasy bazowej
za pomocą słowa kluczowego super z poprzedniego rozdziału.
Konstruktor z klasy bazowej, Exception, zapisze komunikat w polu, które będzie dostępne za pomocą metody getMessage.
getMessage to metoda, którą nasza klasa wyjątku dziedziczy po klasie bazowej.

Spróbujmy dodać do konstruktora klasy Osoba walidację pól imie oraz wiek – sprawdzimy, czy mają wartość null –
jeżeli tak, to rzucimy wyjątek NieprawidlowaWartoscException z odpowiednim komunikatem. Użyjemy także wyjątku NieprawidlowyWiekException:

    public class Osoba {
      private String imie;
      private String nazwisko;
      private int wiek;
      public Osoba(String imie, String nazwisko, int wiek) {
        if (imie == null) { // 1
          throw new NieprawidlowaWartoscException(
              "Imie nie moze byc puste."
          );
        }
        if (nazwisko == null) { // 2
          throw new NieprawidlowaWartoscException(
              "Nazwisko nie moze byc puste."
          );
        }
        if (wiek <= 0) {
          throw new NieprawidlowyWiekException();
        }
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
      }
      public static void main(String[] args) {
        try {
          Osoba o = new Osoba("Jan", "Nowak", -1);
        } catch (IllegalArgumentException e) {
          System.out.println("Wystapil blad! " + e.getMessage());
        }
      }
    }


Dodaliśmy do konstruktora sprawdzanie wartości imie (1) oraz nazwisko (2). Jednakże podczas próby kompilacji klasy kompilator zaczyna zgłaszać problemy:

        Osoba.java:8: error: unreported exception NieprawidlowaWartoscException; must be caught or declared to be thrown
              throw new NieprawidlowaWartoscException(
              ^
        Osoba.java:14: error: unreported exception NieprawidlowaWartoscException; must be caught or declared to be thrown
              throw new NieprawidlowaWartoscException(
              ^
        Osoba.java:20: error: unreported exception NieprawidlowyWiekException; must be caught or declared to be thrown
              throw new NieprawidlowyWiekException();
              ^
3 errors



Co się stało? Używaliśmy już wcześniej wyjątków i nie napotkaliśmy takiego błędu. Otóż w naszym kodzie brakuje jeszcze jednego elementu.

Wyjątki dzielą się na dwa rodzaje – Checked oraz Unchecked Exceptions.
To, co musimy teraz wiedzieć, to to, że w przeciwieństwie do wyjątków Unchecked, takich jak IllegalArgumentException łapanych wcześniej w tym rozdziale,
potencjał rzucenia wyjątków rodzaju Checked musi zostać zdefiniowany w sygnaturze metody, która może go rzucić. Służy do tego słowo kluczowe throws.

W kolejnym rozdziale dokładnie sobie omówimy wyjątki Checked oraz Unchecked.
Dla dociekliwych – wyjątki Unchecked to wyjątki, które dziedziczą po klasie Runtime Exception. Pozostałe wyjątki to wyjątki Checked.

Spójrzmy na sygnaturę poprawionego konstruktora:

    public Osoba(String imie, String nazwisko, int wiek)
        throws NieprawidlowaWartoscException, NieprawidlowyWiekException {


Po nawiasie zamykającym definicję argumentów konstruktora, a przed klamrą { otwierająca ciało metody, napisaliśmy słowo kluczowe throws,
po którym wypisaliśmy, rozdzielone przecinkami, nazwy typów wyjątków, które nasza metoda może rzucić.
Jest to wymagane, gdy istnieje potencjał rzucenia wyjątku rodzaju Checked –
kompilator Java nie pozwoli skompilować kodu, jeżeli zabraknie klauzuli throws, gdy kompilator zauważy, że metoda może rzucić wyjątek/wyjątki.

Kompilator wie, że wyjątki mogą być rzucone, bo analizując podczas kompilacji kod konstruktora klasy Osoba widzi użycie słowa kluczowego throw do rzucenia wyjątków.
Nie pomyl słów kluczowych throw i throws – pierwsze rzuca wyjątek, a drugie służy do zdefiniowania, jakie wyjątki metoda może rzucić.
Czy teraz kod klasy Osoba się skompiluje? Jeszcze nie – zobaczymy następujący komunikat kompilatora:

    Osoba.java:31: error: unreported exception NieprawidlowaWartoscException; must be caught or declared to be thrown
          Osoba o = new Osoba("Jan", "Nowak", -1);
    1 error


Tym razem kompilator wiedząc, że konstruktor klasy Osoba może rzucić wyjątki, oczekuje od nas, że korzystając z tego konstruktora weźmiemy te potencjalne wyjątki
pod uwagę – innymi słowy, kompilator oczekuje użycia try..catch i obsługi wyjątków NieprawidlowaWartoscException oraz NieprawidlowyWiekException
(chociaż w powyższym komunikacie widnieje nazwa tylko jednego z nich, to po dodaniu jego obsługi w catch kompilator przy kolejnej próbie kompilacji wskazałby,
że wyjątek NieprawidlowyWiekException także należy obsłużyć).

Ponownie widzimy tutaj różnicę między wyjątkami Checked i Unchecked.
Wcześniej w rozdziale, gdy metoda podziel mogła rzucić wyjątek, nie musieliśmy tego wyjątku obsługiwać, bo IllegalArgumentException to wyjątek rodzaju Unchecked.
W konstruktorze klasy Osoba korzystamy natomiast z wyjątków rodzaju Checked, które muszą zostać obsłużone – stąd powyższy błąd kompilacji.
Spójrzmy na kompletny przykład wraz z dodaną obsługą wyjątków za pomocą try..catch:

Powyższy program używa dwóch nowych typów wyjątków, które rzucane są w konstruktorze klasy Osoba.
Wyjątki te obsługiwane są następnie w ciele metody main (1) i (2).

W przypadku obsługi wyjątku typu NieprawidlowaWartoscException, do wypisywanego na ekran komunikatu dodajemy treść błędu,
która zawarta jest w wyjątku – umieściliśmy ją tam rzucając wyjątek w konstruktorze klasy Osoba.
Wiadomość ta zawiera informację, która wartość jest nieprawidłowa. Ta wiadomość zwracana jest przez metodę getMessage.
 */
class NieprawidlowyWiekException extends Exception {
}

class NieprawidlowaWartoscException extends Exception {
    public NieprawidlowaWartoscException(String message) {
        // wywolaj konstruktor z klasy bazowej (czyli z Exception)
        super(message);
    }
}

class Human {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Human(String imie, String nazwisko, int wiek)
            throws NieprawidlowaWartoscException, NieprawidlowyWiekException {
        if (imie == null) { // 1
            throw new NieprawidlowaWartoscException("Imie nie moze byc puste.");
        }

        if (nazwisko == null) { // 2
            throw new NieprawidlowaWartoscException("Nazwisko nie moze byc puste.");
        }

        if (wiek <= 0) {
            throw new NieprawidlowyWiekException();
        }

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }
}

public class q06b_CustomDefinedException {
    public static void main(String[] args) {
        try {
            Human o = new Human("Jan", "Nowak", -1);
        } catch (NieprawidlowaWartoscException e) { // 1
            System.out.println("Nieprawidlowa wartosc: " + e.getMessage());
        } catch (NieprawidlowyWiekException e) { // 2
            System.out.println("Nieprawidlowy wiek!");
        }

        try {
            Human o = new Human(null, "Nowak", 30);
        } catch (NieprawidlowaWartoscException e) { // 1
            System.out.println("Nieprawidlowa wartosc: " + e.getMessage());
        } catch (NieprawidlowyWiekException e) { // 2
            System.out.println("Nieprawidlowy wiek!");
        }
    }
}
