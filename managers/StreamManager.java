package chat.managers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class StreamManager {

    private static DataInputStream dataInputStream;
    private static DataOutputStream dataOutputStream;
    public static final String END = "END";

    public static DataInputStream getReadableStream(Socket socket) {
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Cannot access the Stream");
        }
        return dataInputStream;

    }

    public static String getMessage(DataInputStream dataInputStream)  {
        String message = "";
        try {
            message = dataInputStream.readUTF();
        } catch (IOException e) {
            System.out.println("Message cannot be written");
            System.exit(0);
        }
        return message;
    }

    public static DataOutputStream getWritableStream(Socket socket){
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Cannot Access to write");
            System.exit(0);

        }
        return dataOutputStream;
    }

    public static void writeMessage(String message, DataOutputStream dataOutputStream){
        try {
            dataOutputStream.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeInputStream(DataInputStream dataInputStream){
        try {
            dataInputStream.close();
        } catch (IOException e) {
            System.err.println("Cannot Close Input Stream");
            System.exit(0);

        }
    }
    public static void closeOutputStream(DataOutputStream dataOutputStream){
        try {
            dataOutputStream.close();
        } catch (IOException e) {
            System.err.println("Cannot Close Output Stream");
            System.exit(0);
        }
    }
}
