package pl.kuczdev.streams;

import java.util.Optional;

public class OptionalFilter {
    public static void main(String[] args) {
        String arg = "Jakiś tekst";
        //arg = null;
        Optional <String> opt = Optional.ofNullable(arg);

        opt.map(str -> str + " oraz informacje")
                .filter(str -> str.length() > 5)
                .or( () -> Optional.ofNullable("Nowy String") )
                .ifPresent(System.out::println);    // W przypadku arg = jakiś tekst OUTPUT: Jakiś tekst oraz informacje
                                                    // W przypadku arg = null (bez linijki or) OUTPUT: nic się nie wyświetli
                                                    // W przypadku arg = null (z linijką or) OUTPUT: Nowy String

    }
}
