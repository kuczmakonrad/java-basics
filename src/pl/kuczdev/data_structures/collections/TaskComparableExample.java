package pl.kuczdev.data_structures.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

class Task implements Comparable<Task>{
    private int orderId;
    private String name;

    public Task(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Task o) {
        int x = this.orderId;
        int y = o.getOrderId();

        if (x == y) {
            return 0;
        } else if (x > y) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Task{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                '}';
    }
}

class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        int x = o1.getOrderId();
        int y = o2.getOrderId();

        if (x == y) {
            return 0;
        } else if (x < y) {
            return 1;
        } else {
            return -1;
        }
    }
}


public class TaskComparableExample {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task(3, "Trzecie zadanie"));
        taskQueue.add(new Task(1, "Pierwsze zadanie"));
        taskQueue.add(new Task(2, "Drugie zadanie"));
        taskQueue.add(new Task(4, "Czwarte zadanie"));

        while(!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }

        System.out.println("\n");

        taskQueue = new PriorityQueue<>(new TaskComparator());
        taskQueue.add(new Task(3, "Trzecie zadanie"));
        taskQueue.add(new Task(1, "Pierwsze zadanie"));
        taskQueue.add(new Task(2, "Drugie zadanie"));
        taskQueue.add(new Task(4, "Czwarte zadanie"));

        while(!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}
