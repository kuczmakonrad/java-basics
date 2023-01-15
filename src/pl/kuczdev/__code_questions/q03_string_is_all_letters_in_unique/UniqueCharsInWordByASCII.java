package pl.kuczdev.__code_questions.q03_string_is_all_letters_in_unique;

/*
https://java2blog.com/check-if-string-has-all-unique-characters-in-java/

It is most efficient of all.
Approach:

Create a boolean array of 26 length
Convert char to uppercase and get its ascii value
Subtract 64 to ascii value to get index between 0 to 25.
If character is not repeated then we should have false in the boolean array
 */
public class UniqueCharsInWordByASCII {
    public static void main(String[] args) {
        System.out.println("Is only unique chars in word (ABCDEFGHIJKLMN)?: " + hasAllUniqueChars("ABCDEFGHIJKLMN"));
        //System.out.println("Is only unique chars in word \' 1234567890-=+_)(*&^%$#@!QWERTYUIOP{}][poiuytrewqasdfghjkl;:LKJHGFDSAZXCVBNM<>?/.,mnbvcxz \'?: " + hasAllUniqueChars("1234567890-=+_)(*&^%$#@!QWERTYUIOP{}][poiuytrewqasdfghjkl;:LKJHGFDSAZXCVBNM<>?/.,mnbvcxz"));
        //System.out.println("Is only unique chars in word \' 1234567890-=][poiuytrewqasdfghjkl;.,mnbvcxz \' )?: " + hasAllUniqueChars("1234567890-=][poiuytrewqasdfghjkl;.,mnbvcxz"));System.out.println("java2blog has all unique chars : "+ hasAllUniqueChars("java2blog"));
        System.out.println("Apple has all unique chars : "+ hasAllUniqueChars("apple"));
        System.out.println("index has all unique chars : "+ hasAllUniqueChars("index"));
        System.out.println("world has all unique chars : "+ hasAllUniqueChars("world"));
    }

    public static boolean hasAllUniqueChars (String word) {
        boolean[] charMap = new boolean[26];

        for(int index=0;index < word.length(); index ++)   {
            // we are substracting char's ascii value to 64, so we get all index
            // from 0 to 25.
            int asciiCode = (int) word.toUpperCase().charAt(index) - 64;

            // If char is not present, it should have false at that index
            if(!charMap[asciiCode])
                charMap[asciiCode] = true;
            else
                return false;
        }

        return true;
    }
}
