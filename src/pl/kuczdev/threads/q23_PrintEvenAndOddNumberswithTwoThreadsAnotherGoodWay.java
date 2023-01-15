package pl.kuczdev.threads;
/*
Solution 2: Using remainder
You can use concept of remainder here.

If number%2==1 then Odd will print the number and increment it else will go in the wait state.
If number%2==0 then Even will print the number and increment it else will go in the wait state.
Let’s check with the help of example.

Create a class named OddEvenRunnable and implement Runnable interface.
 */
class OddEvenRunnable implements Runnable{
    public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    static Object lock=new Object();

    OddEvenRunnable(int remainder)
    {
        this.remainder=remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO) {
            synchronized (lock) {
                while (number % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}

public class q23_PrintEvenAndOddNumberswithTwoThreadsAnotherGoodWay {
    public static void main(String[] args) {
        OddEvenRunnable oddRunnable=new OddEvenRunnable(1);
        OddEvenRunnable evenRunnable=new OddEvenRunnable(0);

        Thread t1=new Thread(oddRunnable,"Odd");
        Thread t2=new Thread(evenRunnable,"Even");

        t1.start();
        t2.start();
    }
}

