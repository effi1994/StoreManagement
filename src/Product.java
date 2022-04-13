public class Product {
    private String nameProduct;
    private int idProduct;
    private boolean inventory;
    private int productAmount;

    public Product (String nameProduct, int idProduct,boolean inventory,int productAmount ,int price,float discountPrice,int selectedProduct){
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.inventory = inventory;
        this.productAmount = productAmount;
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

    public void inventoryUpdate (int customerAmount){
        if (this.productAmount > 0){
            if ( this.productAmount >=customerAmount){
                this.selectedProduct = customerAmount;
                this.productAmount -= customerAmount;
            }
        }else {
            this.setInventory(false);
            System.out.println("This Item is out of stock!!!!");
        }

    }
}
