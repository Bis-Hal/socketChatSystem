package chat.clients;
import java.io.IOException;


public class SmartPhone extends Client {

    public static void main(String[] args) throws IOException {
        requestConnection();
        id = SmartPhone.class.getSimpleName();
        activateClientServices();
    }
}
