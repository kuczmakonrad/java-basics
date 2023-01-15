package pl.kuczdev.data_structures.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
        entrySet(): As HashMap stores key value pair in form of Entry, we can retrieve entrySet() by calling map.entrySet()
        keySet(): Provides a set of keys.
        values(): Provides a collection of values.
 */
public class p04_HashMapEntrySetKeySetValuesExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentIDNameMap = new HashMap<>();

        // Putting key-values pairs in HashMap
        studentIDNameMap.put(101, "Andy");
        studentIDNameMap.put(102, "Mary");
        studentIDNameMap.put(103, "Sam");
        studentIDNameMap.put(104, "Sandy");

        // get entrySet
        Set<Map.Entry<Integer, String>> entrySet = studentIDNameMap.entrySet();
        System.out.println("EntrySet: " + entrySet);    // EntrySet: [101=Andy, 102=Mary, 103=Sam, 104=Sandy]

        // get keySet
        Set<Integer> keySet = studentIDNameMap.keySet();
        System.out.println("keySet: " + keySet);        // keySet: [101, 102, 103, 104]

        // get values
        Collection<String> values = studentIDNameMap.values();
        System.out.println("values: " + values);        // values: [Andy, Mary, Sam, Sandy]
    }
}
