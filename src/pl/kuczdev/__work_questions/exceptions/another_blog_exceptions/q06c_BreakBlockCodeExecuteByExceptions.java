package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;

/*
Przerywanie wykonania bloku kodu przez wyjątki¶
Chociaż widzieliśmy w poprzednim rozdziale, jak rzucanie wyjątku wpływa na wykonanie bloku kodu, w którym wyjątek wystąpił,
to warto jeszcze raz omówić to zagadnienie.

W momencie rzucenia wyjątku przerywany jest aktualnie wykonywany blok kodu.
W przypadku konstruktora klasy Osoba, gdy okaże się, że przesłane imię jest nullem, wykonanie konstruktora klasy Osoba natychmiast się kończy –
kolejne pola nie będą już sprawdzane – konstruktor kończy działanie.
Nasz program kontynuuje wykonanie od sekcji catch, która odpowiedzialna jest za obsłużenie tego konkretnego wyjątku.

Oznacza to, że jeżeli przekazalibyśmy do konstruktora klasy Osoba wartość null dla imienia, null dla nazwiska, oraz -1 dla wieku,
to rzucony zostałby tylko jeden wyjątek – ten, który zasygnalizowałby nieprawidłowe imię, ponieważ to to pole sprawdzamy jako pierwsze.

Spójrzmy na konstruktor z poprzedniego przykładu:
    public Osoba(String imie, String nazwisko, int wiek)
        throws NieprawidlowaWartoscException, NieprawidlowyWiekException {
      if (imie == null) {
        throw new NieprawidlowaWartoscException( // 1
            "Imie nie moze byc puste."
        );
      }
      if (nazwisko == null) {
        throw new NieprawidlowaWartoscException( // 2
            "Nazwisko nie moze byc puste."
        );
      }
      if (wiek <= 0) {
        throw new NieprawidlowyWiekException(); // 3
      }
      this.imie = imie; // 4
      this.nazwisko = nazwisko;
      this.wiek = wiek;
    }

Poniższe wywołanie konstruktora: Osoba o = new Osoba(null, null, -1);
Spowoduje, że wykona się tylko fragment konstruktora do linii oznaczonej jako (1) – od tej linii wykonanie dalszej części ciała konstruktora zostanie przerwane,
ponieważ rzucony zostanie wyjątek.


Następujące wywołanie: Osoba o = new Osoba("Jan", null, -1);
Spowoduje, że wykona się tylko fragment konstruktora do linii oznaczonej jako (2).

Idąc dalej tym tropem: Osoba o = new Osoba("Jan", "Nowak", -1);
W tym przypadku, konstruktor zostanie przerwany w linii (3).

W żadnym z powyższych przypadków nigdy nie dojdzie do wykonania kodu zaczynającego się od linii (4), a co ważniejsze, obiekt typu Osoba nie zostanie utworzony.

Dopiero poniższe wywołanie konstruktora, które zawiera poprawne wartości dla imienia, nazwiska, oraz wieku,
spowoduje wykonanie całego ciała konstruktora klasy Osoba oraz utworzenie i zwrócenie nowego obiektu klasy Osoba: Osoba o = new Osoba("Jan", "Nowak", 30);
 */
public class q06c_BreakBlockCodeExecuteByExceptions {
}
