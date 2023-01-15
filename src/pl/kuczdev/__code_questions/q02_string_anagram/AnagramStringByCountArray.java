package pl.kuczdev.__code_questions.q02_string_anagram;
/*
Here is another approach to find if two Strings are anagrams.

Pass two Strings str1 and str2 to method isAnagram()
If length of str1 and str2 are not same, then they are not anagrams
Create an array named count of 256 length
Iterate over first string str1
In each iteration, we increment count of first String str1 and decrement the count of second String str2
If count of any character is not 0 at the end, it means two Strings are not anagrams
This approach has time complexity of O(n), but it requires extra space for count Array.
 */

public class AnagramStringByCountArray {
    public static void main(String[] args) {
        boolean isAnagram = isAnagram("Angle","Angle");
        System.out.println("Are Angle and Angel anangrams: "+isAnagram);
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length() || s1 == null || s2 == null) return false;

        int[] count = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}
