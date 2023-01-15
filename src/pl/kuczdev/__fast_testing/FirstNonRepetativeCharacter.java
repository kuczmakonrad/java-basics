package pl.kuczdev.__fast_testing;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepetativeCharacter {
    public static void main(String[] args) {
        String s = "BLABLABLAUUGZGZRTRW";
        firstNonRepetativeCharacter(s);
    }
    private static void firstNonRepetativeCharacter(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        for (Character c: s.toCharArray()) {
            hm.computeIfPresent(c, (character, value) -> value = value +1);
            hm.putIfAbsent(c, 1);
        }

        int min = Integer.MAX_VALUE;
        for (Character c: hm.keySet()) {
            if (hm.get(c) == 1) {
                if (s.indexOf(c) < min) {
                    min = s.indexOf(c);
                }
            }
        }
        System.out.println(min);
        System.out.println("Letter " +  s.charAt(min) + ", on index: " + min);

    }
}
