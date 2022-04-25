public class Employee extends User{
  private Attribute EmployeeLevel;

  public Employee(String userName, String password, String lastName, String firstName,
                  Attribute employeeLevel,ShoppingCart shoppingCart,float oldBill) {
    super(userName, password, lastName, firstName,shoppingCart,oldBill);
    EmployeeLevel = employeeLevel;
  }
////
  public Attribute getEmployeeLevel() {
    return EmployeeLevel;
  }

  public void setEmployeeLevel(Attribute employeeLevel) {
    EmployeeLevel = employeeLevel;
  }
  public void myOldBill(float totalPrice){
    this.setOldBill(totalPrice);

  }

  @Override
  public String toString(){
    return "Hello"  + " { " + this.getFirstName() + " } "  + " { " + this.getLastName() + " } "
            + this.getEmployeeLevel();
  }
}
