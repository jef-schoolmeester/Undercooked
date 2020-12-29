package user;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class User {

    protected MongoDatabase database;
    private String lang = "en_name";

    public User() {
        //MongoClientURI uri = new MongoClientURI(
        //        "mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        //MongoClient mongoClient = new MongoClient(uri);
        //this.database = mongoClient.getDatabase("UndercookedDB");
    }

    public MongoCursor getUsers() {
        MongoCollection<Document> collection = database.getCollection("Users");
        FindIterable<Document> documents = collection.find();
        return documents.iterator();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
