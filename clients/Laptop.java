package chat.clients;

import java.io.IOException;


public class Laptop extends Client {
    public static void main(String[] args) throws IOException {
        requestConnection();
        id = Laptop.class.getSimpleName();
        activateClientServices();
    }
}
