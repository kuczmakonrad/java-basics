package pl.kuczdev.devcaveblog.a05_utility_helper_classes;
/*
Klasy nieinstancjonowalne:

Klasy nieinstancjonowalne to takie, dla których nie możemy utworzyć instancji - czyli używamy ich w sposób statyczny (nie mam tu na myśli klas abstrakcyjnych,
które też są nieinstancjonowalne).
Takie klasy mają dosyć złą reputację, bo często są nadużywane i stosowane tam, gdzie nie powinny.
Szczególnie widoczne jest to u początkujących programistów, którzy unikają myślenia obiektowego i mają “proceduralne” nawyki.
Jednak takie klasy mają też i swoje akceptowalne zastosowania.

Klasy nieinstancjonowalne to zazwyczaj klasy typu utility/helper, które są zbiorem statycznych metod i pól (często operujące na prymitywach).
Przykładem takich klas są np. java.lang.Math i java.util.Arrays.
Innym przykładem są klasy, które zawierają static method factories dla obiektów o wspólnym interfejsie np. java.util.Collections.
(Od Javy 8 można je umieszczać na interfejsie, nie ma potrzeby tworzenia do tego specjalnej klasy).
Klasy nieinstancjonowalne znajdziemy również w wielu bibliotekach.

Są to klasy, które z założenia nie powinny być instancjonowalne - bo po prostu instancja takiej klasy nie ma sensu.
Nie przechowują żadnego stanu - są tylko zbiorem często wykorzystywanych metod, które z reguły powinny być ze sobą powiązane
(nie ładujemy wszystkiego do jednej klasy, np. metody operujące na stringach nie powinny się mieszać z metodami operującymi na plikach...).

Jedynym słusznym sposobem na to, by klasa była nieinstancjonowalna jest zadeklarowanie dla niej prywatnego konstruktora:

        // Noninstantiable utility classChapter-1
        public class UtilityClass {
            private UtilityClass() {
                throw new AssertionError();
            }
        }

Deklaracja klasy jako abstrakcyjnej nie jest odpowiednim sposobem, aby to osiągnąć (ani do końca nie działa).
Można ją rozszerzyć i wtedy podklasa może być instancjonowalna. Po drugie zachęca to do myślenia, że klasa została stworzona do rozszerzania, a tak nie jest.

Kiedy konstruktor jest prywatny, nie ma możliwości stworzenia instancji klasy poza jej wnętrzem.
throw new AssertionError(); jest tutaj opcjonalnie - zapewnia, aby konstruktor nie zostanie wywołany omyłkowo wewnątrz tej klasy lub poprzez refleksję.

Kiedy implementujemy takie klasy trzeba rozważyć następujące problemy:
    - Nie ma możliwości rozszerzania klasy z prywatnym konstruktorem.
    - Trudność w testowaniu jednostkowym.

Podczas gdy klasę utility można łatwo przetestować w izolacji, to klasy, które ją używają już nie.
Klasy utility najczęściej wykorzystywane są bezpośrednio (UtilityClass.DoStuff()) co w konsekwencji utrudnia ich mockowanie.
Ma to tym większe znaczenie im klasa utility wykonuje cięższe operacje.

* W Javie istnieje narzędzie do testowania o nazwie Powermock, które to potrafi, ale uznawane jest, że jeśli twoja aplikacja potrzebuję tego narzędzia,
aby coś mogło zostać przetestowane, to najprawdopodobniej twoja aplikacja jest źle zaprojektowana i na tym powinieneś się skupić.

Szczególne znaczenie ma to podczas korzystania z frameworków Dependency Injection jak np. Spring.
Wtedy takie klasy powinniśmy być w stanie wstrzyknąć jako zależność, żeby później można było łatwo je zmockować.
W takich przypadkach powinny to być instancjonowalne klasy bez statycznych metod, które można wstrzyknąć jako Singletony.

W Springu beany są Singletonami domyślnie.

Podsumowując, klasy “statyczne” nie są czystym złem, jednak powinny być używane raczej sporadycznie.
Zanim zdecydujesz się na ich użycie, upewnij się czy kolejna metoda, którą będziesz chciał dorzucić do klasy typu “helper”,
nie powinna się znaleźć w bardziej odpowiedniej i konkretnej klasie.
*/


public class UtilityAndHelperClasses {
    private UtilityAndHelperClasses() {
        throw new AssertionError();
    }
}
