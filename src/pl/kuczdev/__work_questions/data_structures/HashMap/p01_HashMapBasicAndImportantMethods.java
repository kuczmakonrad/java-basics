package pl.kuczdev.__work_questions.data_structures.HashMap;

import java.util.HashMap;
import java.util.Map;

/*
HashMap is hash table based implementation of Map interface.
It stores entry in key-value pairs. It maps keys to values. It is one of the most used Collection.
    1. HashMap implements Map an interface that maps a key to value.
    2. It is not synchronized and is not thread-safe.
    3. Duplicate keys are not allowed
    4. One null key and multiple null values are allowed
    5. It is the unordered collection and does not give a guarantee for any specific order of elements.

Java HashMap class has four constructors
    public HashMap():
        This is the default constructor and used mostly. It creates an empty HashMap with default initial capacity of 16 and load factor 0.75.

    public HashMap(int initialCapacity):
        This constructor is used to specify the initial capacity of HashMap and default load factor 0.75.

    public HashMap(int initialCapacity,float loadFactor):
        This constructor is used to specify initial capacity of the HashMap and load factor. In most of the scenarios,
        you should avoid using this constructor unless you are sure about this as load factor 0.75 provides a good tradeoff between time and space.

    public HashMap(Map<? extends K,? extends V> m):
        This constructor is used when you want to create HashMap from some other Map such as TreeMap or LinkedHashMap.

 */
public class p01_HashMapBasicAndImportantMethods {
    public static void main(String[] args) {
        HashMap<String, Integer> vehicleMaxSpeedMap = new HashMap<String, Integer>();

        // --------------------------------------------------------------------------------
        // Method put - Putting key-values pairs in HashMap

        vehicleMaxSpeedMap.put("Bike", 120);
        vehicleMaxSpeedMap.put("Car", 220);
        vehicleMaxSpeedMap.put("Truck", 160);
        vehicleMaxSpeedMap.put("Activa", 140);

        // What if you want to add entries only if it is not already present in HashMap?
        // You can use putIfAbsent() the method in this scenario.

        System.out.println(vehicleMaxSpeedMap);    // OUTPUT = {Car=220, Activa=140, Truck=160, Bike=120}

        // --------------------------------------------------------------------------------
        // Method remove - There are two ways to remove entries in HashMap.
        //          remove(Object key): It removes key from HashMap
        //          remove(Object key,Object value): It removes key if value is same as passed parameter value.

        // Remove truck key
        Integer speed = vehicleMaxSpeedMap.remove("Truck");
        System.out.println("===============================");
        System.out.println("Vehicle Truck with max speed "+speed+" removed from HashMap");
        System.out.println(vehicleMaxSpeedMap);
        System.out.println("================================");

        // Remove Car if value is 200
        boolean isCarRemoved = vehicleMaxSpeedMap.remove("Car",200);
        // Car key won't be removed as associated value is 220
        System.out.println("Did car removed from HashMap: "+isCarRemoved);
        System.out.println(vehicleMaxSpeedMap);
        System.out.println("===============================");

        // Remove Car if value is 140
        boolean isActivaRemoved = vehicleMaxSpeedMap.remove("Activa",140);
        // Activa key will be removed as associated value is 140
        System.out.println("Did activa removed from HashMap: "+isActivaRemoved);
        System.out.println(vehicleMaxSpeedMap);
        System.out.println("===============================");


        // --------------------------------------------------------------------------------
        /*
        Important HashMap methods:
                get(): Retrieve value from the HashMap
                put(): Put value into the HashMap
                isEmpty(): Check if HashMap is empty.
                containsKey(): Check if key present is HashMap
                containsValue(): Check if value exists in HashMap
                size(): Check size of the HashMap
                clear(): To remove all elements from Hashmap
                clone(): It creates shallow copy of HashMap.
         */

        System.out.println("Put new key-value to the hashMap: " + vehicleMaxSpeedMap.put("Motor", 300));                  // put new pair to map
        System.out.println("Get value from hashmap via key - value is: " + vehicleMaxSpeedMap.get("Bike"));               // get value via key
        System.out.println("Size of vehicleMaxSpeedMap: "+ vehicleMaxSpeedMap.size());                                    // check size of map
        System.out.println("Is vehicleMaxSpeedMap empty: " + vehicleMaxSpeedMap.isEmpty());                               // check if map is empty
        System.out.println("Is vehicleMaxSpeedMap contains key \"Bike\": " + vehicleMaxSpeedMap.containsKey("Bike"));     // check if map contains key
        System.out.println("Is vehicleMaxSpeedMap contains value \"160\": " + vehicleMaxSpeedMap.containsValue(160));     // check if map contains value


        System.out.println("\nClone hashmap to tempMap instance.");
        Object tempMap = vehicleMaxSpeedMap.clone();    // clone(): It creates shallow copy of HashMap.

        System.out.println("Show original HashMap: " + vehicleMaxSpeedMap);

        System.out.println("Clear original HashMap.");
        vehicleMaxSpeedMap.clear();      // clear(): To remove all elements from Hashmap

        System.out.println("Check size original HashMap: " + vehicleMaxSpeedMap.size());

        System.out.println("Use cloned hashMap to retreive back original HashMap.");
        vehicleMaxSpeedMap.putAll((Map<String, Integer>) tempMap);
        System.out.println("Check size original HashMap: " + vehicleMaxSpeedMap.size());
        System.out.println("Original hashMap after copied from clone operation: " + vehicleMaxSpeedMap);
    }
}
