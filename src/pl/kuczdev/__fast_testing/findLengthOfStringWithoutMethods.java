package pl.kuczdev.__fast_testing;

public class findLengthOfStringWithoutMethods {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(findLengthStringWithoutAPIMethods(s));
        System.out.println(findLengthStringByExceptionFirst(s));
    }

    private static int findLengthStringWithoutAPIMethods(String s) {
        int counter = 0;
        for (Character c:s.toCharArray()) {
            counter++;
        }
        return counter;
    }

    private static int findLengthStringByExceptionFirst(String s) {
        return s.charAt(s.length());
    }
}
