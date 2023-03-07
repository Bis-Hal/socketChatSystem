package chat;

import java.net.Socket;
import java.util.HashMap;

public class Observer {

    //ServerService HashMap use maybe??
    HashMap<String, Socket> onlineClients = new HashMap<>();

    public void updateOnlineClients(){
        onlineClients.put("Client 1", new Socket());
        brodCastOnlineClients();
    }
    public void brodCastOnlineClients(){
      onlineClients.forEach((id, socket)->{
          System.out.println(id);
          //display code//maybe menu??
      });
    }

    public void updateOfflineClients(String id, Socket socket){
        if(onlineClients.containsValue(socket)){
            onlineClients.remove(id);
        }
        brodCastOnlineClients();
    }
}
