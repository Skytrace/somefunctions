package product;

/**
 * Created by sobolev-a on 13.01.14.
 */
public class Product {

    public Product(String sShop, String pProduct, double pPrice) {
        this.shop = sShop;
        this.product = pProduct;
        this.price = pPrice;
    }

    public Product() {}

    private String shop;
    private String product;
    private Double price;

    public String getShop() {
        return shop;
    }
    public String getProduct() { return product; }
    public double getPrice() {
        return price;
    }

}
