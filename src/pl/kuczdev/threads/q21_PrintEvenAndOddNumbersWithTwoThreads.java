package pl.kuczdev.threads;

// mimo, że drukuje dobrze to jest źle -
class EvenNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                if (i%2==0) System.out.println(Thread.currentThread().getName() + ", number = " + i + " is even!");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddNumbers implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                if (i%2!=0) System.out.println(Thread.currentThread().getName() + ", number = " + i + " is odd!");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class q21_PrintEvenAndOddNumbersWithTwoThreads {
    public static void main(String[] args) throws InterruptedException {
        EvenNumbers even = new EvenNumbers();
        OddNumbers odd = new OddNumbers();

        Thread evenThread = new Thread(even, "EvenThread");
        Thread oddThread = new Thread(odd, "oddThread");

        evenThread.start();
        oddThread.start();

        evenThread.join();
        oddThread.join();
    }
}
