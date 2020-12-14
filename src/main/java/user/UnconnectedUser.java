package user;

import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class UnconnectedUser extends User {

    public UnconnectedUser() {
        super();
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
/*
    public ConnectedUser connectUser(String userName, String password) {
        ConnectedUser existentUser = new ConnectedUser(userName);
        Document userDoc = existentUser.getUserDoc();
        if( userDoc.getString("password") == password){
            System.out.println("stylé ton mot de passe :" + userDoc.getString("password") + "\n comparé à" + password);
            return existentUser ;
        }else{
            return null;
        }
    }
*/
}
