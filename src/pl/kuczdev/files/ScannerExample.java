package pl.kuczdev.files;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź ilość liczb do dodania: ");
        int num = scanner.nextInt();

        int sum = 0;

        for (int i = 0; i < num; i++) {
            System.out.println("Wprowadź " + (i + 1) + " liczbę całkowitą do dodania: ");
            sum += scanner.nextInt();
        }

        System.out.println("Suma wynosi: " + sum);
    }
}
