package pl.kuczdev.threads;

public class q06_RaceConditionSolvedExample {
    public int counter = 0;

    public synchronized void increment() {
        this.counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        q06_RaceConditionSolvedExample race = new q06_RaceConditionSolvedExample();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200000; i++) {
                    race.increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200000; i++) {
                    race.increment();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();         // kod wątku main wywoła się dopiero po ukończeniu pierwszego wątku
        thread2.join();         // kod wątku main wywoła się dopiero po ukończeniu pierwszego wątku


        System.out.println("Counter: " + race.counter);     // Różne countery wychodzą, ponieważ wątki działały równolegle i nadpisywały countera
    }
}
