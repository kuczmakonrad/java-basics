package pl.kuczdev.threads;

public class q07_RaceConditionSolvedSynchronizedBlock {
    public int counter = 0;

    public void increment() {
        synchronized(this) {
            this.counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        q07_RaceConditionSolvedSynchronizedBlock race = new q07_RaceConditionSolvedSynchronizedBlock();

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