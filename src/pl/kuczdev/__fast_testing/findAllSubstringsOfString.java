package pl.kuczdev.__fast_testing;

import java.util.HashSet;
import java.util.Set;

public class findAllSubstringsOfString {
    public static void main(String[] args) {
        String s = "abb";
        getAllSubstringsOfString(s);
    }

    private static void getAllSubstringsOfString(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i,j));
            }
        }

        System.out.println(set);
    }
}
