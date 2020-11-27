package database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseRequest {

    protected MongoDatabase database;

    public DatabaseRequest() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        this.database = mongoClient.getDatabase("UndercookedDB");
    }

    /*public MongoDatabase getDatabase() {
        return this.database;
    }*/

    public boolean addAdmin(String userName, String password) {
        try {
            Document newUser = new Document("user_name", userName).append("password", password).append("access", "admin");
            database.getCollection("Users").insertOne(newUser);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean addUser(String userName, String password) {
        try {
            Document newUser = new Document("user_name", userName).append("password", password).append("access", "user");
            database.getCollection("Users").insertOne(newUser);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public MongoCursor getUsers() {
        MongoCollection<Document> collection = database.getCollection("Users");
        FindIterable<Document> documents = collection.find();
        return documents.iterator();
    }
}
