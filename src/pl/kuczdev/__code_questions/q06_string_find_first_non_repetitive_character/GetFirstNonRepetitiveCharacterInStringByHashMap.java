package pl.kuczdev.__code_questions.q06_string_find_first_non_repetitive_character;

import java.util.*;
import java.util.stream.Collectors;

public class GetFirstNonRepetitiveCharacterInStringByHashMap {
    public static void main(String[] args) {
        System.out.println("ABCDE: " + getFirstNonRepetitveCharacter("ABCDE"));
        System.out.println("GGDDYY: " + getFirstNonRepetitveCharacter("GGDDYY"));
        System.out.println("ALFA I OMEGA: " + getFirstNonRepetitveCharacter("ALFA I OMEGA"));
        System.out.println("ELOMELO: " + getFirstNonRepetitveCharacter("ELOMELO"));
        System.out.println("AABBCCDE: " + getFirstNonRepetitveCharacter("AABBCCDE"));
        System.out.println("null: " + getFirstNonRepetitveCharacter(null));
    }
    private static String getFirstNonRepetitveCharacter(String s) {
        if (s == null) return "Podałeś nulla w parametrze.";

        Map<Character, Integer> countLettersInStringMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countLettersInStringMap.containsKey(c)) {
                countLettersInStringMap.replace(c, countLettersInStringMap.get(c) + 1);
            } else {
                countLettersInStringMap.put(c, 1);
            }
        }

        List<Character> onlySingleLettersList = new ArrayList<>();
        for (Character c:countLettersInStringMap.keySet()) {
            if (countLettersInStringMap.get(c) == 1) onlySingleLettersList.add(c);
        }

        if (onlySingleLettersList.size() == 1) {
            return "Tylko jedna litera się nie powtarzała wielokrotnie i jest to: " + onlySingleLettersList.get(0);
        } else if (onlySingleLettersList.size() > 1) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (countLettersInStringMap.get(c) == 1) return "Pierwsza litera, która się nie powatarzala wielokrotnie to: " + c;
            }
        } else {
            return "Wszystkie litery powtarzały się w kodzie.";
        }
        return "";
    }

    private static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
