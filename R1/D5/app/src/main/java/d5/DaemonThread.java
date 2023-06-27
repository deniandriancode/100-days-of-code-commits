package d5;

class TestDaemon extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon Thread!!!");
        } else {
            System.out.println("User Thread!!!");
        }
    }
}

public class DaemonThread {
    public static void main(String[] args) {
        TestDaemon t1 = new TestDaemon();
        TestDaemon t2 = new TestDaemon();
        TestDaemon t3 = new TestDaemon();

        t1.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }
}
