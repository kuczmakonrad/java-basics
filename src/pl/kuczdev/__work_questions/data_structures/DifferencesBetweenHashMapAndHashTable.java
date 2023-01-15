package pl.kuczdev.__work_questions.data_structures;

import java.util.*;

/*
    1. ThreadSafe:
        * HashMap - NO.
        * Hashtable - YES.

    2. Synchronized:
        * HashMap - NO.
        * Hashtable - YES.

    3. Performance:
        * HashMap - In single threaded environment, it is much faster than Hashtable. So if you do not work in multi thread environment,then hashMap is recommended.
        * Hashtable - Due to theadSafe and Synchronized,it is often slower than HashMap.

    4. Null key:
        * HashMap - Allows null key as well as values.
        * Hashtable - Do not allow.

    5. Fail fast:
        * HashMap - Iterator in HashMap is fail fast.
        * Hashtable - Enumeration in Hashtable is not fail fast.

    6. Extends:
        * HashMap - It extends AbstractMap class.
        * Hashtable - It extends Dictionary class which is quite old.

    7. Alternative:
        * HashMap - You can use ConcurrentHashMap for multi thread environment.
        * Hashtable - No alternative.



Some important points need to be discussed:
* Synchronized means only one thread can modify one table at one point of time.
    When any thread performs update operation on hashtable then it acquires lock on it and other threads have to wait for lock to be released.
* Fail-fast iterator means if one thread is iterating over hashmap and other thread trying to modify hashmap structurally it will throw
    ConcurrentModification Exception and fail immediately.
    Structurally modification means inserting or deleting elements that can change the structure of map.

* Can we synchronize HashMap?
    Yes, We can synchronized a HashMap also with the help of Collections.synchonizedMap(hashmap) so HashMap can be synchronized by:
        Map map=Collections.synchonizedMap(hashmap);
1
2
3

Map map=Collections.synchonizedMap(hashmap)
 */
public class DifferencesBetweenHashMapAndHashTable {
    public static void main(String[] args) {
        // HashMap implements Map  interface which maps a key to value.
        // It is not synchronized and is not thread-safe. Duplicate keys are not allowed and null keys, as well as value, are allowed.
        HashMap<Integer,String> employeeHashmap = new HashMap<Integer,String>();
        employeeHashmap.put(1, "Arpit");
        employeeHashmap.put(2, null);  // will work fine

        // Hashtable implements Map interface which maps key to value.
        // It is synchronized and thread-safe. Duplicate keys are not allowed and the null key is not allowed.
        Hashtable<Integer,String> employeeHashtable = new Hashtable<Integer,String>();
        employeeHashtable.put(1, "Arpit");
        employeeHashtable.put(2, null);  //not allowed and will throw NullPointer exception at run time

    }
}
