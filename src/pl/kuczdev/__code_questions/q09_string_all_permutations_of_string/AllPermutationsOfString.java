package pl.kuczdev.__code_questions.q09_string_all_permutations_of_string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AllPermutationsOfString {
    public static void main(String[] args) {
        Set set = writeAllPermutationsOfString("ABC");
        System.out.println("Permutations of ABC:");
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            String s = (String) iterator.next();
            System.out.println(s);
        }
    }
    private static Set writeAllPermutationsOfString(String s) {
        Set permutationSet = new HashSet();
        if (s.length() == 0) {
            permutationSet.add("");
            return permutationSet;
        }

        char c = s.charAt(0);   // take first char of String
        String rem = s.substring(1);    // remaining string

        Set <String> permutatedSetForRemainingString = writeAllPermutationsOfString(rem);
        for (String permutedString : permutatedSetForRemainingString) {
            for (int j = 0; j <= permutedString.length(); j++) {
                String permutation = insertFirstCharAtDiffPlaces(permutedString,c,j);
                permutationSet.add(permutation);
            }
        }

        return permutationSet;
    }

    public static String insertFirstCharAtDiffPlaces(String permutedString, char firstChar, int index) {
        // Inserting firstCharacter of orig String at difference places based on index
        return permutedString.substring(0,index) + firstChar + permutedString.substring(index);
    }
}
