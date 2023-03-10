package pl.kuczdev.devcaveblog.a41_exceptions;

/*
W tym rozdziale będzie mowa o wyjątkach.

    Wyjątki w Javie są, jakie są, ale ogólnie jest to całkiem użyteczne narzędzie.
    Gdy są używane prawidłowo, mogą zwiększyć czytelność programu, jego stabilność i utrzymywalność.
    Z kolei, jeśli będą używane niepoprawnie, uzyskamy dokładnie odwrotny efekt, dlatego warto poświęcić im kilka słów.

Wyjątki powinny być używane tylko w wyjątkowych sytuacjach:
    Zresztą sama nazwa na to wskazuje. Niestety nie każdy o tym pamięta i dlatego wyjątki są często nadużywane.

    Oto przykład:

        // Horrible abuse of exceptions. Don't ever do this!
        try {
            int i = 0;
            while(true) range[i++].climb();
        } catch (ArrayIndexOutOfBoundsException e) {

        }


    Co ten kod robi?
        Nie jest to oczywiste na pierwszy rzut oka, ale jest to po prostu najzwyklejsza iteracja po elementach tablicy.
        Nieskończona pętla while jest przerywana przez rzucenie wyjątku ArrayIndexOutOfBoundsException, złapanie go, a następnie zignorowanie.

    Normalny człowiek napisałby to tak:

        for (Mountain m : range)
            m.climb();


    W poprzednim przykładzie mamy wiele przykładów złych praktyk:
        * użycie wyjątku tam, gdzie jest to zbędne;
        * ignorowanie wyjątku;
        * wynajdowanie koła na nowo;
        * użycie wyjątków do sterowania przepływem programu;


    Poza tym samo umieszczanie kodu w try-catch uniemożliwia niektóre optymalizacje JVM, które bez niego zostałyby zastosowane.

    Wyjątków nie powinno się używać do sterowania przepływu programu, ponieważ wtedy łatwiej o bugi, które nawet mogą być przez to ukryte,
    co również utrudnia debugowanie.

    Wystarczy sobie wyobrazić, że w pętli byłaby wykonywana jakaś inna metoda, która też miałaby możliwość rzucić ArrayIndexOutOfBoundsException
    z całkiem innej, niepowiązanej tablicy.
    W takiej sytuacji ten błąd spowodowałby, że pętla zakończyłaby się wcześniej, niż powinna i zostałoby to potraktowane jako prawidłowe zachowanie
    (wyjątek jest ignorowany, nieważne co go wywołało).

    Te same zasady dotyczą projektowania API.
    Dobrze zaprojektowane API nie powinno zmuszać użytkownika, by używał wyjątków do sterowania przepływem programu.

    Klasa, która ma metodę zależną od stanu, która może być wywołana tylko pod określonymi warunkami, powinna udostępniać metodę sprawdzającą stan
    i określającą czy użycie metody zależnej od stanu jest odpowiednie.

    Przykładem może być interfejs Iterator, który ma metodę zależną od stanu next i sprawdzającą stan hasNext.
    Dzięki temu mamy możliwość użycia go w zwykłych pętlach for:

        for (Iterator<Foo> i = collection.iterator(); i.hasNext(); ) {
            Foo foo = i.next();
            ...
        }


    Jeśli nie byłoby metody hasNext, wtedy bylibyśmy zmuszeni do tego:

        // Do not use this hideous code for iteration over a collection!
        try {
            Iterator<Foo> i = collection.iterator();
            while(true) {
                Foo foo = i.next();
                ...
            }
        } catch (NoSuchElementException e) {
        }


    Co ma wszystkie wady wspomniane wcześniej.

    Alternatywą dla metod testujących stan jest by metody zależne od stanu zwracały pusty Optional lub inną rozróżnialną wartość jak np. null.

    Należy to stosować, jeśli obiekt jest używany współbieżnie bez zewnętrznej synchronizacji lub udostępnia zmianę stanu z zewnątrz,
    ponieważ stan obiektu mógłby być zmieniony pomiędzy wywołaniami metody sprawdzającej, a tej zależnej od stanu.

    Obawy o wydajność mogłyby dyktować użycie klasy Optional czy innej rozróżnialnej wartości, gdy metoda testująca duplikowałaby pracę metody zależnej od stanu,
    jednak ze wpisów o optymalizacji wiemy, że w większości wypadków nie powinniśmy się martwić o takie mikro optymalizacje.
    Metoda testująca stan oferuje lepszą czytelność i nieprawidłowe użycie jest łatwiejsze do wykrycia — jeśli zapomnimy wywołać metodę testującą,
    to metoda zależna od stanu rzuci wyjątek i błąd będzie oczywisty.
    Jeśli zapomnimy sprawdzić rozróżnialną wartość, która oznacza błąd, wtedy błąd może być trudniejszy do wychwycenia.
    Oczywiście nie dotyczy to użycia Optional, ponieważ jest jasne, że metoda może nie zwrócić danej wartości i należy sprawdzić, czy istnieje.

    Kiedyś ta zasada miała dużo większe znaczenie, bo miała znaczny wpływ na wydajność.
    Obecnie w większości przypadków powinniśmy się kierować przejrzystością i prostotą kodu.
    Warto zerknąć na link I’ve been told that Exceptions should only be used in exceptional cases.
    A szczególnie na odpowiedź:

        How do I know if my case is exceptional?

         Exceptions were invented to help make error handling easier with less code clutter.
         You should use them in cases when they make error handling easier with less code clutter.
         This “exceptions only for exceptional circumstances” business stems from a time when exception handling was deemed an unacceptable performance hit.
         That’s no longer the case in the vast majority of code, but people still spout the rule without remembering the reason behind it.
         Especially in Java, which is maybe the most exception-loving language ever conceived, you shouldn’t feel bad about using exceptions when
         it simplifies your code.

     Warto również rzucić okiem na Java Pitfalls - Exception usage (https://java.programmingpedia.net/en/tutorial/5381/java-pitfalls-exception-usage),
     gdzie znajdziemy przykłady problemów związanych z obsługą wyjątków



Rodzaje wyjątków i kiedy jakie używać:

    W Javie mamy trzy rodzaje wyjątków: checked exceptions, runtime exceptions i errors.
    Dwa ostatnie należą do grupy unchecked exceptions.

    Różnica pomiędzy nimi jest taka, że używając checked exceptions w metodzie, musimy go zadeklarować w sekcji throws i zmuszamy użytkownika tej metody,
    by obsłużył dany wyjątek używając try catch lub aby podał go do obsługi wyżej deklarując ten wyjątek w sekcji throws.
    Z kolei unchecked exceptions są bardziej elastyczne w użyciu i nie ma przymusu ich obsługi czy deklarowania w sekcji throws.

    Decyzja, kiedy jaki rodzaj wyjątku użyć nie jest zawsze jednoznaczna, ale są ogólnie akceptowalne reguły i wskazówki, którymi powinniśmy się kierować.

    W Javie jest silne akceptowalna konwencja, że errors są zarezerwowane do użycia przez JVM i najlepiej nie implementować żadnych nowych podklas klasy Error
    jak również nigdy nie rzucać tych już istniejących, z wyjątkiem AssertionError.
    Implementując unchecked exception powinniśmy rozszerzać klasę RuntimeException.


Więc kiedy używać checked exceptions, a kiedy unchecked exceptions?

    Najczęściej spotkamy się z zasadą, że checked exceptions powinny być używane w sytuacjach, gdy wiemy, że użytkownik ma szansę wyjść z tego błędu cało.
    Jeśli metoda rzuca unchecked exception to zazwyczaj oznacza, że nie może kontynuować wykonywania operacji,
    bo zakończyłoby się to niepowodzeniem i wyrządziłoby to więcej szkód niż dobra.

    Najczęstszym przypadkiem w tej sytuacji jest złe użycie API przez użytkownika, który nie dotrzymał wymagań specyfikacji API.
    Dla przykładu aby dostać się do wartości tablicy, specyfikacja mówi, że index musi być pomiędzy 0, a długością tablicy odjąć 1.
    Jeśli popełnimy błąd i podamy niepoprawny index to dostaniemy ArrayIndexOutOfBoundsException.

    Unchecked exceptions są zatem najczęściej używane, by wskazać błąd programistyczny, z którego nie można już łatwo wyjść.

    Jak sam autor zauważa w książce, niestety nie zawsze jest jasne, kiedy mamy do czynienia z „recoverable condition”, a kiedy z „programming error”.
    Musimy więc kierować się własnym przeczuciem i stwierdzić czy dany błąd ma być „z góry” widoczny dla użytkownika i wymusić na nim obsługę tego błędu
    (i wtedy użyć checked exception), czy chcemy wskazać błąd „po cichu” w trakcie wykonywania programu, bez wymuszania obsługi tego błędu
    (korzystając z unchecked exception).

    Warto pamiętać, że wyjątki to pełnoprawne klasy, które mogą mieć pola i metody.
    Podstawowe zastosowanie takich metod to udostępnienie poszczególnych szczegółów, które były przyczyną wystąpienia danego wyjątku.
    Gdy brakuje takich metod, programiści mogliby próbować wyciągnąć te dane, parsując message, co jest złą praktyką — taki message może się zmienić
    w każdej chwili i nasz kod przestanie działać.
    Szczególnie jest to ważne w przypadku checked exception, bo oczekujemy, że użytkownik będzie chciał obsłużyć ten błąd, więc może potrzebować tych szczegółów.


Dlaczego checked exceptions są problematyczne i lepiej ich unikać
    Jak już sobie powiedzieliśmy, checked exceptions użyte prawidłowo poprawiają jakość API i programów.
     W przeciwieństwie do kodów błędów czy unchecked exceptions zmuszają programistów do obsłużenia możliwych problemów, zwiększając niezawodność programu.

    Z drugiej strony wielu programistów Java nie lubi checked exceptions ponieważ są nieprzyjemne w użyciu.
    Nakładają z góry na użytkownika obowiązek obsłużenia danego błędu w jednym lub wielu blokach catch, co generuje masę boilerplate-u.
    Również definicja metody rozciąga się mocno przez deklarowanie wszystkich wyjątków w sekcji throws.

    W Javie 8+ jest jeszcze gorzej, bo w streamach nie można bezpośrednio używać metod, które rzucają checked exceptions.

    Pisanie prostych programów jest przez to problematyczne, bo nie zawsze chcemy od razu obsługiwać milion casów.
    Dobrym przykładem są problemy IO, gdy chcemy dostać się do pliku.
    W prostym programie wysypanie się programu ze stosownym komunikatem byłoby wystarczające, ale nie, w Javie musimy od razu obsłużyć te sytuacje.
    Ewentualnie powstają twory takie jak:

        try {
            // checked exception throwing method call
        } catch (TheCheckedException e) {
            throw new AssertionError(); // Can't happen!
        }


    czy:

        try {
            // checked exception throwing method call
        } catch (TheCheckedException e) {
            e.printStackTrace();        // Oh well, we lose.
            System.exit(1);
        }


    To obciążenie może być uzasadnione tylko w przypadkach, gdy poprawne użycie API nie załatwi sprawy i użytkownik korzystający z metody
    rzeczywiście powinien coś z tym zrobić — w przeciwnym wypadku powinniśmy użyć unchecked exception.

    Dobrym kompromisem może też być użycie klasy Optional i całkowita rezygnacja z wykorzystania wyjątków,
    jednak w tym rozwiązaniu nie będziemy mogli udostępnić żadnych szczegółów na temat błędu.
*/
public class Exceptions {
}
