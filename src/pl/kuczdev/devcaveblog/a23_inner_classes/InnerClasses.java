package pl.kuczdev.devcaveblog.a23_inner_classes;

/*
Klasa wewnętrzna (ang. nested class) to po prostu klasa zdefiniowana wewnątrz innej klasy i powinna służyć tylko w klasie, w której się znajduje.
Jeśli klasa jest też użyteczna gdzieś indziej, to powinna być zwykłą klasą (ang. top-level class).

Są cztery typy klas wewnętrznych:
    * static member class
    * nonstatic member class
    * anonymous class
    * local class

Jeśli chodzi o nazewnictwo, to klasa wewnętrzna zadeklarowana jako static nazywana jest też static nested class, a wszystkie pozostałe inner class.

Statyczne klasy wewnętrzne (Ang. Static Nested Classes):

    Statyczne klasy wewnętrzne są najczęściej wykorzystywanymi klasami z tej grupy i często są preferowane.
        * Mają dostęp do wszystkich statycznych elementów klasy, w której jest zadeklarowana, nawet tych zadeklarowanych jako private.
        * Jak to ze statycznymi elementami, należą do klasy, a nie do jej instancji.
        * Nie potrzebują instnacji klasy, w której się znajdują.
        * Mogą mieć wszystkie modyfikatory dostępu.
        * Można w nich deklarować zarówno elementy statyczne i niestatyczne.

    Najczęściej wykorzystuje się je jako publiczne helpery.
    Często w ten sposób implementuje się np. wzorzec projektowy Builder.

    Klasy private static member często wykorzystuje się do reprezentacji poszczególnych komponentów w klasie, w której się znajdują.
    Przykładowo wiele implementacji interfejsu Map ma wewnątrz obiekt Entry, dla każdej pary klucz-wartość.
    Każdy taki obiekt jest powiązany z mapą, ale metody z Entry (getKey, getValue, i setValue) nie wymagają dostępu do niej.
    Dlatego użycie niestatycznej klasy w tym przypadku byłoby nieuzasadnione.


Niestatyczne klasy wewnętrzne (Ang. Non-Static Nested Classes):

    Tak jak niestatyczne zmienne czy metody, każda instancja niestatycznej klasy wewnętrznej jest powiązana z instancją klasy, w której się znajduje.
        * Może mieć wszystkie modyfikatory dostępu.
        * Ma dostęp do wszystkich elementów klasy bez względu na to, czy są statycznie, czy nie.
        * Może deklarować tylko elementy niestatyczne.

        public class Outer {
            public class Inner {
                // ...
            }
        }


    Niemożliwe jest utworzenie niestatycznej klasy wewnętrznej bez instancji klasy, w której się znajduje, więc najpierw trzeba ją stworzyć:

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();


    Jeśli mielibyśmy takie same nazwy metod w obu klasach, to moglibyśmy uzyskać referencję do tej top-level używając tzw. qualified this:

        public class Enclosing {
          void x() {
            System.out.println("Hello");
          }

          public class Inner {
            public void x() {
              Enclosing.this.x(); // Qualified this, prints "Hello"
            }
          }
        }


    Takie klasy często używane są do implementacji Adaptera (Wzorzec projektowy), który pozwala na użycie klasy jako jakiejś innej niepowiązanej klasy.
    Dla przykładu, implementacje interfejsu Map używają niestatycznej klasy wewnętrznej,
    aby zaimplementować różne widoki kolekcji, które są zwracane przez metody keySet, entrySet, i values.
    Podobnie implementacje Set i List używają ich do implementacji iteratorów.
    Wygląda to mniej więcej tak:

        public class MySet<E> extends AbstractSet<E> {
            // Bulk of the class omitted

            @Override
            public Iterator<E> iterator() {
                return new MyIterator();
            }

            private class MyIterator implements Iterator<E> {
                //...
            }
        }

    Jeśli klasa wewnętrzna nie potrzebuję dostępu do instancji klasy, w której się znajduje, to powinna być static.
    Jeśli tego nie zrobimy, to każda instancja wewnętrznej klasy będzie miała zbędną referencję do klasy w której się znajduje, co zajmuję zbędny czas i miejsce,
    a czasem może wstrzymać garbage collection.


Klasy anonimowe (Ang. Anonymous Classes):

    Anonimowe klasy są używane do zdefiniowania implementacji klasy “w locie”, bez potrzeby tworzenia osobnej, reużywalnej klasy.
    Często też używa się do stworzenia instancji klasy z nadpisanymi tylko kilkoma metodami.
    Daje nam to możliwość zmodyfikowania zachowania, bez tworzenia podklasy.
    Klasy anonimowe:
        * Nie mają nazwy
        * Nie mają modyfikatorów dostępu
        * Mają dostęp do statycznych i niestatycznych elementów klasy, którą implementują (z wyjątkiem elementów private)
        * Nie mają kontruktorów
        * Nie mogą rozszerzać/implementować innych klas i interfejsów
        * Nie mogą mieć żadnych statycznych elementów oprócz stałych, które są prymitywami lub stringami z modyfikatorem final.
        * Nie możemy użyć żadnych elementów, które zdefiniowaliśmy dodatkowo w klasie anonimowej.
            Można wywoływać tylko te, które są zdefiniowane w implementowanej klasie.
        * Nie użyjemy na nich instanceof ani nic innego co wymaga nazwy klasy.

    Definiujemy więc najpierw dowolną klasę/interfejs, niech to będzie klasa abstrakcyjna:

        abstract class SimpleAbstractClass {
            abstract void run();
        }


    I później w dowolnym miejscu, gdzie legalne jest wyrażenie, deklarujemy klasę i od razu po jej konstruktorze dostarczamy implementację:

        public class AnonymousInnerTest {

            public void test() {
                SimpleAbstractClass simpleAbstractClass = new SimpleAbstractClass() {
                    void run() {
                        // method implementation
                    }
                };
                simpleAbstractClass.run();
            }
        }

    Klasy anonimowe powinny być krótkie (do 10 linijek). W innym wypadku czytelność znacznie ucierpi.
    Klasy anonimowe często się używa w implementacji static factory method (Przykład takiego użycia był w poście nr 20 w metodzie intArrayAsList).
    Przed dodaniem lambd w Javie 8, klasy anonimowe były używane do tworzenia małych obiektów funkcyjnych w locie, jednak lambdy całkowicie je wyparły.

    Przykład takiego użycia:

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New Thread started.");
            }
        });


    I z to samo z wykorzystaniem lambdy:

        Thread thread = new Thread(() -> System.out.println("New Thread started"));


    Chyba nie trzeba tłumaczyć dlaczego lambdy są preferowane.
    Jednak jeśli potrzebujemy użyć this to lambdy się nie sprawdzą, bo do lambdy nie możemy się w żaden sposób odwołać.
    W takim przypadku musimy użyć klasy anonimowej.


Klasy lokalne (Ang. Local Classes)

    Klasy lokalne to specjalny typ klas wewnętrznych - możemy zdefiniować je wewnątrz metody.

    Wygląda to tak:
        public class NewEnclosing {

            void run() {
                class Local {

                    void run() {
                        // method implementation
                    }
                }
                Local local = new Local();
                local.run();
            }

            @Test
            public void test() {
                NewEnclosing newEnclosing = new NewEnclosing();
                newEnclosing.run();
            }
        }

    * Nie mają modyfikatorów dostępu.
    * Mają dostęp do statycznych i niestatycznych elementów klasy, w której się znajdują.
    * Nie mogą definiować elementów jako static.

    Klasy lokalne są najrzadziej wykorzystywanym typem klas.
    Taka klasa może być zadeklorowana wszędzie tam, gdzie może być zadeklarowana zmienna i jej zasięg jest tak sam, jak w przypadku zmiennych.

    Jeśli mielibyśmy kiedyś skorzystać z takiej klasy, to warto zadbać o to, by była krótka, aby nie ucierpiała czytelność kodu.


Podsumowując:
    Mamy 4 klasy wewnętrzne i każda ma swoje miejsce/zastosowanie.
    Jeśli klasa musi być widoczna w więcej niż jednej metodzie lub jest zbyt duża, aby była w metodzie, użyj niestatyczną klasę wewnętrzną.
    Jeśli nie potrzebuje dostępu do instancji klasy, to zadeklaruj ją jako static.
    Jeśli potrzebujesz jednorazowego użycia klasy wewnątrz metody i istnieje już zdefiniowany typ tej klasy - użyj klasy anonimowej.
    W przeciwnym wypadku użyj klasy lokalnej.

*/
public class InnerClasses {
}
