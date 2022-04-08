import com.sun.org.apache.xpath.internal.operations.Number;
import sun.applet.AppletAudioClip;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Store {
 private LinkedList<Client> clients;
 private  LinkedList<Employee> employees;
 private ArrayList<ShoppingCart>shoppingCarts;
 private ArrayList<Product> products;

    public Store() {
        this.clients = new LinkedList<>() ;
        this.employees = new LinkedList<>();
        this.shoppingCarts = new ArrayList<>();
        this.products = new ArrayList<>();
    }
    public void  createUser (){
        boolean nameNotNumbers=false;
        boolean strongPassword =false;
        Scanner scanner = new Scanner(System.in);
        String lastname = null ;
        String firstName= null ;
        String userName = null ;
        String password = null ;


            System.out.println("Which access you want to create Employee or Client?\n" +
                    "1.Create Employee\n" +
                    "2.Create Client ");
            int inputUser = scanner.nextInt();

            switch (inputUser){
                case 1:
                    do {
                        System.out.println("Enter first name: ");
                        firstName = scanner.next();
                        nameNotNumbers=this.checkIfTheNameIsNotNum(firstName);
                    }while (nameNotNumbers);

                    do {
                        System.out.println("Enter LastName");
                        lastname=scanner.next();
                        nameNotNumbers=this.checkIfTheNameIsNotNum(lastname);
                    }while (nameNotNumbers);
                    do {
                        System.out.println("Enter Pass for the user");
                        password = scanner.next();
                        strongPassword = this.checkIfStrongPassword(password);
                    }while (!strongPassword);
                    break;
                case 2:
                    break;
            }

    }

    private boolean checkIfTheNameIsNotNum(String name) {
        //
        for (int i = 0; i < name.length(); i++) {
            char check = name.charAt(i);
            if (Character.isDigit(check)){
                System.out.println("You able to insert only WORDS!!!");
                return true;
            }

        }
        return false;
    }
    private  boolean checkIfStrongPassword(String password){
       boolean strong = false;
       if (password.length()>= 6){
           strong = true;

       }
       return strong;
    }
}
