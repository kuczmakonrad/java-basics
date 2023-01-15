package pl.kuczdev.streams;

import java.util.Optional;

public class OptionalMapOrElse {
    public static void main(String[] args) {
        Integer integer = Integer.valueOf(20);
        // integer = null;

        Optional<Integer> optional1 = Optional.ofNullable(integer);
        Optional<Integer> optional2 = optional1.map(i -> i * 3);

        System.out.println(optional2);                       // OUTPUT: Gdy integer = 20 to Optional[60];    Gdy integer = null to Optional.empty
        System.out.println(optional2.get());                 // OUTPUT: Gdy integer = 20 to 60;     Gdy integer = null to ERROR: NoSuchElementException
        System.out.println(optional2.orElse(1000));    // OUTPUT: Gdy integer = 20 to 60;     Gdy integer = null to 1000


        Integer integer2 = Integer.valueOf(100);
        integer2 = null;
        Optional <Integer> optInt = Optional.ofNullable(integer2);

        optInt.map(i -> i * 2)
                .map(i -> i + 50)
                .map(i -> i / 2)
                .ifPresent(System.out::println);        // OUTPUT: Gdy integer = 100 to 125; Gdy integer = null to nie wykona się SOUT (nic się nie wyświetli)
    }
}
