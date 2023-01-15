package pl.kuczdev.threads;
/*
Problem
You are given two threads. You need to print odd numbers using one thread and even numbers using another thread.You need to print in natural order up to MAX.
    For example:
    If MAX is 10, you need to print:

    1 2 3 4 5 6 7 8 9 10
    So 1 3 5 7 9 will be printed by odd thread
    2 4 6 8 10 will be printed by even thread.

Solution 1
We will use wait and notify to solve how to print even and odd numbers using threads in java.
    1. Use a variable called boolean odd. If you want to print odd number, it’s value should be true and vice versa for even number.
    2. Create two methods printOdd() and printEven(), one will print odd numbers and other will print even numbers.
    3. Create two threads, t2 for odd and t1 for even.
    4. t1 will call printEven() method and t2 will call printOdd() method simultaneously.
    5. If boolean odd is true in printEven() method, t1 will wait.
    6. If boolean odd is false in printOdd() method, t2 will wait.
 */
public class q22_PrintEvenAndOddNumbersWithTwoThreadsCorrectWay {

    boolean odd;
    int count = 1;
    int MAX = 20;

    public void printOdd() {
        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking odd loop");

                while (!odd) {
                    try {
                        System.out.println("Odd waiting : " + count);
                        wait();
                        System.out.println("Notified odd :" + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread :" + count);
                count++;
                odd = false;
                notify();
            }
        }
    }
    public void printEven() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        synchronized (this) {
            while(count < MAX) {
                System.out.println("Checking even loop");

                synchronized (this) {
                    while (count < MAX) {
                        System.out.println("Checking even loop");

                        while (odd) {
                            try {
                                System.out.println("Even waiting: " + count);
                                wait();
                                System.out.println("Notified even:" + count);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Even thread :" + count);
                        count++;
                        odd = true;
                        notify();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        q22_PrintEvenAndOddNumbersWithTwoThreadsCorrectWay oep = new q22_PrintEvenAndOddNumbersWithTwoThreadsCorrectWay();
        oep.odd = true;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oep.printEven();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                oep.printOdd();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}