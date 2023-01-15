package pl.kuczdev.__fast_testing;

import java.util.HashSet;
import java.util.Set;

public class PrintAllPermutationsOfString {
    public static void main(String[] args) {
        String s = "abb";

        printAllPermutationsOfString(s);
    }

    private static void printAllPermutationsOfString(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i,j));
            }
        }
        System.out.println(set);
    }

    public static Set permutationOfString(String str){
        Set permutationSet = new HashSet();

        if (str.length() == 0) {
            permutationSet.add("");
            return permutationSet;
        }

        // take out first character of String
        char c = str.charAt(0);
        // Remaining String
        String rem = str.substring(1);

        Set <String> permutatedSetForRemainingString = permutationOfString(rem);
        for (String permutedString: permutatedSetForRemainingString) {
            for (int j = 0; j <= permutedString.length(); j++) {
                String permutation=insertFirstCharAtDiffPlaces(permutedString,c,j);
                permutationSet.add(permutation);
            }

        }
        return permutationSet;

    }
    public static String insertFirstCharAtDiffPlaces(String perm,char firstChar,int index) {
        // Inserting firstCharacter of orig String at difference places based on index
        return perm.substring(0,index)+firstChar+perm.substring(index);
    }
}
