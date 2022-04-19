public class Product {
    private String nameProduct;
    private int idProduct;
    private boolean inventory;
    private int productAmount;
    private  int price;
    private float discountPrice;
    private int selectedProduct;

    public Product (String nameProduct, int idProduct,boolean inventory,int productAmount ,int price,float discountPrice,int selectedProduct){
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.inventory = inventory;
        this.productAmount = productAmount;
        this.price= price;
        this.discountPrice = discountPrice/Finals.PERCENTAGE;
        this.selectedProduct=0;
    }



    public String toString(){

        return (this.isInventory()? "Name: " + this.getNameProduct() + "\n" +
                "ProductID: "  + this.getIdProduct() : "out of inventory");

    }
    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public boolean isInventory() {
        return inventory;
    }

    public void setInventory(boolean inventory) {

        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice/Finals.PERCENTAGE;
    }

    public int getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(int selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product inventoryUpdate (int customerAmount, Product product){
        if (this.getProductAmount() > 0){
            if ( this.getProductAmount() >=customerAmount){
                this.setSelectedProduct(this.getSelectedProduct() + customerAmount);
                product.setSelectedProduct(this.getSelectedProduct());
                this.setProductAmount(this.getProductAmount()-customerAmount);
                if (this.getProductAmount()==0){
                    this.setInventory(false);
                    System.out.println("you took the last product ");
                }
            }
        }

     return product;
    }

    public boolean maxProductAmount(int customerAmount){
        boolean between = true;
        if (this.getProductAmount() < customerAmount){
             between = false;
        }
        System.out.println(between?
                "This is the amount that remaining from this product : " + this.getProductAmount() :
                "you cannot get more this item : " + this.getProductAmount());
        return between;
    }



}
