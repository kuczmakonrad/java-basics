package pl.kuczdev.__code_questions.q07_string_find_all_substrings;

public class FindAllSubstrings {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println("For word: " + s + ", all substrings are below:");
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                System.out.println("\t" + s.substring(i,j));
            }
        }
    }
}
