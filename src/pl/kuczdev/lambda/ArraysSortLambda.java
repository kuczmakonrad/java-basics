package pl.kuczdev.lambda;

import java.util.Arrays;

public class ArraysSortLambda {
    public static void main(String[] args) {

        String arrStr[] = {"Ford", "BMW", "Mercedes", "Dogde"};


        Arrays.sort(arrStr, (s1,  s2) -> s1.length() - s2.length());
        //Arrays.sort(arrStr, (String s1, String s2) -> {return s1.length() - s2.length()});

        for (String s: arrStr) {
            System.out.println(s);
        }
    }
}
