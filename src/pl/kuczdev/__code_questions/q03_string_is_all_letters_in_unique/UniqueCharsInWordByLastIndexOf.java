package pl.kuczdev.__code_questions.q03_string_is_all_letters_in_unique;

//https://java2blog.com/check-if-string-has-all-unique-characters-in-java/
// If indexOf and lastIndexOf returns same value for the character, then it is not repeated in that String.

public class UniqueCharsInWordByLastIndexOf {
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
    private static boolean hasAllUniqueChars(String word) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // If indexOf and lastIndexOf returns same value for the character, then it is not repeated in that String.
            if (word.indexOf(c) != word.lastIndexOf(c)) return false;
        }
        return true;
    }
}
