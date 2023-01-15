package pl.kuczdev.__code_questions.q06_string_find_first_non_repetitive_character;

import java.util.*;
import java.util.Map.Entry;
/*
Get character while looping over String
Put this character in LinkedHashMap with count. If character is already there, increase count by 1.
Get count from LinkedHashMap while iterating. If count is 1,return that character as LinkedHashMap maintains insertion order.
 */

// TU COŚ NIE BANGLA

public class GetFirstNonRepeatingCharacterByLinkedHashMap {
    public static void main(String[] args) {
        System.out.println("First non repeated character for String analogy is : " + getNonRepeatedCharacter("analogy"));
        System.out.println("First non repeated character for String easiest is : " + getNonRepeatedCharacter("easiest"));

        System.out.println("ABCDE: " + getNonRepeatedCharacter("ABCDE"));
        System.out.println("GGDDYY: " + getNonRepeatedCharacter("GGDDYY"));
        System.out.println("ALFA I OMEGA: " + getNonRepeatedCharacter("ALFA I OMEGA"));
        System.out.println("ELOMELO: " + getNonRepeatedCharacter("ELOMELO"));
        System.out.println("AABBCCDE: " + getNonRepeatedCharacter("AABBCCDE"));
    }

    private static Character getNonRepeatedCharacter(String str) {
        Map<Character, Integer> countCharacters = new LinkedHashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            Character c = str.charAt(i);
            if (!countCharacters.containsKey(c)) {
                countCharacters.put(c, 1);
            } else {
                countCharacters.put(c, countCharacters.get(c) + 1);
            }
        }
        // As LinkedHashMap maintains insertion order, first character with count 1 should return first non repeated character
        for (Entry<Character, Integer> e : countCharacters.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();
        }
        return null;
    }
}
