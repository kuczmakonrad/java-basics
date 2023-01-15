package pl.kuczdev.data_structures.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
There are many ways to iterate over HashMap:
    1. Iterating over HashMap using keyset()
    2. Iterating over HashMap using keyset() with foreach() and lambda expression [java 8]
    3. Iterating over HashMap using foreach()and lambda expression [java 8]
    4. Iterating over HashMap’s entrySet() using iterator
    5. Iterating over HashMap’s entrySet() using foreach() and lambda expression [java 8]
    6. Iterating over HashMap’s entrySet() using foreach loop
 */
public class p05_HashMapIteratingExamples {
    public static void main(String[] args) {
        Map<String,String> userCountryMap = new HashMap<>();
        userCountryMap.put("Anchit", "India");
        userCountryMap.put("Andy", "USA");
        userCountryMap.put("Roy", "Germany");
        userCountryMap.put("Mary", "France");

        System.out.println("=================================================================================================================");
        System.out.println("1. Iterating over HashMap using keyset() with foreach loop");

        for (String user: userCountryMap.keySet()) {
            System.out.println(user + " -> " + userCountryMap.get(user));
        }


        System.out.println("=================================================================================================================");
        System.out.println("2. Iterating over HashMap using keyset() with foreach() and lambda expression [java 8]");

            userCountryMap.keySet().forEach((user) -> System.out.println(user + " -> " + userCountryMap.get(user)));



        System.out.println("=================================================================================================================");
        System.out.println("3. Iterating over HashMap using foreach() and lambda expression [java 8]");

            userCountryMap.forEach((user, country) -> System.out.println(user + " -> " + country));


        System.out.println("=================================================================================================================");
        System.out.println("4. Iterating over HashMap’s entrySet() using iterator");

        Iterator<Map.Entry<String, String>> iterator = userCountryMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " -> " + next.getValue());
        }


        System.out.println("=================================================================================================================");
        System.out.println("5. Iterating over HashMap’s entrySet() using foreach() and lambda expression [java 8]");

        userCountryMap.entrySet().forEach((entry) -> System.out.println(entry.getKey() + " -> " + entry.getValue()));


        System.out.println("=================================================================================================================");
        System.out.println("6. Iterating over HashMap’s entrySet() using foreach loop");

        for (Map.Entry<String,String> e : userCountryMap.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
