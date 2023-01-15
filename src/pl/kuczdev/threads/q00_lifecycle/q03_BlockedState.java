package pl.kuczdev.threads.q00_lifecycle;

class SomeThread implements Runnable {
    public static synchronized void test() {
        while(true) {

        }
    }

    @Override
    public void run() {
        test();
    }
}
public class q03_BlockedState {
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(new SomeThread());
        Thread thread2 = new Thread(new SomeThread());
        thread1.start();            // STATE: RUNNABLE (gdyż cały czas działa nieskończona pętla w pierwszym wątku)
        thread2.start();            // STATE: RUNNABLE (przez krótki czas) -> BLOCKED (gdyż metoda jest synchronized i jest korzystana w pierwszym wątku)

        Thread.sleep(1000);
        System.out.println("Thread1 state: " + thread1.getState());         // OUTPUT: Thread1 state: RUNNABLE
        System.out.println("Thread2 state: " + thread2.getState());         // OUTPUT: Thread2 state: BLOCKED
    }
}
