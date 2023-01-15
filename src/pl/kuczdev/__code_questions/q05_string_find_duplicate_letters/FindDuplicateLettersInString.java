package pl.kuczdev.__code_questions.q05_string_find_duplicate_letters;

import java.util.HashMap;
import java.util.Map;

// https://java2blog.com/find-duplicate-characters-in-string-java/
//Create a HashMap and character of String will be inserted as key and its count as value.
//If Hashamap already contains char,increase its count by 1, else put char in HashMap
//If value of Char is more than 1, that means it is duplicate character in that String

public class FindDuplicateLettersInString {
    public static void main(String[] args) {
        System.out.println("Which letters are duplicated in word: Kamila");
        findDuplicateLetters("Kamila");
        System.out.println("Which letters are duplicated in word: Brabrabrak");
        findDuplicateLetters("Brabrabrak");
    }

    public static void findDuplicateLetters(String s) {
        //s = s.toLowerCase();
        Map <Character, Integer> letterCounter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letterCounter.containsKey(c)) {
                letterCounter.replace(c, letterCounter.get(c) + 1);
            } else {
                letterCounter.put(c, 1);
            }
        }

        for (Character c : letterCounter.keySet()) {
            if (letterCounter.get(c) > 1) {
                System.out.println("ZDUPLIKOWANA LITERA = " + c + ", W ILOSCI = " + letterCounter.get(c));
            }
        }

    }
}
