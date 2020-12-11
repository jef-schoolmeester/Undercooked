package user;

import org.bson.Document;

public class Admin extends ConnectedUser{

    public Admin(String userName) {
        super(userName);
    }

    public boolean addAdmin(String userName, String password) {
        try {
            Document newUser = new Document("user_name", userName).append("password", password).append("access", "admin");
            database.getCollection("Users").insertOne(newUser);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
