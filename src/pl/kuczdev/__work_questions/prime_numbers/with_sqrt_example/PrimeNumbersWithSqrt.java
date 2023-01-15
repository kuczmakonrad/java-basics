package pl.kuczdev.__work_questions.prime_numbers.with_sqrt_example;

import pl.kuczdev.__work_questions.prime_numbers.with_streams_example.PrimeNumbersInStreams;

public class PrimeNumbersWithSqrt {
    private static boolean isNumberPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%2==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isNumberPrime(13));
    }
}
