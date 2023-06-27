import java.net.*;

public class DSend {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            String message = "Java Datagram";
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), ip, 3000);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            System.err.println("Exception is caught bro!");
        }
    }
}
