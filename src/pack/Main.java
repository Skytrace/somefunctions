package pack;

import product.Features;

/**
 * Created with IntelliJ IDEA.
 * User: sobolev-a
 * Date: 17.12.13
 * Time: 11:05
 */

public class Main {
    static Features f;

    public static void main(String[] args) {

        f = new Features();
        Steps steps = new Steps();
        steps.showAllProductsOnLowPrice();

    }


    static class Steps {

        public void showAllProducts() {
            f.showProducts();
        }

        public void showAllShops() {
            f.displayShops();
        }

        public void showMostOfLowPriceProduct() {
            f.sortByProductType("candys");
        }

        public void showAllProductsOnLowPrice() {
            f.sortByLowPrice();
        }

    }

}
