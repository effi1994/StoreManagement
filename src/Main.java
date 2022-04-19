import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        int userChoice;
        try {
            do {
                System.out.println("Choose  your action");
                System.out.println("1 - Sign up");
                System.out.println("2 - Sign in");
                System.out.println("3 - Exit");

                userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        store.createUser();
                        break;
                    case 2:
                        System.out.println("Do want tos sign-in as 1.Client\n 2.Employee");
                        int inputUser = scanner.nextInt();
                        switch (inputUser) {
                            case 1:
                                Client clientUser = store.clientLogin();
                                if (clientUser == null) {
                                    System.out.println("Wrong credentials!");
                                } else {
                                    System.out.println(clientUser + "\n");
                                    store.purchase(clientUser);

                                }
                                break;
                            case 2:
                                Employee employeeUser = store.employeeLogin();
                                if (employeeUser == null) {
                                    System.out.println("Wrong credentials!");
                                } else {
                                    System.out.println(employeeUser + "\n");
                                }
                                break;
                        }
                        break;
                    case 3:
                        break;
                }
            } while (userChoice != 3);
        }catch (Exception e){
            System.out.println("one numbers");
        }
    }
}
