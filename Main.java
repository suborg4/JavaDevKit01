package javadevkithw01;

import javadevkithw01.client.Client;
import javadevkithw01.client.ClientWindow;
import javadevkithw01.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        ClientWindow clientWindow = new ClientWindow();
        Client client = new Client(clientWindow);
        clientWindow.setClient(client);
    }
}