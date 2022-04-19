import com.sun.org.apache.xpath.internal.operations.Number;
import sun.applet.AppletAudioClip;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Store {
 private LinkedList<Client> clients;
 private  LinkedList<Employee> employees;
 private ArrayList<Product> products;
 private Integer indexProduct=null;

    public Store() {
        this.clients = new LinkedList<>() ;
        this.employees = new LinkedList<>();
        this.products = new ArrayList<>();
        Product product1=new Product("milk",
                0001,true,10,
                5,0,0);
        Product product2=new Product(" Turkish-Coffe",
                0002,true,5,
                5,2,0);
        Product product3 = new Product("Arak",0003,
                true,10,100,0, 0);
        this.products.add(product1);
        this.products.add(product2);
        this.products.add(product3);
    }
    public void  createUser (){
        boolean nameNotNumbers=false;
        boolean strongPassword =false;
        boolean userNameTaken=false;
        Scanner scanner = new Scanner(System.in);
        String lastname = null ;
        String firstName= null ;
        String userName = null ;
        String password = null ;


            System.out.println("Which access you want to create Employee or Client?\n" +
                    "1.Create Client\n" +
                    "2.Create Employee ");
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
                    do{
                        System.out.println("Enter username:");
                        userName = scanner.next();
                        userNameTaken = this.doesClientUserNameExist(userName);
                    }while(userNameTaken);

                    do {
                        System.out.println("Enter Pass for the user");
                        password = scanner.next();
                        strongPassword = this.checkIfStrongPassword(password);
                    }while (!strongPassword);

                    System.out.println("Are you Membership of our company ?");
                    String answer=scanner.next();
                    boolean memberShip =false;
                    if (answer.equals("yes")){
                       memberShip=true;
                    }
                    Client newClient= new Client(userName,password,lastname,firstName,memberShip,null,0);
                    clients.add(newClient);
                    break;
                case 2:
                    Attribute typeOfEmployee=null;
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
                    do{
                        System.out.println("Enter username:");
                        userName = scanner.next();
                        userNameTaken = this.doesClientUserNameExist(userName);
                    }while(userNameTaken);

                    do {
                        System.out.println("Enter Pass for the user");
                        password = scanner.next();
                        strongPassword = this.checkIfStrongPassword(password);
                    }while (!strongPassword);
                    System.out.println("Wich kind of user are you\n" +
                            "(1.REGULAREMPLOYEE,\n" +
                            " 2.MANGER,\n" +
                            "  3.MEMEBROFMANGEMENTTEAM)");

                   int userLevel=scanner.nextInt();


                    switch (userLevel){
                        case 1:
                            typeOfEmployee=Attribute.REGULAREMPLOYEE;
                            break;
                        case 2:
                            typeOfEmployee=Attribute.MANGER;
                            break;
                        case 3:
                            typeOfEmployee = Attribute.MEMEBROFMANGEMENTTEAM;
                            break;
                    }
                   Employee newEmployee= new Employee(userName,password,lastname,firstName,typeOfEmployee,null,0);
                    employees.add(newEmployee);

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
       boolean strong = true;
       if (password.length()< 6){
           strong = false;
           System.out.println("The password need to be at least 6 notes");
       }
       return strong;
    }
    private boolean doesClientUserNameExist(String usernameToCheck) {
        boolean exitsClient = false;
        boolean  exitsEmployee =false;
            for (Client currentUser : this.clients) {
                if (currentUser.getUserName().equals(usernameToCheck)) {
                    exitsClient = true;
                    System.out.println("This user name exist please choose another 1");
                    break;
                }
            }

            for (Employee currentUser : this.employees) {
                if (currentUser.getUserName().equals(usernameToCheck)) {
                    exitsEmployee = true;
                    System.out.println("This user name exist please choose another 1");
                    break;
                }
            }

        return exitsEmployee||exitsClient;
    }

    public Client clientLogin(){
        Scanner scanner = new Scanner(System.in);
        String userName = null;
        String password = null;
        Client userClient=null;
        System.out.println("Enter your username");
        userName=scanner.next();
        System.out.println("Enter your password");
        password=scanner.next();
        for (Client currentRegister : this.clients) {
            if (currentRegister.getUserName().equals(userName)
                    && currentRegister.getPassword().equals(password)) {
                        userClient = currentRegister;
                        break;
                    }
                }
                return userClient;
    }


    public Employee employeeLogin() {
        Scanner scanner = new Scanner(System.in);
        String userName = null;
        String password = null;
        Employee userEmployee = null;
        System.out.println("Enter your username");
        userName=scanner.next();
        System.out.println("Enter your password");
        password=scanner.next();
        for (Employee currentRegister : this.employees) {
            if (currentRegister.getUserName().equals(userName) &&
                    currentRegister.getPassword().equals(password)) {
                userEmployee = currentRegister;
                break;
            }
        }
        return userEmployee;
    }
    public void purchase(Client client){

        float totalPrice=0;
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCartClient = new ShoppingCart();
        int selectProduct;
        do {
            this.printProduct();
            System.out.println("Select a Product \n" +
                    "or insert -1 for exist the purchase ");
            selectProduct = scanner.nextInt();
            if (selectProduct >0){
                if (this.checkIsExistProduct(selectProduct)){
                        System.out.println("how much you want to buy from this product?");
                        selectProduct = scanner.nextInt();
                        if (products.get(this.getIndexProduct()).maxProductAmount(selectProduct)){
                            shoppingCartClient.setProducts(products.get(indexProduct).inventoryUpdate(selectProduct, this.products.get(this.getIndexProduct())));
                            totalPrice = shoppingCartClient.totalPriceClient(client.isMemberShip());
                            client.setShoppingCart(shoppingCartClient);
                        }
                }
            } else {
                boolean exit = selectProduct != -1;
                System.out.println(exit ? "insert only positive numbers":" End of shopping");
            }

        }while (selectProduct != -1);
        shoppingCartClient.setLastDatePurchase(shoppingCartClient.setNewTheLastDatePurchase());
        client.setShoppingCart(shoppingCartClient);
        client.myOldBill(totalPrice);
        client.getShoppingCart().resetProduct();
        System.out.println("Total Shopping : " + totalPrice);

    }



    private void printProduct(){
        for (Product product : this.products) {
            if (product.isInventory()){
                System.out.println(product);
            }

        }
    }


    private  boolean  checkIsExistProduct (int productId){
        boolean isExist=false;
        this.setIndexProduct(0);
        int conterIndex=0;
        for (Product product : this.products) {
            if (product.getIdProduct() == productId) {
                isExist = true;
                break;
            }
            conterIndex++;
            this.setIndexProduct(conterIndex);
        }
        System.out.println(isExist ?
                "is exist" : "not exist");
       return isExist;
    }


    public Integer getIndexProduct() {
        return indexProduct;
    }

    public void setIndexProduct(Integer indexProduct) {
        this.indexProduct = indexProduct;
    }
}
