package collections;

/**
 * Created by mac on 2/24/14.
 */
public class ProductModel {

    private String brand = null;
    private Double volume = 0.0;
    private Integer price = 0;
    private Integer cash = 0;

    public ProductModel(String bBrand, Integer pPrice, Integer cash) {
        this.brand = bBrand;
        this.price = pPrice;
        this.cash = cash;
    }

    public String getBrand() {
        return this.brand;
    }

    public Double getVolume() {
        return this.volume;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getCash() {
        return this.cash;
    }




}
