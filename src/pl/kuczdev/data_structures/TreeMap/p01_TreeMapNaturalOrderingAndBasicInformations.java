package pl.kuczdev.data_structures.TreeMap;

import java.util.TreeMap;

/*
TreeMap class implements Map similar to HashMap.

Some important points about TreeMap:
    1. TreeMap implements Map interface and extends HashMap class.
    2. TreeMap is implemented using Red black tree based NavigableMap.
    3. TreeMap is ordered collection and store its elements in natural ordering of keys..
    4. Key which you would like to put in TreeMap must implement Comaparable interface or you can use Comparator for custom sorting.

OUTPUT:
        -----------------------------
        Iterating TreeMap Using keySet() and for each loop
        Country:France and  Capital:Paris
        Country:India and  Capital:Delhi
        Country:Japan and  Capital:Tokyo
        Country:Russia and  Capital:Moscow
        -----------------------------
    As you can see, it is sorted in ascending order of Key(Country)

 */
public class p01_TreeMapNaturalOrderingAndBasicInformations {
    public static void main(String[] args) {
        TreeMap<String, String> countryCapitalTreeMap = new TreeMap<>();
        countryCapitalTreeMap.put("India","Delhi");
        countryCapitalTreeMap.put("Japan","Tokyo");
        countryCapitalTreeMap.put("France","Paris");
        countryCapitalTreeMap.put("Russia","Moscow");

        System.out.println("--------------------------------------------------");
        System.out.println("Iterating TreeMap using .keySet() and forEach loop:");
        for (String country: countryCapitalTreeMap.keySet()) {
            System.out.println("Country: " + country + ", Capital: " + countryCapitalTreeMap.get(country));
        }
        System.out.println("--------------------------------------------------");
    }

}
