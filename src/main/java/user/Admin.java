package user;

import org.bson.Document;

/**
 * Class that define an Admin through MongoDB database
 * Inherited from ConnectedUser
 *
 * @author Jef
 * @since 1.0
 * @author Pierre
 * @since 2.0
 * @version 2.0
 */
public class Admin extends ConnectedUser{


    /**
     * Constructor that allow a connexion to an existent user as admin from the database
     * @see ConnectedUser#ConnectedUser(String, String)
     *
     * @param userName
     * @param password
     */
    public Admin(String userName, String password) {
        super(userName, password);
        //super.userDoc.replace("access", "user", "admin");
        //super.access = super.userDoc.getString("access");
    }

    /**
     * Method that add an user with admin access as a document in the collection : "Users" in the Database
     *
     * @param userName
     * @param password
     * @return a Boolean to catch possible errors
     */
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
