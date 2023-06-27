package d5;

class NTestThread extends Thread {
    public void run() {
        System.out.println("[THREAD] :: " + Thread.currentThread().getName());
    }
}

public class Naming {
    public static void main(String[] args) {
        NTestThread t1 = new NTestThread();
        NTestThread t2 = new NTestThread();
        NTestThread t3 = new NTestThread();

        t1.setName("One_Thread_");
        t2.setName("Two_Thread_");
        t3.setName("Three_Thread_");

        t1.start();
        t2.start();
        t3.start();
    }
}
