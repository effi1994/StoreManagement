import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;
    private String lastDatePurchase;
    private int amountOfPurchase;
    private float totalPrice;


    public ShoppingCart (String lastDatePurchase,int amountOfPurchase,float totalPrice ){

        this.lastDatePurchase = lastDatePurchase;
        this.amountOfPurchase = amountOfPurchase;
        this.totalPrice = totalPrice;
        this.products= new ArrayList<>();
    }

    public ShoppingCart(){
        this.products=new ArrayList<>();
    }



    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        if (!this.checkDoubleOfProducts(product)){
            this.products.add(product);
        }

    }

    public String getLastDatePurchase() {
        return lastDatePurchase;
    }

    public void setLastDatePurchase(String lastDatePurchase) {
        this.lastDatePurchase = lastDatePurchase;
    }

    public int getAmountOfPurchase() {
        return amountOfPurchase;
    }

    public void setAmountOfPurchase(int amountOfPurchase) {
        this.amountOfPurchase = amountOfPurchase;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float totalPriceClient(boolean isMemberShip) {
        float total=0;
        this.setTotalPrice(0);
        if (isMemberShip){
            for (int i = 0; i < this.getProducts().size(); i++) {
                float totalProduct=0;
                float sum = this.products.get(i).getPrice()
                        *this.products.get(i).getSelectedProduct();
                totalProduct=sum - (sum *this.products.get(i).getDiscountPrice());
                total += sum - (sum *this.products.get(i).getDiscountPrice());
                System.out.println(this.getProducts().get(i) + "\n"
                        + this.getProducts().get(i).getSelectedProduct() + "\n"
                        + "price: "  + totalProduct);
            }
            this.setTotalPrice(total);
            System.out.println("This total price of Products : " + this.getTotalPrice());

        }else {
            this.totalPrice=this.totalPrice();
        }

        return this.totalPrice;
    }

    public float totalPriceEmployee(Attribute level){
        switch (level){
            case REGULAREMPLOYEE:
                this.totalPrice= this.totalPrice()-(this.totalPrice()*Finals.EMPLOYEE);
                break;
            case MANGER:
                this.totalPrice= this.totalPrice()-(this.totalPrice()*Finals.MANGER);
                break;
            case MEMEBROFMANGEMENTTEAM:
                this.totalPrice= this.totalPrice()
                        -(this.totalPrice()*Finals.MEMEBR_OF_MANGEMENT_TEAM);
                break;
        }
        return this.totalPrice;
    }

    public float totalPrice(){
        int total=0;
        this.setTotalPrice(0);
        for (int i = 0; i < this.getProducts().size(); i++) {
             total+=this.products.get(i).getPrice()
                     *this.products.get(i).getSelectedProduct();
                   System.out.println(this.getProducts().get(i) + "\n"
                    + this.getProducts().get(i).getSelectedProduct());
        }
        this.setTotalPrice(total);
        System.out.println(this.getTotalPrice());
        return this.getTotalPrice();
    }

    public boolean checkDoubleOfProducts(Product product){
        boolean isExist=false;
        for (int i = 0; i < this.getProducts().size(); i++) {
            if (this.getProducts().get(i).getIdProduct()==product.getIdProduct()){
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public String setNewTheLastDatePurchase(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    public  void  resetProduct (){
        for (int i = 0; i < this.getProducts().size(); i++) {
            this.getProducts().get(i).setSelectedProduct(0);
        }

    }

//
}
