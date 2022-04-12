public class Employee extends User{
  private Attribute EmployeeLevel;

  public Employee(String userName, String password, String lastName, String firstName, Attribute employeeLevel) {
    super(userName, password, lastName, firstName);
    EmployeeLevel = employeeLevel;
  }

  public Attribute getEmployeeLevel() {
    return EmployeeLevel;
  }

  public void setEmployeeLevel(Attribute employeeLevel) {
    EmployeeLevel = employeeLevel;
  }

  @Override
  public String toString(){
    return "Hello"  + " { " + this.getFirstName() + " } "  + " { " + this.getLastName() + " } "
            + this.getEmployeeLevel();
  }
}
