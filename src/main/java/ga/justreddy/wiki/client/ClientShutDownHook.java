package ga.justreddy.wiki.client;

/**
 * @author JustReddy
 */
public class ClientShutDownHook extends Thread {

    private final Client client;

    public ClientShutDownHook(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        client.disconnect();
    }
}
