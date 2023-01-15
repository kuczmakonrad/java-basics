package pl.kuczdev.data_structures.LinkedHashMap;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
entrySet(): As HashMap stores key value pair in form of Entry, we can retrieve entrySet() by calling map.entrySet()
keySet(): Provides a set of keys.
values(): Provides a collection of values.
 */
public class p02_LinkedHashMapEntrySetKeySetValuesExample {
    public static void main(String[] args) {
        Map<Integer, String> studentIDNameMap = new LinkedHashMap<>();

        // Putting key-values pairs in LinkedHashMap
        studentIDNameMap.put(1001,"Andrew");
        studentIDNameMap.put(1002, "Martin");
        studentIDNameMap.put(1003, "Sameer");
        studentIDNameMap.put(1004,"Venkat");

        // get entrySet
        Set<Map.Entry<Integer, String>> entrySet = studentIDNameMap.entrySet();
        System.out.println("EntrySet: "+entrySet);

        // get keySet
        Set<Integer> keySet = studentIDNameMap.keySet();
        System.out.println("keySet: "+keySet);

        // get values
        Collection<String> values = studentIDNameMap.values();
        System.out.println("values: "+values);
    }
}
