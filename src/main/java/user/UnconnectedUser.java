package user;

import org.bson.Document;

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
}
