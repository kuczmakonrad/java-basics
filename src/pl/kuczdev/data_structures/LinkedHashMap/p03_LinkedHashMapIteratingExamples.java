package pl.kuczdev.data_structures.LinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
There are many ways to iterate over LinkedHashMap

Iterating over LinkedHashMap using keyset()
Iterating over LinkedHashMap using keyset() with foreach() and lambda expression( java 8)
Iterating over LinkedHashMap using foreach()and lambda expression (java 8)
Iterating over LinkedHashMap’s entrySet() using iterator
Iterating over LinkedHashMap’s entrySet() using foreach() and lambda expression [java 8]
Iterating over LinkedHashMap’s entrySet() using foreach loop
 */
public class p03_LinkedHashMapIteratingExamples {
    public static void main(String[] args) {
        Map<String, Long> countryPopulationMap = new LinkedHashMap<>();

        // Putting key-values pairs in LinkedHashMap
        countryPopulationMap.put("India",13000L);
        countryPopulationMap.put("China", 15000L);
        countryPopulationMap.put("Germany", 9000L);
        countryPopulationMap.put("France",7000L);

        System.out.println("=========================================================");
        System.out.println("Iterating over LinkedHashMap using keyset() with foreach loop:");
        for (String user:countryPopulationMap.keySet()) {
            System.out.println(user + " --> " + countryPopulationMap.get(user));
        }

        System.out.println("=========================================================");
        System.out.println("Iterating over LinkedHashMap keyset() with foreach and lambda:");
        countryPopulationMap.keySet().forEach((user) -> {
                    System.out.println(user + " --> " + countryPopulationMap.get(user));
                }
        );

        System.out.println("=========================================================");
        System.out.println("Iterating over LinkedHashMap with foreach and lambda:");
        countryPopulationMap.forEach((country,population) -> {
                    System.out.println(country + " --> " + population);
                }
        );

        System.out.println("=========================================================");
        System.out.println("Iterating over LinkedHashMap entrySet with iterator");
        Iterator<Map.Entry<String, Long>> iterator = countryPopulationMap.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String, Long> next = iterator.next();
            System.out.println(next.getKey() + " --> " + next.getValue());
        }

        System.out.println("=========================================================");
        System.out.println("Iterating over LinkedHashMap's entrySet with foreach and lambda");
        countryPopulationMap.entrySet().forEach((entry) -> {
                    System.out.println(entry.getKey() + " --> " + entry.getValue());
                }
        );

        System.out.println("=========================================================");
        System.out.println("Iterating over LinkedHashMap's entrySet with foreach loop");
        for(Map.Entry<String, Long> entry:countryPopulationMap.entrySet())
        {
            System.out.println(entry.getKey()+" --> "+entry.getValue());
        }
    }
}
