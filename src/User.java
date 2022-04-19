import com.sun.imageio.stream.StreamFinalizer;

public class User {
  private String userName;
  private String password;
  private String lastName;
  private String firstName;
  private  ShoppingCart shoppingCart;
  private float oldBill;

    public User(String userName, String password, String lastName, String firstName,ShoppingCart shoppingCart,float oldBill) {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.shoppingCart=shoppingCart;
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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

    public float getOldBill() {
        return oldBill;
    }

    public void setOldBill(float oldBill) {
        this.oldBill += oldBill;
    }


}
