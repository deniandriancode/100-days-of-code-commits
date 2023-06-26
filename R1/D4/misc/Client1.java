import java.net.*;
import java.io.*;

public class Client1 {
    public static void main(String[] args) {
        try {
            final String HOST = "localhost";
            final int PORT = 8888;

            Socket socket = new Socket(HOST, PORT);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = "Hello Server! How are you doing?";
            dos.writeUTF(message);
            dos.flush();

            dos.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Exception on client");
        }
    }
}
