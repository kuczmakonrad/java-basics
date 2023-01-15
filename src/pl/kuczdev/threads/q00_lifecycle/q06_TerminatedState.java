package pl.kuczdev.threads.q00_lifecycle;

public class q06_TerminatedState {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run");
            }
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println(thread.getState());  // OUTPUT: TERMINATED
    }
}

// output:
//Thread run
//TERMINATED