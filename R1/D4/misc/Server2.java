import java.net.*;
import java.io.*;

/** Read Write both side */
public class Server2 {
    public static void main(String[] args) {
        try {
            final int PORT = 8888;
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "";
            String serverMessage = "";

            while (!clientMessage.equalsIgnoreCase("quit")) {
                clientMessage = dis.readUTF();
                System.out.println("[CLIENT] " + clientMessage);

                prompt();
                serverMessage = bufferedReader.readLine();
                dos.writeUTF(serverMessage);
                dos.flush();
            }

            bufferedReader.close();
            dos.close();
            dis.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.err.println("Exception on server!");
        }
    }

    public static void prompt() {
        System.out.print("> ");
    }
}
