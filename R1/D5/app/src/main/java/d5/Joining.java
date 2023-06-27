package d5;

class JoinThread extends Thread {

    public void run() {
        for (int i = 0; i < 2; ++i) {
            try {
                Thread.sleep(300);
                System.out.println("[THREAD] " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.err.println("Exception is caught bro!");
            }
        }
    }
}

public class Joining {
    public static void main(String[] args) {
        JoinThread t1 = new JoinThread();
        JoinThread t2 = new JoinThread();
        JoinThread t3 = new JoinThread();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            System.err.println("Exception is caught bro!");
        }

        System.out.println("[MAIN]");
    }
}
