package pl.kuczdev.__work_questions.prime_numbers.with_streams_example;

import java.util.stream.IntStream;

public class PrimeNumbersInStreams {
    public static String solve(int a, int b) {
        StringBuilder sb = new StringBuilder("2");

        int num = 3;
        while (sb.length() < a+b) {
            if (isPrime(num)) {
                sb.append(num);
            }
            ++num;
        }
        return sb.toString().substring(a,a+b);
    }

    private static boolean isPrime(int a) {
        return IntStream.rangeClosed(2, a/2).noneMatch(i -> a % i == 0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(PrimeNumbersInStreams.solve(2,2));  //doTest(    2,  2, "57");
        System.out.println(PrimeNumbersInStreams.solve(10,3));  //doTest(   10,  3, "192");
        System.out.println(PrimeNumbersInStreams.solve(20,9));  //doTest(   20,  9, "414347535");
        System.out.println(PrimeNumbersInStreams.solve(30,12));  //doTest(   30, 12, "616771737983");
        System.out.println(PrimeNumbersInStreams.solve(40,8));  //doTest(   40,  8, "83899710");
        System.out.println(PrimeNumbersInStreams.solve(50,6));  //doTest(   50,  6, "031071");
        System.out.println(PrimeNumbersInStreams.solve(10000,5));  //doTest(10000,  5, "02192");
        System.out.println(PrimeNumbersInStreams.solve(200000,5));  //doTest(20000,  5, "09334");
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("elapsedTime " + elapsedTime/1000.0);

    }
}