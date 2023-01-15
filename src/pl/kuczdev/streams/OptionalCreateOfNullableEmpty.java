package pl.kuczdev.streams;

import java.util.Optional;

public class OptionalCreateOfNullableEmpty {
    public static void main(String[] args) {
        // Optional metodą of() - nie pozwala na nulla w wartości
        Optional<String> opt1 = Optional.of("TestTT");
        System.out.println(opt1.get());

        //Optional <String> opt2 = Optional.of(null);         // OUTPUT: Exception in thread "main" java.lang.NullPointerException (ponieważ metoda of nie pozwala na null)

        // Optional metodą ofNullable() - pozwala na nulla w wartości
        Optional<String> opt3 = Optional.ofNullable("Test");
        System.out.println("opt3: " + opt3.get());            // OUTPUT: opt3: Test

        Optional<String> opt4 = Optional.ofNullable(null);
        System.out.println("opt4: " + opt4);                  // OUTPUT: opt4: Optional.empty
        //System.out.println("opt4: " + opt4.get());          // OUTPUT: Exception in thread "main" java.lang.NullPointerException (ponieważ na nullu wywołujemy metodę)

        // Optional metodą empty() - tworzy pusty Optional
        Optional<String> opt5 = Optional.empty();
        System.out.println("opt5: " + opt5);                  // OUTPUT: opt5: Optional.empty
        //System.out.println("opt5: " + opt5.get());          // OUTPUT: Exception in thread "main" java.lang.NullPointerException (ponieważ na nullu wywołujemy metodę)

        Integer integer = Integer.valueOf(10);
        Optional <Integer> optInt = Optional.ofNullable(integer);

        if (optInt.isPresent()) {                                           // isPresent() - Sprawdza czy Optional jest niepusty
            System.out.println("optInt.get(): " + optInt.get());            // OUTPUT: optInt.get(): 10
        } else {
            System.out.println("optInt jest nullem!");
        }

        optInt.ifPresent(s -> System.out.println(s));   // ifPresent() - jeśli Optional jest niepusty to wywoła wskazaną lambdę.
        optInt.ifPresent(System.out::println);   // Za pomocą referencji do metody
        // OUTPUT: 10 i 10
    }
}