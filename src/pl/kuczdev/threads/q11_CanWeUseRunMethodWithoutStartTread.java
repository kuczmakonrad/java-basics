package pl.kuczdev.threads;
/*
Can we call run() method directly to start a new thread
No, you can not directly call run method to start a thread.
You need to call start method to create a new thread.
If you call run method directly , it won’t create a new thread and it will be in same stack as main.

Lets understand with the help of example:

When using:
    run() - As you can see when we are directly calling run method, it is not creating new threads.
    start() - working well.

You can not directly call run method to create a thread, you need to call start method to create a new thread.
 */

class CustomThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread is running: " + i);
        }
    }
}

public class q11_CanWeUseRunMethodWithoutStartTread {
    public static void main(String[] args) {
        CustomThread ct1 = new CustomThread();
        CustomThread ct2 = new CustomThread();
        //ct1.start();
        //ct2.start();

        ct1.run();
        ct2.run();
    }
}
