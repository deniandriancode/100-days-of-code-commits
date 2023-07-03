package org.fam;

import java.net.*;
import java.io.*;

class DataObject {
    public boolean quit = false;

    public void checkMessage(String message) {
        if (message.equalsIgnoreCase("quit")) {
            quit = true;
        }
    }

}

class MessageReceiver implements Runnable {

    final int PORT = 8080;
    DataObject dataObject;

    public MessageReceiver(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "";
            while (!clientMessage.equalsIgnoreCase("quit")) {
                clientMessage = (String) dis.readUTF();
                dataObject.checkMessage(clientMessage);
                System.out.println("\b\b[CLIENT] " + clientMessage);
                System.out.print("> ");
            }

            bufferedReader.close();
            dos.close();
            dis.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


public class Server {
    
    public static void main(String[] args) throws Exception {
        DataObject dataObject = new DataObject();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Thread messageThread = new Thread(new MessageReceiver(dataObject));
        messageThread.start();

        String msg = "";
        while(!dataObject.quit) {
            System.out.print("> ");
            msg = bufferedReader.readLine();
            System.out.println("You write : " + msg);
        }

        messageThread.join();
    }

}
