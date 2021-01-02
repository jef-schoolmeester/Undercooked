package user;

import org.bson.Document;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ConnectedUser extends User{

    protected Document userDoc;
    private String password;
    protected String access;

    public ConnectedUser(String userName, String password) {
        super();
        super.setUserName(userName);

        this.userDoc = database.getCollection("Users").find(and(eq("user_name", userName), eq("password", password))).first();

        this.password = userDoc.getString("password");
        this.access = userDoc.getString("access");
    }

    public Document toDocument(){
        return new Document("user_name", super.getUserName()).append("password", this.password).append("access", this.access);
    }

    public boolean isConnected(){
        if (this.userDoc.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Document getUserDoc() { return userDoc; }

    public String getUserName(){
        return userDoc.getString("user_name");
    }

    @Override
    public String getAccess() {
        return this.access;
    }
}
