/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package d5;

class ExtendThread extends Thread {
    public void run() {
        System.out.println("ExtendThread is running...");
    }
}

class ImplRunn implements Runnable {

    @Override
    public void run() {
        System.out.println("ImplRunn is running...");
    }
}

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        extendThreadDemo();
        implRunnDemo();
    }

    public static void extendThreadDemo() {
        ExtendThread th = new ExtendThread();
        th.run();
    }

    public static void implRunnDemo() {
        ImplRunn imp = new ImplRunn();
        Thread th = new Thread(imp);
        th.start();
    }
}
