package pl.kuczdev.threads.q00_lifecycle;

class TestThread extends Thread {
    Thread mainThread;

    public TestThread(String name, Thread mainThread) {
        super(name);
        this.mainThread = mainThread;
    }

    public void run() {
        System.out.println(getName() + " started.");

        for (int a = 0; a < 3; a++) {
            try {
                Thread.sleep(1000);
                System.out.println("Main thread state: " + mainThread.getState());          // Main thread state: WAITING
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getName() + " finished.");
    }
}

public class q04_WaitingState {
    public static void main(String args[]) throws InterruptedException {
        Thread mainThread = Thread.currentThread();     // główny wątek Main

        TestThread t1 = new TestThread("Thread1", mainThread);
        t1.start();
        t1.join();
        System.out.println("Main thread");
    }
}