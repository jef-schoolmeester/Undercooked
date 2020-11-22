package dbTest;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

public class test {

    static Consumer<Document> printConsumer = new Consumer<>() {
        @Override
        public void accept(final Document document) {
            System.out.println(document.toJson());
        }
    };

    public static void main(String[] args) {
        System.out.println("OUI");
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("atests");
        collection.find().forEach(printConsumer);
    }
}
