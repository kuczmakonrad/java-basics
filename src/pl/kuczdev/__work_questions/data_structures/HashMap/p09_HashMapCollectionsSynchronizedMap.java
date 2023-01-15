package pl.kuczdev.__work_questions.data_structures.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
Collections.synchronizedMap
    We can use Collections.synchronizedMap() to make all operations of HashMap thread safe and make incrementTime() method synchronized to solve above issue.
    incrementTime() should be also synchronized otherwise there will be atomicity issues.

Output:
    Time for Counter1: 100
    Time for Counter2: 200

As you can see, we are getting correct output after using Collections.synchronizedMap() and making incrementTime synchronized.

The disadvantage of using Collections.synchronizedMap() is that it locks whole hashmap object and which may cause performance issue
but ConcurrentHashMap only locks part of the map and performs quite well in a multithreaded environment.
 */
public class p09_HashMapCollectionsSynchronizedMap {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> counterMap = Collections.synchronizedMap(new HashMap<>());
        counterMap.put("counter1", 0);
        counterMap.put("counter2", 100);

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

        Runnable counterTask = () -> {
            incrementTime(counterMap, "counter1");
            incrementTime(counterMap, "counter2");
        };

        for (int i = 1; i <= 100; i++) {
            newFixedThreadPool.submit(counterTask);
        }

        newFixedThreadPool.shutdown();
        newFixedThreadPool.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println("Time for Counter1: " + counterMap.get("counter1"));
        System.out.println("Time for Counter2: " + counterMap.get("counter2"));
    }

    public static synchronized void incrementTime(Map<String, Integer> counterMap, String counter) {
        Integer count = counterMap.get(counter);
        count++;
        counterMap.put(counter, count);
    }
}