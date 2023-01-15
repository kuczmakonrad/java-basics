package pl.kuczdev.threads;
/*
Can we start a thread twice in java
No, Once you have started a thread, it can not be started again. If you try to start thread again , it will throw IllegalThreadStateException

If you try to start thread again , it will throw IllegalThreadStateException
*/

class FirstThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }

}

public class q12_CanWeStartSameThreadTwoTimes {
    public static void main(String[] args) {
        FirstThread ft = new FirstThread();
        ft.start();
        ft.start();
    }
}
