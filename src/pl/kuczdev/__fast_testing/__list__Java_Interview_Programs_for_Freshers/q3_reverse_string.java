package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

public class q3_reverse_string {
    public static void main(String[] args) {
        String str = "Happy";
        System.out.println("Reversing string: " + str + " by first method: " + firstWayReverseString(str));
        System.out.println("Reversing string: " + str + " by second method: " + secondWayReverseString(str));
        System.out.println("Reversing string: " + str + " by third method: " + thirdWayReverseString(str));
    }
    //method with using StringBuilder
    // if s.length() <= 0 and string is null it will return String else will return reversed String
    private static String firstWayReverseString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        } else {
            return new StringBuilder(s).reverse().toString();
        }
    }

    // method without using StringBuilder
    // if s.length() <= 0 and string is null it will return String else will return reversed String
    private static String secondWayReverseString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        } else {
            String result = "";
            char[] charArray = s.toCharArray();
            for (int i = charArray.length-1; i >= 0; i--) {
                result += charArray[i];
            }
            return result;
        }
    }

    // another method without using StringBuilder
    // if s.length() <= 0 and string is null it will return String else will return reversed String
    private static String thirdWayReverseString(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        } else {
            String result = "";
            for (int i = s.length()-1; i >= 0; i--) {
                result += s.charAt(i);
            }
            return result;
        }
    }
}