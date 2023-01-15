package pl.kuczdev.__work_questions.prime_numbers.with_loops_example;

public class PrimeNumbersInLoops {
    public static boolean isPrime(int number) {
        boolean result = true;
        if (number < 2) {
            result = false;
        } else {
            for (int i = 2; i <= number/2; i++) {
                if (number%i == 0) result = false;
            }
        }
        return result;
    }

    public static String solve(int a, int b) {
        int max = a + b;
        StringBuffer sb = new StringBuffer();


        for (int i = 2; i <= Integer.MAX_VALUE; i++) {
            if (PrimeNumbersInLoops.isPrime(i)) {
                sb.append(i);
            }
            if (sb.length() >= max) {
                break;
            }
        }

        return sb.substring(a, max);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(PrimeNumbersInLoops.solve(2,2));  //doTest(    2,  2, "57");
        System.out.println(PrimeNumbersInLoops.solve(10,3));  //doTest(   10,  3, "192");
        System.out.println(PrimeNumbersInLoops.solve(20,9));  //doTest(   20,  9, "414347535");
        System.out.println(PrimeNumbersInLoops.solve(30,12));  //doTest(   30, 12, "616771737983");
        System.out.println(PrimeNumbersInLoops.solve(40,8));  //doTest(   40,  8, "83899710");
        System.out.println(PrimeNumbersInLoops.solve(50,6));  //doTest(   50,  6, "031071");
        System.out.println(PrimeNumbersInLoops.solve(10000,5));  //doTest(10000,  5, "02192");
        System.out.println(PrimeNumbersInLoops.solve(20000,5));  //doTest(20000,  5, "09334");
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("elapsedTime " + elapsedTime/1000.0);
    }
}