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

/**
 * Class that define an User through MongoDB database
 *
 * @author Jef
 * @since 1.0
 * @author Pierre
 * @since 2.0
 * @version 2.0
 */
public class User {

    protected MongoDatabase database;
    private String userName;

    /**
     * Constructor of User
     * Start a connexion with the database and set an artificial username
     */
    public User() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        this.database = mongoClient.getDatabase("UndercookedDB");
        this.userName = "not connected";
    }

    /**
     * Method that allow to browse the collection : "Users" in the Database
     * 
     * @return a MongoCursor of the documents in the collection
     */
    public MongoCursor getUsers() {
        MongoCollection<Document> collection = database.getCollection("Users");
        FindIterable<Document> documents = collection.find();
        return documents.iterator();
    }

    /**
     * Method that add an user as a document in the collection : "Users" in the Database
     * 
     * @param userName
     * @param password
     * @return a Boolean to catch possible errors
     */
    public boolean addUser(String userName, String password) {
        try {
            Document newUser = new Document("user_name", userName).append("password", password).append("access", "user");
            database.getCollection("Users").insertOne(newUser);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Method that connect a lambda user and change status of actual user
     *
     * @param userName
     * @param password
     * @return a ConnectedUser that will replace the actual User playing the game
     * @see sample.Main
     * @see ConnectedUser#ConnectedUser(String, String) 
     */
    public ConnectedUser connectUser(String userName, String password) {
        return new ConnectedUser(userName, password);
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     *
     * @param userName
     */
    protected void setUserName(String userName) {
        this.userName =  userName;
    }

    /**
     *
     * @return
     */
    public String getAccess() {
        return "user";
    }

}
