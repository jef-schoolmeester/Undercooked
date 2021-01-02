package user;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class User {

    protected MongoDatabase database;
    private String userName;

    public User() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        this.database = mongoClient.getDatabase("UndercookedDB");
        this.userName = "not connected";
    }

    public MongoCursor getUsers() {
        MongoCollection<Document> collection = database.getCollection("Users");
        FindIterable<Document> documents = collection.find();
        return documents.iterator();
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

    public ConnectedUser connectUser(String userName, String password) {
        return new ConnectedUser(userName, password);
    }

    public String getUserName() {
        return "None";
    }
    protected void setUserName(String userName) {
        this.userName =  userName;
    }




}
