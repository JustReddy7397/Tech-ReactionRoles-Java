package ga.justreddy.wiki.client;

import ga.justreddy.wiki.database.Database;
import ga.justreddy.wiki.util.Color;
import ga.justreddy.wiki.util.Log;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

/**
 * @author JustReddy
 */
@Getter
public final class Client {

    private final Dotenv env;
    private final String token;
    private JDA client;
    private final Database database;

    public Client() {
        this.env = new DotenvBuilder()
                .directory("src/main/resources")
                .filename(".env")
                .load();
        this.token = env.get("BOT_TOKEN");
        this.database = new Database(env.get("MONGO_URI"));
    }

    public void connect() {
        // Connect to the bot
        Log.log(Color.translate("&b[REACTION-ROLES] &aConnecting to discord..."));
        client = JDABuilder.create(token, EnumSet.allOf(GatewayIntent.class))
                .build();
    }

    public void disconnect() {
        // TODO
    }

    public void registerListener(ListenerAdapter listenerAdapter) {
        client.addEventListener(listenerAdapter);
    }

}
