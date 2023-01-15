package pl.kuczdev.__code_questions.q02_string_anagram;

import java.util.Arrays;
/*
Question 2 : Write a java program to check if two Strings are anagram in java?
        Solution: Two string are anagrams if they have same characters but in different order. For example: Angel and Angle are anagrams
        There are few ways to check if Strings are anagrams. Some of them are:

        Using String methods
        Using array.sort
        Check solution at check if two Strings are anagram in java.


*/

// You can simply sort both the Strings using Arrays.sort() method. If both the Strings are equal after Sorting, then these two Strings are anagram of each other.


public class AnagramStringByArraySort {
    public static void main(String[] args) {
        String firstStr = "kamila";
        String secondStr = "alimak";
        System.out.println("Is words " + firstStr + " and " + secondStr + " are anagrams? Answer: " + isThisTwoStringsAnagrams(firstStr, secondStr));
    }

    private static boolean isThisTwoStringsAnagrams(String firstStr, String secondStr) {
        if (firstStr == null || secondStr == null || firstStr.length() != secondStr.length()) return false;
        else {
           String first = sortChars(firstStr);
           String second = sortChars(secondStr);
           return first.equals(second);
        }
    }

    private static String sortChars(String word) {
        char[] wordArray = word.toLowerCase().toCharArray();
        Arrays.sort(wordArray);
        return String.valueOf(wordArray);
    }
}
