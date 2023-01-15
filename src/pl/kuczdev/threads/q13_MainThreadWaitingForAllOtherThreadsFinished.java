package pl.kuczdev.threads;
/*
Thread class’s join() method can be used to stop current execution of thread until thread it joins, completes its task.
So basically, it waits for the thread on which join method is getting called, to die.

For example:
Here when you call t1.join(), main thread will wait for t1 to complete its start before resuming its execution.

    // Main thread execution
    Thread t1=new Thread(mr,"Thread 1");
    t1.start();
    // lets waits for t1 to die
    try {
    t1.join();
    } catch (InterruptedException e) {


Variants of join methods:
There are three variant of join method:
    * public final void join() throws InterruptedException -
        Thread on which join method is getting called, to die.

    * public final void join(long millis) throws InterruptedException -
        This method when called on the thread, it waits for either of following:
            ** Thread on which join method is getting called, to die.
            ** Specified milliseconds

    * public final void join(long millis,int nanos) throws InterruptedException
        This method when called on the thread, it waits for either of following:
            ** Thread on which join method is getting called, to die.
            ** Specified milliseconds + nano seconds


If the thread, on which join method is called, has been already terminated or has not been started yet, then join method returns immediately.!!


When you run above program, you will get following output.
    Main thread execution starts
    Thread 1 Start
    Thread 1 end
    Thread 2 Start
    Thread 3 Start
    Thread 2 end
    Thread 3 end
    Main thread execution ends

Lets analysis output now.
    1. Main thread execution starts.
    2. Thread 1 starts(Thread 1 start) and as we have put t1.join(), it will wait for t1 to die(Thread 1 end).
    3. Thread 2 starts(Thread 2 start) and waits for either 1 seconds or die, but as we have put sleep for 4 seconds in run method, it will not die in 1 second. so main thread resumes and Thread 3 starts(Thread 3 start)
    4. As we have put t2.join() and t3.join(). These 2 threads will get completed before exiting main thread, so Thread 2 will end(Thread 2 end ) and then thread 3 will end(Thread 3 end).
    5. Main thread execution ends.

Java Thread Join and Synchornization
    Java thread join method guarantees happens before relationship.
    It means if thread t1 calls t2.join(), then all the changes done by t2 are visible to t1.

That’s all about Java Thread Join Example.
 */

class MyRunnable implements Runnable {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Start");
            Thread.sleep(4000);  // thread sleeps for 4 secs
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class q13_MainThreadWaitingForAllOtherThreadsFinished {
    public static void main(String args[]) {
        System.out.println("Main thread execution starts");
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "Thread 1");
        Thread t2 = new Thread(mr, "Thread 2");
        Thread t3 = new Thread(mr, "Thread 3");

        t1.start(); // lets waits for t1 to die

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        try {
            t2.join(1000);  // lets waits for 1 sec or t2 to die which ever occurs first
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        t3.start();

        // complete all threads before completing main thread
        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("Main thread execution ends");
    }
}