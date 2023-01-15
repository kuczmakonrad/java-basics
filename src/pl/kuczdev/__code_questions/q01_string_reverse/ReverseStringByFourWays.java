package pl.kuczdev.__code_questions.q01_string_reverse;
/*
Question 1 : How to reverse a String in java? Can you write a program without using any java inbuilt methods?
Solution: There are many ways to do it, some of them are:

Using for loop
Using recursion
Using StringBuffer


 */
public class ReverseStringByFourWays {
    // For 3 point method - recursive
    public String recursiveReverse(String orig) {
    if (orig.length() == 1)
        return orig;
    else
        return orig.charAt(orig.length() - 1) +
                recursiveReverse(orig.substring(0, orig.length() - 1));
    }

    public static void main(String[] args) {
        String example1 = "Jakub";

        // 1. Using for loop with char[] table
        char[] letters = example1.toCharArray();
        StringBuilder result = new StringBuilder("");
        for (int i = letters.length-1; i >= 0; i--) {
            result.append(letters[i]);
        }
        System.out.println("First point result: " + result);

        // 2. Using for loop with Strings only
        String reverse = "";
        for (int i = example1.length()-1; i >= 0; i--) {
            reverse = reverse + example1.charAt(i);
        }
        System.out.println("Second point result: " + reverse);

        // 3. Using recursion (recursive)
        ReverseStringByFourWays reverseStringByFourWays = new ReverseStringByFourWays();
        System.out.println("Third point result: " + reverseStringByFourWays.recursiveReverse(example1));

        // 4. Using StringBuffer
        StringBuffer sb = new StringBuffer(example1);
        System.out.println("Four point example: " + sb.reverse());
    }





}
