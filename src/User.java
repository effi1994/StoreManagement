import com.sun.imageio.stream.StreamFinalizer;

public class User {
  private String userName;
  private String password;
  private String lastName;
  private String firstName;
  private  ShoppingCart shoppingCart;

    public User(String userName, String password, String lastName, String firstName,ShoppingCart shoppingCart) {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.shoppingCart=null;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


 // private Employee employee;



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
