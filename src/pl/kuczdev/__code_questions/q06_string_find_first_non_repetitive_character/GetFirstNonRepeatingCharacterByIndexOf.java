package pl.kuczdev.__code_questions.q06_string_find_first_non_repetitive_character;

//Iterate through each character of string.
//If lastIndexOf and indexOf return same value, then it is first non repeating character in the String.

public class GetFirstNonRepeatingCharacterByIndexOf {
    public static void main(String[] args)
    {
        System.out.println("First non repeated character for String analogy is : "+getNonRepeatedCharacter("analogy"));
        System.out.println("First non repeated character for String easiest is : "+getNonRepeatedCharacter("easiest"));
        System.out.println("ABCDE: " + getNonRepeatedCharacter("ABCDE"));
        System.out.println("GGDDYY: " + getNonRepeatedCharacter("GGDDYY"));
        System.out.println("ALFA I OMEGA: " + getNonRepeatedCharacter("ALFA I OMEGA"));
        System.out.println("ELOMELO: " + getNonRepeatedCharacter("ELOMELO"));
        System.out.println("AABBCCDE: " + getNonRepeatedCharacter("AABBCCDE"));
    }
    private static Character getNonRepeatedCharacter(String str) {
        char arr[] = str.toCharArray();
        for (int i=0; i<str.length();i++) {
            if (str.lastIndexOf(arr[i]) == str.indexOf(arr[i]))
                return arr[i];
        }
        return null;
    }
}
