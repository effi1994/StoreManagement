import com.sun.imageio.stream.StreamFinalizer;

public class User {
  private String userName;
  private String password;
  private String lastName;
  private String firstName;
 // private Employee employee;

    public User(String userName, String password, String lastName, String firstName) {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

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
