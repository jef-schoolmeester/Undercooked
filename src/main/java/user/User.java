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
     */

    //Méthode générale difficile à faire fonctionner (besoin que l'auteur s'en occupe
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

    //Test d'une méthode plus ciblé vers Recipe
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

    public void mongoRecipeToList(String mongoObject) {
        mongoObject = mongoObject.substring(mongoObject.indexOf("name"));
        mongoObject = mongoObject.replaceAll("]}}", "");
        System.out.println(mongoObject);
    }

    public String getUserName() {
        return "None";
    }
    protected void setUserName(String userName) {
        this.userName =  userName;
    }

    public String getAccess() {
        return "user";
    }

}
