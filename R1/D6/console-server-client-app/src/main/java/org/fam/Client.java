package org.fam;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        final int PORT = 8080;
        final String HOST = "localhost";

        try {
            Socket socket = new Socket(HOST, PORT);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "";
            while (!clientMessage.equalsIgnoreCase("quit")) {
                System.out.print("> ");
                clientMessage = bufferedReader.readLine();
                dos.writeUTF(clientMessage);
                dos.flush();
            }

            bufferedReader.close();
            dos.close();
            dis.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
