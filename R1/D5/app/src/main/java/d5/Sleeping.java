package d5;

class TestSleep extends Thread {
    public void run() {
        for (int i = 0; i < 5; ++i) {
            try {
                Thread.sleep(1000, 0);
                System.out.println(i+1);
            } catch (InterruptedException e) {
                System.err.println("InterruptedException bro!");
            }
        }
    }
}

public class Sleeping {
    public static void main(String[] args) {
        TestSleep ts = new TestSleep();
        TestSleep ts2 = new TestSleep();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ts.start();
        ts2.start();
    }
}
