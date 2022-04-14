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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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
        if (isMemberShip){
            for (int i = 0; i < this.getProducts().size(); i++) {
                float sum = this.products.get(i).getPrice()
                        *this.products.get(i).getSelectedProduct();
                this.totalPrice += sum - (this.products.get(i).getPrice()
                        *this.products.get(i).getDiscountPrice()
                        *this.products.get(i).getSelectedProduct());
                System.out.println(this.getProducts().get(i) + "\n"
                        + this.getProducts().get(i).getSelectedProduct() + "\n"
                        + this.totalPrice);
            }
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
                        -(this.totalPrice()*Finals.MEMEBROFMANGEMENTTEAM);
                break;
        }
        return this.totalPrice;
    }

    public float totalPrice(){
        for (int i = 0; i < this.getProducts().size(); i++) {
            this.totalPrice += this.products.get(i).getPrice()
                    *this.products.get(i).getDiscountPrice()
                    *this.products.get(i).getSelectedProduct();
                   System.out.println(this.getProducts().get(i) + "\n"
                    + this.getProducts().get(i).getSelectedProduct() + "\n"
                    + this.totalPrice);
        }
        return this.totalPrice;
    }


}
