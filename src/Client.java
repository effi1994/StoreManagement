public class Client extends  User {
  private boolean memberShip;
    public Client(String userName, String password, String lastName, String firstName, boolean memberShip) {
        super(userName, password, lastName, firstName);
        this.memberShip = memberShip;
    }

    public boolean isMemberShip() {
        return memberShip;
    }

    public void setMemberShip(boolean memberShip) {
        this.memberShip = memberShip;
    }

    /*public  boolean equals(Client other){
        boolean equals=false;
        if ((this.getUserName().equals(other.getUserName()))){
            equals=true;
        }
        return equals;
    }*/
}
