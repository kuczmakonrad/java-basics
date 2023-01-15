package pl.kuczdev.threads.q00_lifecycle;

public class q01_NewState {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Working thread");
            }
        });

        System.out.println("STATE: " + thread.getState());          // OUTPUT: STATE: NEW  -  Wątek w stanie NEW - utworzony, ale jeszcze nie rozpoczął swojej pracy
        //thread.start();
        System.out.println("STATE: " + thread.getState());          // OUTPUT: STATE: RUNNABLE   -   Wątek w stanie RUNNABLE - działający wątek

    }
}
