package pl.kuczdev.data_structures;
/*
Design a Least recently used cache implementation in java. It should have below properties.

bounded size: It should have bounded size to take care of memory limits.

Fast access: As we are designing cache, we should be able to fetch or update entries faster.
Evict least recently used entry: Cache should evict least recently used entry if capacity is reached.

There are two two example solutions and this is one of them.

Using HashMap and Doubly linked list
As we need to do lookup in O(1) time then HashMap is obvious choice but we need to take care of least recently used entry as well.

We need to find a data structure which can remove/add in O(1) time if we already know the node.
We can use a double linked list for this purpose because it provides removal/addition in O(1) time if already know about the node.

HashMap will make get operation in O(1) time and Doube linked list will make removal/addition in O(1) time.

As you can see, in last 4 entries, we do not have 15 as key. That’s the reason we are getting -1 for it.
 */

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key){
        if (map.containsKey(key)) {
            Node n = map.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    // this method will delete Node
    public void delete(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    // this method will make passed node as head
    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;
        if (end == null) {
            end = head;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            // update the old value
            Node old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                delete(end);
                setHead(newNode);
            } else {
                setHead(newNode);
            }

            map.put(key, newNode);
        }
    }
}
public class LRUCacheWithHashMapAndDoublyLinkedList {
    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache(4);
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
