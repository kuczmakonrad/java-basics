package pl.kuczdev.threads;

public class q09_DeamonExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Deamon thread: " + i);
                    i++;
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        Thread.sleep(10000);
        System.out.println("Quit Main Thread!");
    }
}
