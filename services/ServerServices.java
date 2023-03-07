package chat.services;

import chat.managers.StreamManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerServices implements Runnable {

    private static final ArrayList<Socket> onlineClients = new ArrayList<>();
    private static final HashMap<Socket,Socket> sockets = new HashMap<>();
    private Socket socket;
    private  DataOutputStream dataOutputStream;
    private  DataInputStream dataInputStream;
    private String message;

    public ServerServices(Socket socket) {
        this.socket = socket;
        addClientToServer();
    }

    public void addClientToServer() {
        onlineClients.add(socket);
        System.out.println(onlineClients.size() + " Client Added");
    }

    public void readMessage() {
         message = StreamManager.getMessage(dataInputStream);
        System.out.println("Server Read : " + message);
    }

    public void initReadableAndWritableSteams() {
        dataInputStream = StreamManager.getReadableStream(socket);
    }

    public void broadcastMessage() {

        for (Socket serverToken : onlineClients) {
            if (socket != serverToken) {
                dataOutputStream = StreamManager.getWritableStream(serverToken);
                StreamManager.writeMessage(message, dataOutputStream);
            }
        }
    }

    @Override
    public void run() {

        initReadableAndWritableSteams();

        while (true) {
            readMessage();
            broadcastMessage();
        }
    }
}
