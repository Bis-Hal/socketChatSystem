package chat.services;

import chat.managers.StreamManager;

import java.io.DataInputStream;
import java.net.Socket;


public class ClientReadableService implements Runnable {

    private static Socket socket;
    private DataInputStream dataInputStream;

    public ClientReadableService(Socket socket) {
        ClientReadableService.socket = socket;
    }

    public void inti() {
        dataInputStream = StreamManager.getReadableStream(socket);

    }

    public void readMessage() {
        String message = StreamManager.getMessage(dataInputStream);

        if (message.endsWith(StreamManager.END)) {
            StreamManager.closeInputStream(dataInputStream);
        }

        System.out.println(message);
    }

    @Override
    public void run() {
        inti();
        while (true) {
            readMessage();
        }
    }
}
