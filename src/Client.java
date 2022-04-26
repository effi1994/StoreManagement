public class Client extends  User {
  private boolean memberShip;
    public Client(String userName, String password, String lastName, String firstName, boolean memberShip ,ShoppingCart shoppingCart,float oldBill) {
        super(userName, password, lastName, firstName,shoppingCart,oldBill);
        this.memberShip = memberShip;
    }

    public boolean isMemberShip() {
        return memberShip;
    }

    public void myOldBill(float totalPrice){
        this.setOldBill(totalPrice);

    }

    @Override
    public String toString(){
        return "Hello"  + " { " + this.getFirstName() + " } "  + " { " + this.getLastName() + " } "
                + (this.isMemberShip() ? " (VIP)! ":" ! ");

    }
}
