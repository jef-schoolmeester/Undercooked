package user;

import org.bson.Document;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * Class that define a Connected User through MongoDB database
 * Inherited from User
 * @see user.User
 *
 * @author Jef
 * @since 1.0
 * @author Pierre
 * @since 2.0
 * @version 2.0
 */
public class ConnectedUser extends User{

    protected Document userDoc;
    private String password;
    protected String access;

    /**
     * Constructor that allow a connexion to an existent user from the database
     * Also define an User access
     *
     * @param userName
     * @param password
     */
    public ConnectedUser(String userName, String password) {
        super();
        super.setUserName(userName);

        this.userDoc = database.getCollection("Users").find(and(eq("user_name", userName), eq("password", password))).first();

        this.password = userDoc.getString("password");
        this.access = userDoc.getString("access");
    }

    /**
     * Create an User Document from a Java User
     * <i>Never Used</i>
     * @return a Document created with UserConnected attributes
     */
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
