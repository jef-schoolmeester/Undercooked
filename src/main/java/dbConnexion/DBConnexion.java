package dbConnexion;

import com.mongodb.*;
/*
 * Database connexion class
 * contains a connexion method, a query method and a sorting ingredients method
 *
 * @author Yohann Markuc
 */
public class DBConnexion {

    /*
    Connexion to the database method
     */
    public static MongoClient connect(){
        MongoClientURI ConnectionString = new MongoClientURI("mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(ConnectionString);
        return mongoClient;
    }

    /*
    * Query method, takes a collection, and 3 parameters to find an ingredient list
    * When the recipe is found, the method return a string
     */
    public static String query(String collec, String name, String item1, String item2){
        DB database = connect().getDB("UndercookedDB");
        DBCollection collection = database.getCollection(collec);
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

    /*
    * Sorting method. Takes a string in parameter (string from the query method)
    * When the String is found, sorts a String table, each line is an ingredient
     */
    public static String[] triIngredients(String a){
        a = a.replaceAll("\"","");
        a = a.replaceAll("\\{","");
        a = a.replaceAll(":","=");
        a = a.replaceAll("\\}","");

        String phrase[] = a.split(" ,");

        int s = phrase.length;
        int nbIngredients = 0;
        switch (s){
            case 4:
                phrase[0] = phrase[0].replaceAll(" base = ","");
                phrase[1] = phrase[1].replaceAll(" sauce = ","");
                phrase[2] = phrase[2].replaceAll(" ing1 = ","");
                phrase[3] = phrase[3].replaceAll(" topping = ","");
                break;
            case 5:
                phrase[0] = phrase[0].replaceAll(" base = ","");
                phrase[1] = phrase[1].replaceAll(" sauce = ","");
                phrase[2] = phrase[2].replaceAll(" ing1 = ","");
                phrase[3] = phrase[3].replaceAll(" ing2 = ","");
                phrase[4] = phrase[4].replaceAll(" topping = ","");
                break;
            case 6:
                phrase[0] = phrase[0].replaceAll(" base = ","");
                phrase[1] = phrase[1].replaceAll(" sauce = ","");
                phrase[2] = phrase[2].replaceAll(" ing1 = ","");
                phrase[3] = phrase[3].replaceAll(" ing2 = ","");
                phrase[4] = phrase[4].replaceAll(" ing3 = ","");
                phrase[5] = phrase[5].replaceAll(" topping = ","");
                break;
        }
        for(int i=0;i< phrase.length;i++){
            System.out.println(phrase[i]);
        }
        return phrase;
    }

}
