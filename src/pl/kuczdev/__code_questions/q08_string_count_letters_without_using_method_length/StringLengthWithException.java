package pl.kuczdev.__code_questions.q08_string_count_letters_without_using_method_length;

/*
You must be wondering how we can use StringIndexOutOfBoundsException to find length of String without using length() method. Please refer below logic:

Initialize i with 0 and iterate over String without specifying any condition. So it will be always true.
Once value of i will be more than length of String, it will throw StringIndexOutOfBoundsException exception.
We will catch the exception and return i after coming out of catch block.
 */

public class StringLengthWithException {
    public static void main(String[] args) {
        String s = "Konrad Kuczma";
        System.out.println("Ciąg znaków: \'" + s + "\', ma: " + countCharsInStringWithoutMethodLength(s) + " znaków.");
    }

    private static int countCharsInStringWithoutMethodLength(String s) {
        int i = 0;
        try {
            for (i=0; ;i++) {
                s.charAt(i);
            }
        } catch (Exception e) {

        }

        return i;
    }
}
