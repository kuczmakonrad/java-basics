package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

public class q4_check_string_is_palindrone {
    public static void main(String[] args) {
        String str = "kajak";
        System.out.println("Is string: " + str + " palindrone: " + firstWayCheckIsStringPalindrone(str));
        System.out.println("Is string: " + str + " palindrone: " + secondWayCheckIsStringPalindrone(str));
    }

    private static boolean firstWayCheckIsStringPalindrone(String str) {
        if (str.length() <= 0 || str ==  null) return false;

        StringBuilder reversedString = new StringBuilder(str).reverse();
        return reversedString.toString().equals(str);
    }

    private static boolean secondWayCheckIsStringPalindrone(String str) {
        str = str.toLowerCase();
        String reversedString = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reversedString += Character.toString(str.charAt(i));
        }
        return reversedString.equals(str);
    }
}