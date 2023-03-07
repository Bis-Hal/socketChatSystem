package chat;

import chat.managers.SocketManager;
import chat.services.ServerServices;

import java.io.IOException;
import java.net.Socket;

public class Server {
    public static Socket socket;

    public static void clientRequestListener() {
        try {
            socket = SocketManager.getServerSocket().accept();
        } catch (IOException e) {
            System.out.println("Couldn't start the server");
        }
    }
    public static void activateServerServices() {
        new Thread(new ServerServices(socket)).start();
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            clientRequestListener();
            activateServerServices();
        }
    }
}



