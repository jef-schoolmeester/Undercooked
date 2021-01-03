package user;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * Class that define an User through MongoDB database
 *
 * @author Jef
 * @since 1.0
 * @author Pierre
 * @since 2.0
 * @author Yohann
 * @since 2.1
 *
 * @version 2.1
 */
public class User {

    protected MongoDatabase database;
    private String userName;
    private String lang;

    /**
     * Constructor of User
     * Start a connexion with the database and set an artificial username
     */
    public User(String lang) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        this.database = mongoClient.getDatabase("UndercookedDB");
        this.userName = "not connected";
        this.lang = lang;
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

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang(){
        return lang;
    }

    /**
     * Method that connect a lambda user and change status of actual user
     *
     * @see sample.Main
     * @see ConnectedUser#ConnectedUser(String, String, String)
     *
     * @param userName
     * @param password
     *
     * @return a ConnectedUser that will replace the actual User playing the game
     */
    public ConnectedUser connectUser(String userName, String password) {
        return new ConnectedUser(userName, password, this.lang);
    }

    /**
     *
     * @return
     *
     * @author Yohann
     */
    public static String[] triIngredients(String a){
        a = a.replaceAll("\"","");
        a = a.replaceAll("\\[","");
        a = a.replaceAll("\\]","");

        String phrase[] = a.split(" ,");
        for(int i=0;i< phrase.length;i++){
            System.out.println(phrase[i]);
        }

        return phrase;
    }

    /**
     * Query method, takes a collection, and 3 parameters to find an ingredient list
     * When the recipe is found, the method return a string
     *
     * @param collec
     * @param name
     * @param item1
     * @param item2
     * @return
     *
     * @author Yohann
     */
    public String query(String collec, String name, String item1, String item2) {
        DBCollection collection = (DBCollection) database.getCollection(collec);
        BasicDBObject searchQuery = new BasicDBObject();
        BasicDBObject search2 = new BasicDBObject();
        search2.put(item1,1);
        searchQuery.put(name, item2);
        DBCursor cursor = collection.find(searchQuery, search2);
        while (cursor.hasNext()) {
            BasicDBObject obj = (BasicDBObject) cursor.next();
            System.out.println(obj.getString(item1));
            return obj.getString(item1);
        }
        return "null";
    }

    /**
     * Test d'une méthode plus ciblé vers Recipe
     *
     * @deprecated until improvement
     * @see User#query(String, String, String, String)
     *
     * @author Jef
     */
    public void findRecipes() {
        MongoCollection<Document> collection = database.getCollection("Recipes");
        ArrayList<String> documentList = new ArrayList<>();
        FindIterable<Document> iterDoc = collection.find();
        Iterator iterator = iterDoc.iterator();
        while (iterator.hasNext()) {
            mongoRecipeToList(iterator.next().toString());
        }

        /*MongoCollection<Document> collection = database.getCollection("Recipes");
        MongoCursor<Document> cursor = collection.find(eq("name", recipeName)).iterator();
        while (cursor.hasNext()){
            return cursor.next().getString(listOfIngredientsName);
        }
        return "null";*/
    }

    /**
     * @see User#findRecipes()
     *
     * @param mongoObject
     *
     * @author Jef
     */
    public void mongoRecipeToList(String mongoObject) {
        mongoObject = mongoObject.substring(mongoObject.indexOf("name"));
        mongoObject = mongoObject.replaceAll("]}}", "");
        System.out.println(mongoObject);
    }

    /**
     * getter from userName attribute
     *
     * @return a UserName as a String from this User
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * setter of userName attribute
     * used on a ConnectedUser to set his Username
     *
     * @see ConnectedUser#ConnectedUser(String, String, String)
     *
     * @param userName
     */
    protected void setUserName(String userName) {
        this.userName =  userName;
    }

    /**
     * getter from access attribute
     * This one is artificial, set as "user" for all lambda users
     *
     * @return an Access as a String from this User
     */
    public String getAccess() {
        return "user";
    }

}
