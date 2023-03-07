package chat.managers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketManager {
    public static final int PORT = 3000;
    public static final String HOST = "localhost";
    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    public static ServerSocket getServerSocket(){
        try{
            if (serverSocket == null) {
                serverSocket = new ServerSocket(PORT);
            }
        }catch (IOException e){
            System.err.println("Cannot initialize Socket");
        }
        return serverSocket;
    }

    public static Socket getClientSocket(){
        try{
            if (clientSocket == null) {
                clientSocket = new Socket(HOST, PORT);
            }
        }catch (IOException e){
            System.err.println("Cannot initialize Socket");
        }
        return clientSocket;
    }
    public void closeSocket(Socket socket){
        try {
            socket.close();
        } catch (IOException e) {
            System.exit(0);
            System.out.println("all the Services are closed");
        }
    }

    public static Socket requestConnection() {
        return SocketManager.getClientSocket();
    }

}
