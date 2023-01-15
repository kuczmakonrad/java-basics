package pl.kuczdev.data_structures.HashMap;
/*
Sort HashMap in java:
    * By Keys
        - We can sort keys in HashMap by using TreeMap. We just need to pass a HashMap to the constructor of TreeMap.
            You can see example in package: __work_questions.collections.treeMap.

    * By Values
        - We need to follow below steps to sort HashMap by values.
            1. Get entrySet() from HashMap.
            2. Convert entrySet to List.
            3. Sort the list with the help of Comparator.
            4. Iterate over list and put the Entry object in LinkedHashMap.

Let’s write an example to sort HashMap by keys and values.
We will create a class named Vehicle and will use it as Key in HashMap and value will be the owner of the Vehicle.

Please note that we have implemented comparable interface here which compares two vehicle by its name.
This Comparable will be used to sort it by Keys while constructing TreeMap.
 */

import java.util.*;

class Vehicle implements Comparable<Vehicle> {
    String name;
    long maxSpeed;

    public Vehicle(String name, long maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Vehicle{" + "name='" + name + '\'' + ", maxSpeed=" + maxSpeed + '}';
    }
}

public class p07_HashMapSortingExample {
    public static void main(String[] args) {
        Vehicle v1=new Vehicle("Car", 150);
        Vehicle v2=new Vehicle("Truck", 130);
        Vehicle v3=new Vehicle("Bike", 150);
        Vehicle v4=new Vehicle("Jeep", 180);

        // HashMap stores elements in key value pairs
        HashMap<Vehicle,String> vehicleOwnerHashMap=new HashMap<>();
        vehicleOwnerHashMap.put(v1,"John");
        vehicleOwnerHashMap.put(v2,"Chris");
        vehicleOwnerHashMap.put(v3,"Mary");
        vehicleOwnerHashMap.put(v4,"Harry");

        // Sort by keys - As Vehicle class implements Comparable which defines sorting by vehicle name
        TreeMap<Vehicle,String> vehicleOwnerSortedTreeMap = new TreeMap<Vehicle,String>(vehicleOwnerHashMap);
        System.out.println("Sorted TreeMap by vehicle name: " + vehicleOwnerSortedTreeMap);

        // Sort by values
        /*
        1. Get entrySet() from HashMap.
        2. Convert entrySet to List.
        3. Sort the list with the help of Comparator.
        4. Iterate over list and put the Entry object in LinkedHashMap.
        */
        Set<Map.Entry<Vehicle, String>> entrySet = vehicleOwnerHashMap.entrySet();
        List<Map.Entry<Vehicle, String>> vehicleEntryList = new ArrayList<>(entrySet);
        Collections.sort(vehicleEntryList,(e1,e2) -> e1.getValue().compareTo(e2.getValue()));

        LinkedHashMap<Vehicle, String> lmp = new LinkedHashMap<Vehicle, String>();
        vehicleEntryList.forEach((entry)-> {
            lmp.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Sorted Map by owner name: " + lmp);
    }
}
