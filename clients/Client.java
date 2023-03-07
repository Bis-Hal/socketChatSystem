package chat.clients;

import chat.services.ClientReadableService;
import chat.services.ClientWriteableService;
import chat.managers.SocketManager;

import java.net.Socket;

public class Client {

    private static Socket socket;
    public static String id;

    public static void requestConnection() {
        socket = SocketManager.requestConnection();
    }

    public static void activateClientServices() {
        incomingMessageListener();
        outgoingMessageListener();
    }

    public static void incomingMessageListener() {
        new Thread(new ClientReadableService(socket)).start();
    }

    public static void outgoingMessageListener() {
        new Thread(new ClientWriteableService(socket, id)).start();
    }
}
