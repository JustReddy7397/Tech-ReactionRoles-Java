package ga.justreddy.wiki.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * @author JustReddy
 */
public class Database {

    private final MongoClientSettings settings;

    public Database(String uri) {
        final ConnectionString connectionString =
                new ConnectionString(uri);
        final CodecRegistry codecRegistry =
                CodecRegistries.fromProviders(PojoCodecProvider.builder()
                        .automatic(true).build(),
                        MongoClientSettings.getDefaultCodecRegistry());
        this.settings =
                MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .codecRegistry(codecRegistry)
                        .build();
    }

    public MongoClient getMongoClient() {
        return MongoClients.create(settings);
    }

    public MongoDatabase getDatabase() {
        try (MongoClient mongoClient = getMongoClient()) {
            return mongoClient.getDatabase("reactionroles");
        }
    }

}
