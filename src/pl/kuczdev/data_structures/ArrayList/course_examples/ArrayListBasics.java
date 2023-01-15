package pl.kuczdev.data_structures.ArrayList.course_examples;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList basicArray = new ArrayList();
        basicArray.add(new String("Testowy String"));
        basicArray.add("Test");

        String strEl = (String) basicArray.get(0);
        System.out.println(strEl);


        ArrayList <String> arrStr = new ArrayList<>();
        arrStr.add("Kasia");
        arrStr.add("Adam");
        arrStr.add("Emil");
        arrStr.add("Michał");

        arrStr.remove(1);   // usuwa pod danym indeksem - remove Adam
        arrStr.add("Olek");

        for (String s: arrStr) {
            System.out.println(s);
        }



        System.out.println("--------------DODAWANIE, PODMIANA");
        arrStr.add(0, "Zuza");          // dodaje pod danym indeksem
        arrStr.set(1, "Kordian");                   // podmienia pod danym indeksem

        for (String s: arrStr) {
            System.out.println(s);
        }

        System.out.println("-------------SORTOWANIE");

        Collections.sort(arrStr);
        for (String s: arrStr) {
            System.out.println(s);
        }


    }
}
