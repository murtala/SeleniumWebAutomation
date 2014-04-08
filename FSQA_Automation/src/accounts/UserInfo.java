package accounts;

/**
 * Created with IntelliJ IDEA.
 * User: madamou
 * Date: 11/14/13
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {

    public String userName;
    public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}