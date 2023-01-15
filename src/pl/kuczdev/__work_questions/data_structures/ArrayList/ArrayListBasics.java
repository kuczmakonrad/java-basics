package pl.kuczdev.__work_questions.data_structures.ArrayList;

import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        System.out.println("ArrayList:");

        for (String str : list) {
            System.out.println(str);
        }
    }
}
