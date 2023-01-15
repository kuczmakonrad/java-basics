package pl.kuczdev.threads;

class RunnableClass implements Runnable {
    private String name;
    private int sleepTime;

    public RunnableClass(String name, int sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    public void run() {
        int i = 5;
        while (i > 0) {
            try {
                System.out.println("Wątek: " + this.name + ", uśpienie = " + this.sleepTime + " ms, odliczanie: " + i);
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}

// jeżeli nie chcemy tworzyć instancji wątku możemy zawrzeć ją w tej klasie
class RunnableClass2 extends RunnableClass implements Runnable {
    private Thread thread;

    public RunnableClass2(String name, int sleepTime) {
        super(name, sleepTime);
    }

    public void start() {
        if(thread == null) {
            thread = new Thread(this);          // this, bo thread przyjmuje obiekt implementujący Runnable
            thread.start();
        }
    }
}

public class q02_RunnableExample {
    public static void main(String[] args) {
        RunnableClass t1 = new RunnableClass("Wątek 1", 1000);
        Thread thread1 = new Thread(t1, "thread1");
        thread1.start();

        RunnableClass t2 = new RunnableClass("Wątek 2", 500);
        Thread thread2 = new Thread(t2, "thread2");
        thread2.start();

        RunnableClass2 t3 = new RunnableClass2("Wątek 3", 2000);
        t3.start();
    }
}
