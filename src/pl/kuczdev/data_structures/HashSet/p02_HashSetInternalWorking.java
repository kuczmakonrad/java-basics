package pl.kuczdev.data_structures.HashSet;

/*
When you add any duplicate element to HashSet, add() method returns false and do not add duplicate element to HashSet.
How add method return false? For this, we need to see HashSet’s add method in JavaAPI.

So from this code, It is clear that HashSet uses HashMap for checking duplicate elements.As we know that in HashMap, key should be unique.
So HashSet uses this concept, When element is added to HashSet, it is added to internal HashMap as Key.
This HashMap required some value so a dummy Object(PRESENT) is used as value in this HashMap.

PRESENT is dummy value which is used value for internal map.

Lets see add method - we got two cases:
    * map.put(e,PRESENT) will return null, if element not present in that map. So map.put(e, PRESENT) == null will return true,
        hence add method will return true and element will be added in HashSet.
    * map.put(e,PRESENT) will return old value ,if element is already present in that map. So  map.put(e, PRESENT) == null will return false,
        hence add method will return false and element will not be added in HashSet.
 */
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class E {}

public class p02_HashSetInternalWorking extends AbstractSet implements Set, Cloneable, java.io.Serializable{
    private transient HashMap<E,Object> map;

    // PRESENT is dummy value which will be used as value in map
    private static final Object PRESENT = new Object();

    // Constructs a empty map.so hash
    public p02_HashSetInternalWorking() {
        map = new HashMap<E,Object>();
    }

    // return false if e is already present in HashSet
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    // other HashSet methods
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
