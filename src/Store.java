
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Store {
 private LinkedList<Client> clients;
 private  LinkedList<Employee> employees;
 private ArrayList<Product> products;
 private Integer indexProduct=null;
 private  Employee selectEmployee=null;

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


    public Integer getIndexProduct() {
        return indexProduct;
    }

    public void setIndexProduct(Integer indexProduct) {
        this.indexProduct = indexProduct;
    }

    public Employee getSelectEmployee() {
        return selectEmployee;
    }

    public void setSelectEmployee(Employee selectEmployee) {
        this.selectEmployee = selectEmployee;
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
                    boolean memberShip = answer.equals("yes");
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
        ShoppingCart shoppingCart = new ShoppingCart();
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
                            shoppingCart.setProducts(products.get(indexProduct).
                                    inventoryUpdate(selectProduct, this.products.get(this.getIndexProduct())));
                            if (client !=null){

                                totalPrice = shoppingCart.totalPriceClient(client.isMemberShip());
                                client.setShoppingCart(shoppingCart);
                            }else {
                                totalPrice = shoppingCart.totalPriceShopping(this.getSelectEmployee().getEmployeeLevel());
                                this.getSelectEmployee().setShoppingCart(shoppingCart);
                            }

                        }
                }else {
                    System.out.println("not exist");
                }
            } else {
                boolean exit = selectProduct != -1;
                System.out.println(exit ? "insert only positive numbers":" End of shopping");
            }

        }while (selectProduct != -1);
        shoppingCart.setLastDatePurchase(shoppingCart.setNewTheLastDatePurchase());
        if (client!=null){
            client.setShoppingCart(shoppingCart);
            client.myOldBill(totalPrice);
            client.getShoppingCart().resetProduct();
            System.out.println("Total Shopping : " + totalPrice);
        }else {
            this.getSelectEmployee().setShoppingCart(shoppingCart);
            this.getSelectEmployee().myOldBill(totalPrice);
            this.getSelectEmployee().getShoppingCart().resetProduct();
            System.out.println("Total Shopping : " + totalPrice);
        }


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
       return isExist;
    }




//
    public void menuEmployee(Employee employee){
        float totalPrice=0;
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCartClient = new ShoppingCart();
        int selectProduct=0;
        int inputEmployee=0;
        do {
            System.out.println("1-Print a list of all customers. \n" +
                               "2-Print the list of customer members in the club only. \n" +
                                "3-Print the list of customers who have made at least one purchase. \n" +
                                "4-Print the customer whose purchase amount is the highest. \n" +
                                 "5-Adding a new product to the store. \n" +
                                 "6-Change inventory status for product. \n " +
                                 "7-Making a purchase. \n" +
                                 "8- Exit");
            inputEmployee = scanner.nextInt();
            if (inputEmployee >0){
                if (inputEmployee <=4){
                    printClients(inputEmployee);
                }else {
                    switch (inputEmployee){
                        case Finals.ADD_PRODUCT:
                            addNewProduct();
                            break;
                        case Finals.STATUS_PRODUCT:
                            StatusInventory ();
                            break;
                        case Finals.PURCHASE:
                            this.setSelectEmployee(employee);
                            purchase(null);
                            break;
                    }
                }
            }else {
                System.out.println("Please input only positive numbers");
            }



        }while (inputEmployee !=8);
    }

    public void printClients(int inputEmployee){
        int clientNumber = 1;
        Client clientHighestRate = new Client("","","","",false,null,0);
        for (Client client : this.clients) {
            switch (inputEmployee) {
                case Finals.PRINT_ALL_CLIENT:
                    System.out.println(clientNumber + " : " + client);
                    break;

                case Finals.PRINT_MEMBERSHIP:
                    if (client.isMemberShip()) {
                        System.out.println(clientNumber + " : " + client);
                    }
                    break;


                case Finals.PRINT_CLIENT_AT_LEAST_BUYING_ONE:
                    if (client.getOldBill() >0){
                        System.out.println(clientNumber + " : " + client);
                    }
                    break;
                case Finals.PRINT_HIGHEST_PURCHASE:

                    if (client.getOldBill() > clientHighestRate.getOldBill()){
                        clientHighestRate=client;
                    }
                    break;
            }
            clientNumber++;
        }
        if (inputEmployee==Finals.PRINT_HIGHEST_PURCHASE)
            System.out.println(clientHighestRate);

    }

    public void addNewProduct (){
        Scanner scanner = new Scanner(System.in);
        String nameProduct = "";
        int idProduct =0;
        int productAmount =0;
        float price =0;
        float discountPrice = 0;
        boolean checkId=false;
        System.out.println("enter name product :");
        nameProduct = scanner.next();
        do{
            System.out.println("enter id product :");
            idProduct = scanner.nextInt();
            checkId=this.checkIsExistProduct(idProduct);
            System.out.println(checkId? "this id is exist" : "add id");
        }while (checkId);

        System.out.println("enter product amount");
        productAmount = scanner.nextInt();
        System.out.println("enter price");
        price = scanner.nextFloat();
        System.out.println("enter discountPrice");
        discountPrice = scanner.nextFloat();
        Product newProduct = new Product(nameProduct,idProduct,
                                true,productAmount,price,discountPrice,0);
        this.products.add(newProduct);
        System.out.println("add successfully");
    }

    public void  StatusInventory (){
        int selectProduct=0;
        String inventoryProduct = "";
        Scanner scanner = new Scanner(System.in);

        printProduct();
        System.out.println("Select a Product id");
        selectProduct=scanner.nextInt();
        checkIsExistProduct(selectProduct);
        System.out.println("enter if the product exist y/n");
       inventoryProduct=scanner.next();
       this.products.get(this.getIndexProduct()).setInventory(inventoryProduct.equals("y"));
    }



}
