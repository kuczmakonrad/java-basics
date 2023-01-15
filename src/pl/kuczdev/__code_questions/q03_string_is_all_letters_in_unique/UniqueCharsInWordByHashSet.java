package pl.kuczdev.__code_questions.q03_string_is_all_letters_in_unique;

import java.util.HashSet;
import java.util.Set;
/*
https://java2blog.com/check-if-string-has-all-unique-characters-in-java/

You can add each character to HashSet.
If HashSet’s add method returns false then it does not have all unique characters.
 */
public class UniqueCharsInWordByHashSet {
    public static void main(String[] args) {
        System.out.println("Is only unique chars in word (ABCDEFGHIJKLMN)?: " + hasAllUniqueChars("ABCDEFGHIJKLMN"));
        System.out.println("Is only unique chars in word (AAAAAAAAAAAAAA)?: " + hasAllUniqueChars("AAAAAAAAAAAAAA"));
        System.out.println("java2blog has all unique chars : "+ hasAllUniqueChars("java2blog"));
        System.out.println("Apple has all unique chars : "+ hasAllUniqueChars("apple"));
        System.out.println("index has all unique chars : "+ hasAllUniqueChars("index"));
        System.out.println("world has all unique chars : "+ hasAllUniqueChars("world"));
        System.out.println("Is only unique chars in word \' 1234567890-=+_)(*&^%$#@!QWERTYUIOP{}][poiuytrewqasdfghjkl;:LKJHGFDSAZXCVBNM<>?/.,mnbvcxz \'?: " + hasAllUniqueChars("1234567890-=+_)(*&^%$#@!QWERTYUIOP{}][poiuytrewqasdfghjkl;:LKJHGFDSAZXCVBNM<>?/.,mnbvcxz"));
        System.out.println("Is only unique chars in word \' 1234567890-=][poiuytrewqasdfghjkl;.,mnbvcxz \' )?: " + hasAllUniqueChars("1234567890-=][poiuytrewqasdfghjkl;.,mnbvcxz"));
    }

    public static boolean hasAllUniqueChars(String word) {
        if (word == null) return false;
        if (word.length() == 1) return true;
        else {
            Set<Character> uniqueCharsSet = new HashSet<>();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                // If Hashset's add method return false,that means it is already present in HashSet
                if (!uniqueCharsSet.add(c)) return false;
            }

            return true;
        }
    }
}