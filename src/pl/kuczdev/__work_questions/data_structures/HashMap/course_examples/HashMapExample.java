package pl.kuczdev.__work_questions.data_structures.HashMap.course_examples;

import java.util.HashMap;
import java.util.Map;

// nie przyjmują duplikatów jako kluczy (nadpisze wartość)
// przyjmuje null jako klucz, null jako wartość
public class HashMapExample {
    public static void main(String[] args) {
        Map<String, String> countriesAndCapitalsMap = new HashMap<>();

        // 1. Dodanie kilku rekordów do hashmapy za pomocą metody put.
        countriesAndCapitalsMap.put("Poland", "Warsaw");
        countriesAndCapitalsMap.put("Germany", "Berlin");
        countriesAndCapitalsMap.put("United Kingdom", "London");

        // 2. Wyświetlam wartość klucza Poland (czyli stolicę), następnie dodaję ponownie wpis z takim samym kluczem, lecz inną stolicą i wyświetlam ponownie.
        // Jak widać Hashmapa przy podaniu takiego samego klucza nadpisała stolicę, co oznacza, że HashMapa nie przyjmuje duplikatów.
        System.out.println("2. --------------------------");
        System.out.println(countriesAndCapitalsMap.get("Poland"));
        countriesAndCapitalsMap.put("Poland", "Cracow");
        System.out.println(countriesAndCapitalsMap.get("Poland"));

        // 3. Dlatego też twórcy Javy wprowadzili metodę putIfAbsent(klucz, wartość), która doda wartość do mapy, jeżeli taki klucz jeszcze nie istnieje w naszej mapie.
        // Pozwala to na to, żeby kontrolować to, żeby nie nadpisać istniejących już kluczy w kolekcji.
        // Dlatego tym razem nie nadpisała się stolica i dalej jest nią Cracow, bo zmieniliśmy to w 1 punckie.
        System.out.println("3. --------------------------");
        countriesAndCapitalsMap.putIfAbsent("Poland", "Notthingham");
        System.out.println(countriesAndCapitalsMap.get("Poland"));

        // 4. Jeżeli spróbujemy pobrać wartość klucza, który nie istnieje w mapie otrzymamy nulla.
        System.out.println("4. --------------------------");
        System.out.println(countriesAndCapitalsMap.get("Italy"));

        // 5. Jeżeli nie chcemy otrzymać nulla możemy zawsze skorzystać z metody .getOrDefault(Key, Default_value), która zwróci nam wskazaną przez nam rzecz w przypadku nulla
        System.out.println("5. --------------------------");
        System.out.println(countriesAndCapitalsMap.getOrDefault("Poland", "Nie znaleziono takiego klucza w hashMapie."));

        // 6. Podobnie jak ArrayLista - HashMapa posiada metody containsKey()/containsValue() - sprawdzające czy hashmapa zawiera wskazany klucz lub wartość.
        System.out.println("6. --------------------------");
        System.out.println("Czy istnieje klucz Italy w kolekcji? " + countriesAndCapitalsMap.containsKey("Italy"));
        System.out.println("Czy istnieje klucz Poland w kolekcji? " + countriesAndCapitalsMap.containsKey("Poland"));
        System.out.println("Czy istnieje wartość Oslo w kolekcji? " + countriesAndCapitalsMap.containsValue("Oslo"));
        System.out.println("Czy istnieje wartość Paris w kolekcji? " + countriesAndCapitalsMap.containsValue("Paris"));

        // 7. Istnieje możliwość wyświetlenia wszystkich kluczy (metoda keySet) tak jak wszystkich wartości z hashMapy (metoda values).
        System.out.println("7. --------------------------");
        System.out.println("Keys:");
        //countriesAndCapitalsMap.keySet().forEach(System.out::println);
        countriesAndCapitalsMap.keySet().forEach(s -> System.out.print(s + ", "));
        System.out.print("\n");

        System.out.println("Values:");
        //countriesAndCapitalsMap.values().forEach(System.out::println);
        countriesAndCapitalsMap.values().forEach(s -> System.out.print(s + ", "));
        System.out.print("\n");

        // 8. Mamy również metodę replace, w której możemy zmienić wartość pod danym kluczem
        System.out.println("8. --------------------------");
        countriesAndCapitalsMap.replace("Poland", "Warsaw");        // tu zmieni wartość spowrotem na Warsaw
        countriesAndCapitalsMap.replace("Denmark", "Copenhaga");         // tu nie zmieni nic, bo nie ma takiego klucza
        countriesAndCapitalsMap.values().forEach(System.out::println);

        // 9. Tak samo jak w Listach - możemy do jednej hashmapy dodać wpisy z innej hashmapy (jeżeli zgadzają się typy)
        System.out.println("9. --------------------------");
        Map<String, String> asianCountries = new HashMap<>();
        asianCountries.put("Russia", "Moscow");
        asianCountries.put("Japan", "Tokyo");
        asianCountries.put("Korea", "Seul");

        countriesAndCapitalsMap.putAll(asianCountries);
        countriesAndCapitalsMap.keySet().forEach(System.out::println);
        System.out.println();
        countriesAndCapitalsMap.values().forEach(System.out::println);

        // 10. Mamy jeszcze takie metody jak isEmpty(), size(), clear() - które sprawdzają czy mapa jest pusta, rozmiar mapy, czyszczą mapę.
        System.out.println("10. --------------------------");
        System.out.println(countriesAndCapitalsMap.isEmpty());
        System.out.println(countriesAndCapitalsMap.size());
        countriesAndCapitalsMap.clear();
        System.out.println(countriesAndCapitalsMap.isEmpty());
        System.out.println(countriesAndCapitalsMap.size());
// Zawsze pamiętaj, że w HashTables (czyli też hashmapach) jeżeli chcesz użyć obiektu jako klucz to musisz nadpisać equals i hashcode, bo hashmapy działają KUBEŁKOWO!!
    }
}
