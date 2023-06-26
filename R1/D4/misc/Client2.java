import java.net.*;
import java.io.*;

/** Read Write both side */
public class Client2 {
    public static void main(String[] args) {
        try {
            final String HOST = "localhost";
            final int PORT = 8888;

            Socket socket = new Socket(HOST, PORT);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "";
            String serverMessage = "";

            while (!clientMessage.equalsIgnoreCase("quit")) {
                prompt();
                clientMessage = bufferedReader.readLine();
                dos.writeUTF(clientMessage);
                dos.flush();

                serverMessage = dis.readUTF();
                System.out.println("[SERVER] " + serverMessage);
            }

            dos.close();
            dis.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Exception on client");
        }
    }

    public static void prompt() {
        System.out.print("> ");
    }
}
