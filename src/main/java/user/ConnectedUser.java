package user;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class ConnectedUser extends User{

    private String userName;
    private Document userDoc;

    public ConnectedUser(String userName) {
        super();
        this.userName = userName;
        this.userDoc = database.getCollection("Users").find(eq("user_name",this.userName)).first();
    }

    public String getUserName() {
        return userName;
    }

    public Document getUserDoc() {
        return userDoc;
    }
}
