package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class q7_find_duplicate_characters {
    public static void main(String[] args) {
        String str = "AAABCDEEE";
        System.out.println("Duplicate characters in word: \"" + str + "\":");
        findDuplicateCharactersInString(str);
    }

    private static void findDuplicateCharactersInString(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (Character c: str.toCharArray()) {
            hm.computeIfPresent(c, (character, value) -> value=value+1);
            hm.putIfAbsent(c, 1);
        }

        for (Map.Entry<Character ,Integer> m: hm.entrySet()) {
            if (m.getValue() > 1) {
                System.out.println("Letter: " + m.getKey() + ", is repeated: " + m.getValue() + " time/s.");
            }
        }
    }
}
