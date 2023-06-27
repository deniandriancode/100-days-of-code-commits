import java.net.*;

public class DReceiv {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(3000);
            byte[] buff = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buff, 1024);
            ds.receive(dp);
            String message = new String(dp.getData(), 0, dp.getLength());
            System.out.println(message);
            ds.close();
        } catch (Exception e) {
            System.err.println("Exception is caught bro!");
        }
    }
}
