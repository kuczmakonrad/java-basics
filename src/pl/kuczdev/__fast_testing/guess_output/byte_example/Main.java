package pl.kuczdev.__fast_testing.guess_output.byte_example;

public class Main {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        //byte result1 = a + b; - nie możemy tego zrobić (bo byte nie ma znaku dodawania)

        // TYP PROSTY BYTE NIE MA ZNAKU DODAWANIA (+), DLATEGO NIE MOŻEMY DODAWAĆ BYTE'ÓW.
        // DOPÓKI ZMIENNE NIE BĘDĄ FINALNE - TO PODCZAS DODAWANIA KOMPILATOR UZNA, ŻE JEST TO DODAWANIE INTÓW (I ZWRÓCI INTA)
        // MOŻEMY:
        // A) UŻYĆ ZMIENNYCH FINALNYCH
        // Kompiluje się to dobrze z powodu zawężania konwersji i jest to możliwe, jeśli wszystkie operandy są wartościami stałymi w wyrażeniu.
        final byte x = 10;
        final byte y = 20;

        byte result2 = x + y;
        System.out.println(result2);

        // B) RZUTOWAĆ WYNIK
        byte c = 10;
        byte d = 20;
        byte result3 = (byte) (c + d);
        System.out.println(result3);
    }
}
