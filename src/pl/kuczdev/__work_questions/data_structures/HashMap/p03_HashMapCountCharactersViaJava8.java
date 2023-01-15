package pl.kuczdev.__work_questions.data_structures.HashMap;

import java.util.HashMap;
import java.util.Map;

// PROBLEM: You want to find the frequency of each character in String.
public class p03_HashMapCountCharactersViaJava8 {
    public static void main(String[] args) {
        String str = "AAABbCC";
        findFrequencyOfEachCharacterTrivialWay(str);

        System.out.println("\n\n");
        findFrequencyOfEachCharacterJava8Way(str);
    }

    // You might have written the program in a trivial way as below.
    private static void findFrequencyOfEachCharacterTrivialWay(String s) {
        Map<Character,Integer> charactersCounterMap = new HashMap<>();
        char[] charTable = s.toCharArray();
        for (Character c: charTable) {
            if (charactersCounterMap.containsKey(c)) {
                charactersCounterMap.put(c, charactersCounterMap.get(c) + 1);
            } else {
                charactersCounterMap.put(c, 1);
            }
        }

        System.out.println(charactersCounterMap);
    }

    private static void findFrequencyOfEachCharacterJava8Way(String s) {
        Map<Character,Integer> charactersCounterMap = new HashMap<>();
        char[] charTable = s.toCharArray();
        for (Character c: charTable) {
            charactersCounterMap.computeIfPresent(c, (key,value) -> value = value + 1);
            charactersCounterMap.putIfAbsent(c, 1);
        }

        System.out.println(charactersCounterMap);
    }

}
