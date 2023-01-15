package pl.kuczdev.threads.q00_lifecycle;

public class q05_TimedWaitingState {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();     // Będą dwa równoległe wątki - główny wątek Main oraz wątek thread
        Thread.sleep(100);      // Na chwilę uśpimy główny wątek, żeby pierwszy wątek musiał oczekiwać
        System.out.println("Thread state: " + thread.getState());   // Thread state: TIMED_WAITING
    }
}
