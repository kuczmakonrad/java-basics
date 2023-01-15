package pl.kuczdev.__work_questions.static_and_dynamic_binding;
/*
RÓŻNICE MIĘDZY DYNAMICZNYM, A STATYCZNYM WIĄZANIEM:
    1) Wiązanie statyczne w Javie występuje w czasie kompilacji , a wiązanie dynamiczne w czasie wykonywania
    2) Prywatne , finalne i statyczne metody i zmienne używają statycznego wiązania i są wiązane przez kompilator.
       Podczas gdy metody wirtualne są wiązane w czasie wykonywania na podstawie obiektu runtime.
    3) Wiązanie statyczne wykorzystuje informacje Type (klasa w javie)  do wiązania, podczas gdy wiązanie dynamiczne używa obiektu do rozwiązania wiązania.

Czyli wiązanie statyczne uważa za ważniejszą lewą stronę (typ deklarowanej zmiennej), a wiązanie dynamiczne prawą stronę (czyli obiekt new).

Oto przykład statycznego wiązania w javie, który wyjaśni, w jaki sposób przeciążone metody w javie są wiązane w czasie kompilacji przy użyciu informacji o typie.

OUTPUT: W środku metody sort() z parametrem Collection.
W poniższym przykładzie statycznego wiązania w Javie mamy przeciążoną metodę sort(), z których jedna przyjmuje parametr Collection, a druga HashSet.
Wywołaliśmy metodę sort() z HashSet jako obiektem, ale odwołujemy się do typu Collection i kiedy uruchomimy metodę, gdzie Collection jest parametrem,
zostanie wywołany typ, ponieważ został on powiązany w czasie kompilacji na podstawie typu zmiennej (wiązanie statyczne), która była kolekcja.
*/

import java.util.Collection;
import java.util.HashSet;

public class StaticBindingTest {
    public static void main(String[] args) {
        Collection c = new HashSet();
        StaticBindingTest sbt = new StaticBindingTest();
        sbt.sort(c);
    }

    //overloaded method takes Collection argument
    public Collection sort(Collection c) {
        System.out.println("W środku metody sort() z parametrem Collection.");
        return c;
    }

    //another overloaded method which takes HashSet argument which is sub class
    public Collection sort(HashSet hs) {
        System.out.println("W środku metody sort() z parametrem HashSet.");
        return hs;
    }
}
