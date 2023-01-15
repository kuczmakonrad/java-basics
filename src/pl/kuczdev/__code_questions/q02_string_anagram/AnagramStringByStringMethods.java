package pl.kuczdev.__code_questions.q02_string_anagram;
/*
Question 2 : Write a java program to check if two Strings are anagram in java?
        Solution: Two string are anagrams if they have same characters but in different order. For example: Angel and Angle are anagrams
        There are few ways to check if Strings are anagrams. Some of them are:

        Using String methods
        Using array.sort
        Check solution at check if two Strings are anagram in java.

Algorithm:
    Pass two Strings word and anagram to method called isAnagramUsingStringMethods()
    Iterate over first String word and get char c from it using charAt() method
    If index of char c is -1 in second String anagram, then two strings are not anagrams
    If index of char c is not equal to -1 in second String anagram, then remove the character from the String anagram.
    If you get empty String in the end, then two Strings are anagrams of each other.
*/

public class AnagramStringByStringMethods {
    public static void main(String[] args) {
        String word = "java2blog";
        String anagram = "aj2vabgol";

        System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagramUsingStringMethods(word, anagram));
    }

    public static boolean isAnagramUsingStringMethods(String word, String anagram) {
        if (word.length() != anagram.length())
            return false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = anagram.indexOf(c);
            // If index of any character is -1, then two strings are not anagrams
            // If index of character is not equal to -1, then remove the character from the String
            if (index != -1) {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
            } else
                return false;
        }
        return anagram.isEmpty();
    }

}