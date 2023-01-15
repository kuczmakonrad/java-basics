package pl.kuczdev.data_structures.LinkedHashMap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/*
LinkedHashMap is not thread-safe by default and it can give non-deterministic results in case of a multithreaded environment.
If multiple threads try to access LinkedHashMap and one of them does the structural modification, then it should be externally synchronized.
Best way to do this at LinkedHashMap creation time.
I have already provided an example for HashMap thread safety, since same example is applicable for LinkedHashMap, you can go to:
    * pl.kuczdev.__work_questions_collections_hashMap_p08_HashMapIsThreadSafe.java
    * pl.kuczdev.__work_questions_collections_hashMap_p08_HashMapCollectionsSynchronizedMap.java
*/

public class p05_LinkedHashMapNotThreadSafe {
    public static void main(String[] args) {
        Map m= Collections.synchronizedMap(new LinkedHashMap());
    }
}
