package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// https://java2blog.com/java-interview-programs-for-freshers/
// Question 2: How to check number is prime or not?
public class q2_how_to_check_is_prime_number {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= 100; i++) {
            if (isNumberPrime(i)) result.append(i + " ");
        }

        System.out.println(result);
    }



    private static boolean isNumberPrime(int number) {
        if(number <= 1) return false;

        for (int i = 2; i <= number/2; i++) {
            if (number%i == 0) return false;
        }

        return true;
    }

}
