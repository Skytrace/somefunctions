package product;

import collections.ProductModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by mac on 2/2/14.
 */
public class FeaturesHTML {

    Document doc;
    Elements product;
    String productName;
    ArrayList<ProductModel> products = null;


    public void getPageProducts() {
        products = new ArrayList<>();

        try {
            int a = 0;
            do {
                doc = Jsoup.connect(String.format("https://novus.zakaz.ua/ru/apple-juice/?&page=%s", a)).get();



                product = doc.getElementsByClass("one-product");
                String test = "as346fvgghfghy8";
                for (Element link : product) {
                    productName = link.select(".one-product-name").text();
                    productName = productName.replace("Сік", "Сок").replace("Напій", "Напиток").replace("Cік", "Сок");
                    products.add(new ProductModel(productName, Integer.parseInt(link.select(".grivna").text()), Integer.parseInt(link.select(".kopeiki").text().replace("[^0-9]", ""))));
                    System.out.print("");
                }
                a++;
            } while (a < 3);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showProductList() {
        int i = 1;
        Iterator<ProductModel> itr = products.iterator();
        while (itr.hasNext()) {
            ProductModel pm = itr.next();
            System.out.println(String.format("%s. %s %s,%s", i, pm.getBrand(), pm.getPrice(), pm.getCash()));
            i++;
        }
    }

}
