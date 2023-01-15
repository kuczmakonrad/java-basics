package pl.kuczdev.threads;

class TestNewThread extends Thread {
    private int sleepTime;

    public TestNewThread(String name, int sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Wątek " + this.getName() + ", wartość i = " + i);
            try {
                this.sleep(this.sleepTime);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class q01_ThreadExtendExample {
    public static void main(String[] args) {
        TestNewThread thread1 = new TestNewThread("Thread 1", 500);
        thread1.start();

        TestNewThread thread2 = new TestNewThread("Thread 2", 1000);
        thread2.start();
    }
}
