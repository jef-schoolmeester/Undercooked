package database.users;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class UserRequest {

    protected MongoDatabase database;


    public UserRequest() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://udUser:EFBDrRdeE8QAG1lU@cluster0-shard-00-00.wcngd.mongodb.net:27017,cluster0-shard-00-01.wcngd.mongodb.net:27017,cluster0-shard-00-02.wcngd.mongodb.net:27017/<dbname>?ssl=true&replicaSet=atlas-ofie07-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        this.database = mongoClient.getDatabase("UndercookedDB");
    }
}
