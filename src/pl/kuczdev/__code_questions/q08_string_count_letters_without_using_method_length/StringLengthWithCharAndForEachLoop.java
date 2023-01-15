package pl.kuczdev.__code_questions.q08_string_count_letters_without_using_method_length;

/*
Convert string to char array using toCharArray method
Iterate over char array and incrementing length variable.
 */
public class StringLengthWithCharAndForEachLoop {
    public static void main(String[] args) {
        String s = "Konrad";
        System.out.println("Ciąg znaków: \'" + s + "\', ma: " + countCharsInStringWithoutMethodLength(s) + " znaków.");
    }

    private static int countCharsInStringWithoutMethodLength(String s) {
        int counter = 0;
        char[] table = s.toCharArray();
        for (char c: table)
            counter++;

        return counter;
    }
}
