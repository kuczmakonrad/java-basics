package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

public class q9_factorial_of_number {
    public static void main(String[] args) {
        System.out.println("Silnia z 3 = " + countFactorial(3));
        System.out.println("Silnia z 5 = " + countFactorial(5));
        System.out.println("Silnia z 10 = " +  countFactorial(10));
    }

    private static int countFactorial(int number) {
        if (number <= 0) return 0;

        int result = 1;

        for (int i = number; i > 0; i--) {
           result *= i;
        }

        return result;
    }
}
