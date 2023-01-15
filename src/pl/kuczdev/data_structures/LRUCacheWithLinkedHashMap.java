package pl.kuczdev.data_structures;
/*
We can use LinkedHashMap to create LRU cache as well. LinkedHashMap has a constructor in which you can specify access order.
If you pass accessOrder as true, LinkedHashMap will work on the basis of access order rather than insertion order.

We will also override a method named removeEldestEntry() and it will return true in case size() is greater than capacity.

As you can see, in last 4 entries, we do not have 15 as key. That’s the reason we are getting -1 for it.
 */

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheSecond {
    private LinkedHashMap<Integer, Integer> cacheMap;
    public LRUCacheSecond(int capacity) {
        cacheMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    // This method works in O(1)
    public int get(int key) {
        return cacheMap.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public void set(int key, int value) {
        cacheMap.put(key, value);
    }
}

public class LRUCacheWithLinkedHashMap {
    public static void main(String[] args) {
        LRUCacheSecond lrucache = new LRUCacheSecond(4);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(10, 97);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
    }
}
