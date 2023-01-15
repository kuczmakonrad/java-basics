package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
W poprzednich przykładach, wyjątek ArithmeticException rzucany był przez Maszynę Wirtualną Java, jednak nie jest to jedyna możliwość rzucania wyjątków
– my, jako programiści, możemy sami rzucać wyjątki z naszych metod.

Rzucanie wyjątków odbywa się poprzez użycie słowa kluczowego throw, po którym następuje tworzenie obiektu wyjątku takiego typu, jaki chcemy rzucić.
Spójrzmy na przykład obsługi sytuacji, gdy ktoś poda ujemny wiek podczas tworzenia obiektu typu Osoba.

Wynik działania tego programu to:
    Wystąpił błąd: Wiek nie może być ujemny ani równy 0!

W konstruktorze klasy Osoba sprawdzamy, czy wiek jest niepoprawny – jeżeli tak (1), to rzucamy wyjątek za pomocą składni:
    throw new IllegalArgumentException("Wiek nie moze byc ujemny.");

Zauważmy, że po słowie kluczowym throw umieszczamy wyjątek, jaki ma zostać rzucony – w tym przypadku tworzymy nowy wyjątek typu IllegalArgumentException,
zdefiniowany w bibliotece standardowej Java. Jako parametr konstruktora możemy podać opcjonalny komunikat błędu.

Rzucać możemy wyjątki dowolnego typu – zarówno te zdefiniowane już w bibliotece standardowej Java jak i zdefiniowane przez nas.
Wyjątek IllegalArgumentException to często stosowany wyjątek mający na celu wskazanie, że pewne dane są nieprawidłowe, tak jak w powyższym przypadku.
Wiek nie może być ujemny, a taką wartość przekazujemy do konstruktora klasy Osoba (2).
Wyjątek łapiemy w sekcji catch (3) i obsługujemy, wypisując na ekran komunikat.


Wyjątek to nic innego jak obiekt konkretnej klasy – tej, której wyjątek chcemy zasygnalizować.
Tworzymy go tak jak wszystkie obiekty do tej pory – za pomocą słowa kluczowego new:
    throw new IllegalArgumentException("Dzielnik nie moze byc rowny 0.");

Równie dobrze moglibyśmy powyższy kod zapisać jako:
    IllegalArgumentException exc = new IllegalArgumentException("Dzielnik nie moze byc rowny 0.");
    throw exc;

Stosujemy jednak to pierwsze podejście, ponieważ jest krótsze.
 */
class Osoba {
    String imie;
    String nazwisko;
    private int wiek;

    public Osoba(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;

        if (wiek <= 0) {
            throw new IllegalArgumentException("Wiek nie może być ujemny ani równy 0!");
        }

        this.wiek = wiek;
    }
}

public class q06a_CustomExceptionBasic {
    public static void main(String[] args) {
        try {
            Osoba osoba = new Osoba("Kamil", "Kowalski", -3);
        } catch(IllegalArgumentException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }

    }
}
