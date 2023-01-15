package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

public class q8_find_number_of_words {
    public static void main(String[] args) {
        String str = "My name is John";
        System.out.println("How many words in sentence: \nMy name is John");
        System.out.println(countWordsInString(str));
    }
    private static int countWordsInString(String s) {
        if (s == null || s.length() <= 0) return 0;
        String[] table = s.trim().split(" ");
        return table.length;
    }
}
