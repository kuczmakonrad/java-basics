package pl.kuczdev.__work_questions.data_structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    1. Interface implementation:
        * HashSet implements Set interface which does not allow duplicate value.It is not synchronized and is not thread safe.
        * HashMap implements Map interface which maps key to value. It is not synchronized and is not thread safe.

    2. Methods - for example for adding:
        * HashSet - It uses add(value) method for storing data.
        * HashMap - It stores data in a form of key->value pair.So it uses put(key,value) method for storing data.

    3. Duplicates:
        * HashSet does not allow duplicate values.
        * HashMap allows duplicate value but not duplicate keys.

    4. Performance:
        * HashMap is faster than HashSet as values are stored with unique keys.
        * HashSet is slower than HashMap.

    5. Hashcode calculation:
        * In hashMap hashcode value is calculated using key object.
        * In hashSet hashcode is calculated on the basis of value object.
            Hashcode can be same for two value object so we have to implement equals() method.
            If equals() method return false then two objects are different.


    If we are adding custom objects to HashSet then we must override() Hashcode() and equals() method according to our need.
    If we do not override then object will take default implementation which may not desirable.
 */
public class DifferencesBetweenHashMapAndHashSet {
    public static void main(String[] args) {
        Map<Integer,String> employeeHashmap = new HashMap<Integer,String>();
        employeeHashmap.put(1,"Arpit");
        employeeHashmap.put(2,"John");

        Set employeeSet = new HashSet();
        employeeSet.add("Arpit");
        employeeSet.add("Arpit");
        employeeSet.add("john");
        // Above employeeSet will have 2 elements in it as Set does not allow duplicate values.
    }
}
