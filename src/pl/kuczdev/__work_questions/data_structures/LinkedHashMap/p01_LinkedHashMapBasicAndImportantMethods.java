package pl.kuczdev.__work_questions.data_structures.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/*
LinkedHashMap is a Hashtable and linked list-based implementation of Map interface, with predictable insertion order.
It maintains double linked list of all its entries, that’s how it differs from HashMap.

Java LinkedHashMap class has five constructors:
    public LinkedHashMap():
        This is the default constructor and used mostly. It creates an empty LinkedHashMap with default initial capacity of 16 and load factor 0.75.

    public LinkedHashMap(int initialCapacity):
        This constructor is used to specify the initial capacity of LinkedHashMap and default load factor 0.75.

    public LinkedHashMap(int initialCapacity,float loadFactor):
        This constructor is used to specify initial capacity of the LinkedHashMap and load factor.
        In most of the scenarios, you should avoid using this constructor unless you are sure about this as load factor 0.75 provides a good tradeoff
        between time and space.

    public LinkedHashMap(Map<? extends K,? extends V> m):
        This constructor is used when you want to create LinkedHashMap from some other Map such as TreeMap or HashMap.

    public LinkedHashMap(int initialCapacity,float loadFactor,boolean accessOrder):
        This constructor is used to specify initial capacity, load factor and access order of HashMap.
        If we pass access order as true, then it will list entries based on access order.



Important methods:
    .remove(Object key) - It removes key from LinkedHashMap
    .remove(Object key, Object value) - It removes key if value is same as passed parameter value.
    .get(): Retrieve value from the LinkedHashMap
    .put(): Put value into the LinkedHashMap
    .isEmpty: Check if LinkedHashMap is empty.
    .containsKey(): Check if key present is LinkedHashMap
    .containsValue(): Check if value exists in LinkedHashMap
    .size(): Check size of the LinkedHashMap
    .clear(): To remove all elements from LinkedHashMap
    .clone(): It creates shallow copy of LinkedHashMap.


After Java 7, you can use diamond operator(<>) to initialize Map.
    You can change:
        Map<Integer, String> studentMap = new LinkedHashMap<Integer, String>();
    to:
        Map<Integer, String> studentMap = new LinkedHashMap<>();
 */
public class p01_LinkedHashMapBasicAndImportantMethods {
    public static void main(String[] args) {
        Map<String, Integer> travelFareMap = new LinkedHashMap<String, Integer>();
        // Putting key-values pairs in LinkedHashMap
        travelFareMap.put("Bus", 120);
        travelFareMap.put("Car", 2200);
        travelFareMap.put("Rail", 680);
        travelFareMap.put("Flight", 4000);

        // As you can see, all the entries are printed in insertion order as expected.
        System.out.println("1. " + travelFareMap);      // OUTPUT: 1. {Bus=120, Car=2200, Rail=680, Flight=4000}

        // What if you want to add entries only if it is not already present in LinkedHashMap?
        //You can use putIfAbsent() the method in this scenario.
        travelFareMap.putIfAbsent("Bike", 500);    // this will be added
        travelFareMap.putIfAbsent("Bike", 500);    // this not, because key existing
        System.out.println("2. " + travelFareMap);       // OUTPUT: {Bus=120, Car=2200, Rail=680, Flight=4000, Bike=500}

        // Remove car key
        Integer fareCar = travelFareMap.remove("Car");
        System.out.println("===============================");
        System.out.println("Vehicle Car with fare " + fareCar + " removed from HashMap");
        System.out.println(travelFareMap);
        System.out.println("================================");

        // Remove Rail if fate is 800
        boolean isCarRemoved = travelFareMap.remove("Rail",800);
        // Rail key won't be removed as associated value is 680
        System.out.println("Did car removed from LinkedHashMap: "+isCarRemoved);
        System.out.println(travelFareMap);
        System.out.println("===============================");

        // Remove Flight if fare is 4000
        boolean isFlightRemoved = travelFareMap.remove("Flight",4000);
        // flight key will be removed as associated value is 4000
        System.out.println("Did Flight removed from LinkedHashMap: "+isFlightRemoved);
        System.out.println(travelFareMap);
        System.out.println("===============================");


        System.out.println(travelFareMap);
        //check size of map
        System.out.println("size of travelFareMap: "+travelFareMap.size());

        // get value from LinkedHashMap
        System.out.println("Bus department fare: " + travelFareMap.get("Bus"));
        // value will be null as we don't have key as "SuperCar"
        System.out.println("SuperCar department: " + travelFareMap.get("SuperCar"));

        if(travelFareMap.containsKey("Bus")) {
            System.out.println("travelFareMap has Bus as key");
        }

        if(travelFareMap.containsValue(4000)) {
            System.out.println("travelFareMap has 4000 as value");
        }

        // Removing all entries from Map
        travelFareMap.clear();
        System.out.println(travelFareMap);
    }

}
