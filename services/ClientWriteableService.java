package chat.services;

import chat.managers.StreamManager;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriteableService implements Runnable {
    private final Socket socket;
    private Scanner getMessage;
    private DataOutputStream dataOutputStream;

    private String id;
    public ClientWriteableService(Socket socket,String id) {
        this.id = id;
        this.socket = socket;
    }

    public void init() {
        dataOutputStream = StreamManager.getWritableStream(socket);
        getMessage = new Scanner(System.in);
    }
    public void writeMessage(){
        String message = getMessage.nextLine();
        StreamManager.writeMessage(id +" : "+ message, dataOutputStream);
    }

    @Override
    public void run() {
        init();

        while (true) {
            writeMessage();
        }
    }
}
