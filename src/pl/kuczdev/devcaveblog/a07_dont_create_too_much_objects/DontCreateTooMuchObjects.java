package pl.kuczdev.devcaveblog.a07_dont_create_too_much_objects;

/*
Są sytuację, kiedy powinniśmy reużywać jeden obiekt za każdym razem kiedy jest potrzebny, zamiast tworzyć kolejny, który jest funkcjonalnie identyczny.
Nie wnioskuj jednak z tego wpisu, że tworzenie obiektów jest kosztowne i powinno być unikane.
Wręcz przeciwnie.
Tworzenie i zwalnianie z pamięci małych obiektów, których konstruktory nie wykonują dużo pracy nie jest kosztowne.
Ponadto, tworzenie dodatkowych obiektów, żeby zwiększyć klarowność i prostotę kodu to zazwyczaj dobra rzecz.

W idealnym świecie, obiekty powinny być niemutowalne i krótko żyjące!

Czasem jednak dobrze jest unikać tworzenia niepotrzebnych obiektów.
Jednym z sposobów, na to jest static factory method o której była mowa w pierwszym wpisie.

Np. Boolean.valueOf(String s) jest preferowanym sposobem tworzenia Boolean, zamiast poprzez konstruktor Boolean(String s) (który swoją drogą jest deprecated od Javy 9).
Tworzy on za każdym wywołaniem nowy obiekt, co w przypadku klasy Boolean, która ma tylko dwa stany (true i false) jest całkowicie zbędne.

Szczególnie obiekty, które są bardzo często używane zasługują na naszą uwagę w tej kwestii!

Czasem jednak nie jest to takie oczywiste, że nasz kod niepotrzebnie tworzy nadmiarowe obiekty.

Dobrym przykładem tutaj jest autoboxing, który pozwala nam mieszać prymitywy (np. int, boolean) z ich wrapperami (np. Integer, Boolean).
Jako przykład weźmy funkcję, która zlicza sumę wszystkich pozytywnych wartości int.
W takiej sytuacji do przetrzymywania wyniku użyjemy long, bo int nie jest wystarczająco duży, aby pomieścić wynik:

    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

Przez jeden mały szczegół w tym kodzie wydajność programu jest dużo słabsza niż powinna być.
Mowa tu o deklaracji Long sum = 0L;.
Zamiast long jest użyty wrapper Long, co skutkuje tym, że program tworzy 2^31 niepotrzebnych instancji Long.
Dzieję się to w miejscu, kiedy do Long sum jest dodawane long i, a więc long i jest autoboxowane na Long.

Przez tą jedną literkę wykonanie tej funkcji na moim laptopie trwało ~7 sekund zamiast ~1 sekundy.
Joshua Bloch podał, że na jego sprzęcie było odpowiednio 6.3 sekundy i 0.59 sekundy.

Wniosek: preferuj prymitywy i zwracaj uwagę na autoboxing!!



Innym dobrym przykładem jest często wykorzystywana metoda String.matches("regexp"). Dajmy na to, że mamy taką oto metodę, która sprawdza, czy liczba jest poprawną liczbą rzymską:

    public class RomanNumerals {
        static boolean isRomanNumeral(String s) {
            return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        }
    }


Użycie takiej funkcji w pętli jest mało wydajnym rozwiązaniem.
Jest tak dlatego, że metoda matches wewnętrznie tworzy obiekt Pattern z podanego przez nas w stringu regexpa.
Tworzenie obiektu Pattern jest całkiem kosztowne, a tworzenie go w pętli za każdym razem takiego samego jest całkowicie zbędne.
W takich przypadkach powinniśmy operować na jednej instancji Pattern:

    public class RomanNumerals {
        private static final Pattern ROMAN = Pattern.compile(
                "^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        static boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }
    }

ZALETY:
    + Lepsza wydajność
        Jednak trzeba mieć na uwadze, że jest sens się tym przejmować, tylko wtedy kiedy obiekt na prawdę jest non stop w użyciu, a jego konstruktor wykonuje sporo pracy.
        Testując wydajność tych rozwiązań na prostej pętli wyniki nie różniły się bardzo od siebie. Sprawdzałem to używając JMH.
        U mnie, w pętli, która kręci się 200 000 razy jest to różnica rzędu ~200ms.
    + Lepsza czytelność
        Tutaj dodatkowym plusem jest zwiększona czytelność, bo Pattern jest nazwany i jasno wyraża swoje intencje.



Nieco inny, trochę ekstremalny przypadek, który jest też podany w książce to:

    String s = new String("bikini");

Jest to nadmiarowe tworzenie nowej instancji stringa za każdym razem kiedy ta linijka jest wykonywana.
Argument konstruktora "bikini" jest już sam w sobie instancją klasy String.
Zauważ, że można normalnie na nim wykonywać metody, np.:

    "bikini".equals("naked"); //false

Jeśli takie użycie ma miejsce w pętli czy często wykorzystywanej funkcji, w konsekwencji może zostać utworzonych tysiące niepotrzebnych obiektów.
Każda klasa ma swój constant pool - listę stałych wartości, które mogą być reużywane, jeśli często występują w kodzie źródłowym. Zaliczamy do tego stringi, numery, nazwy metod, itd.

Jednak new String("abc") nie jest aż tak kosztowną operacją jaką mogłoby się wydawać, bo wewnętrzna reprezentacja tekstu jest reużywana.
Co nie oznacza, że nie powinieneś unikać takiej konstrukcji.
Dlatego zawsze stosuj po prostu:

    String s = "bikini";




Jak wspomniałem wcześniej, nie zawsze tworzenie dodatkowych obiektów jest kosztowne. Czasem nawet kod, który wydaje się być osobną operacją wcale nią nie jest.

Dobrym przykładem jest konkatenacja stringów. Jeśli stringi są znane podczas kompilacji, to te dwie operacje niczym się nie różnią:

    String one = "abc";
    String two = "ab" + "c";


Druga opcja wcale nie jest dodatkową operacją.
Kompilator wykona konkatenację podczas czasu kompilacji i wygenerowany kod nie będzie się niczym różnił.
Są one nawet referencjami do tych samych obiektów, o czym była mowa w notatce wcześniej.

    one == two; //true


Z kolei używając konstruktora:

    String three = new String("abc");


co jest tym samym co:

    String three = new String(one);


wartości będą te same, ale nie będą już to referencje do tych samych obiektów:

    three == one; //false
*/
public class DontCreateTooMuchObjects {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(notEffectiveSum());
        long t2 = System.currentTimeMillis() - t1;
        System.out.println("Not effective way time: " + ((double)t2/1000) + " sec");

        long t3 = System.currentTimeMillis();
        System.out.println(effectiveSum());
        long t4 = System.currentTimeMillis() - t3;
        System.out.println("Effective way time: " + ((double)t4/1000) + " sec");
    }

    private static long notEffectiveSum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

    private static long effectiveSum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

}
