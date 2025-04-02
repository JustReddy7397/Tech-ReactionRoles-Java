package ga.justreddy.wiki;

import ga.justreddy.wiki.client.Client;
import ga.justreddy.wiki.client.ClientShutDownHook;

public final class Main {

    public static void main(String[] args) {
        final Client client = new Client();
        client.connect();
        Runtime.getRuntime().addShutdownHook(new ClientShutDownHook(client));
    }
}