package pl.kuczdev.threads;

class ThreadTest implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " working right now and wait 1 second!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finshed!");
    }
}
public class q20_StartThreeThreadsAndFinishBeforeMainThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadTest(), "Thread1");
        Thread thread2 = new Thread(new ThreadTest(), "Thread2");
        Thread thread3 = new Thread(new ThreadTest(), "Thread3");

        thread1.start();
        thread1.join();
        System.out.println("CURRENT STATE OF " + Thread.currentThread().getName() + " THREAD: " + Thread.currentThread().getState());
        System.out.println("____________________________________________");

        thread2.start();
        thread2.join();
        System.out.println("CURRENT STATE OF " + Thread.currentThread().getName() + " THREAD: " + Thread.currentThread().getState());
        System.out.println("____________________________________________");


        thread3.start();
        thread3.join();
        //Thread.sleep(5000);
        System.out.println("CURRENT STATE OF MAIN THREAD: " + Thread.currentThread().getState());
        System.out.println("____________________________________________");

        System.out.println("EXIT MAIN THREAD");
    }
}
