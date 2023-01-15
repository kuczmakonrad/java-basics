package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;
// https://java2blog.com/java-interview-programs-for-freshers/
// Question 1: Check if number is odd or even?
public class q1_number_is_even_or_odd {
    public static void main(String[] args) {
        System.out.println("Is number 2 even: " + isEven(2));
        System.out.println("Is number 5 even: " + isEven(5));
    }

    private static boolean isEven(int number) {
        if (number%2 == 0) return true;
        return false;
    }
}
