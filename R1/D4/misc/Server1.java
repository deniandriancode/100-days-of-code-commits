import java.net.*;
import java.io.*;

public class Server1 {
    public static void main(String[] args) {
        try {
            final int PORT = 8888;
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();

            System.out.println("[CLIENT] " + message);

            dis.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.err.println("Exception on server!");
        }
    }
}
