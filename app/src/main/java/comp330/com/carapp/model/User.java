package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 3/31/16.
 */
public class User {
    private String username;
    private String password;
    private String imageURL;

    public void setUsername (String username) {
        this.username = username;
    }
    public String getUsername() { return username; }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() { return password; }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getImageURL() { return imageURL; }
}
