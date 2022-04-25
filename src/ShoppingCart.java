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
                System.out.println(this.getProducts().get(i) + "\n" + "Amount : "
                        + this.getProducts().get(i).getSelectedProduct() + "\n"
                        + "price: "  + totalProduct);
            }
            this.setTotalPrice(total);
            System.out.println("This total price of Products : " + this.getTotalPrice());

        }else {
            this.totalPrice=this.totalPriceShopping(Attribute.CLIENT);
        }

        return this.totalPrice;
    }


    public float totalPriceShopping(Attribute level){
        float total=0;
        float sum=0;
        float totalPriceProduct=0;
        this.setTotalPrice(0);
        for (Product product : this.products) {
            switch (level){
                case CLIENT:
                    totalPriceProduct=product.getPrice()*product.getSelectedProduct();
                    total+=totalPriceProduct;

                    break;

                case REGULAREMPLOYEE:
                    sum=(product.getPrice()*product.getSelectedProduct())*(Finals.EMPLOYEE);
                    totalPriceProduct=product.getPrice()*product.getSelectedProduct()-sum;
                    total+=totalPriceProduct;
                    break;
                case MANGER:
                    sum=(product.getPrice()*product.getSelectedProduct())*(Finals.MANGER);
                    totalPriceProduct=product.getPrice()*product.getSelectedProduct()-sum;
                    total+=totalPriceProduct;
                    break;
                case MEMEBROFMANGEMENTTEAM:
                    sum=(product.getPrice()*product.getSelectedProduct())*(Finals.MEMEBR_OF_MANGEMENT_TEAM);
                    totalPriceProduct=product.getPrice()*product.getSelectedProduct()-sum;
                    total+=totalPriceProduct;
                    break;
            }
            System.out.println(product + "\n" + "Amount : " +
                    product.getSelectedProduct() + "\n" +
                     "Total Price Product : "   + totalPriceProduct);

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
