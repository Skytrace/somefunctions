package product;

import java.util.*;

/**
 * Created by sobolev-a on 16.01.14.
 */

public class Features {

    private List<Product> list;

    public Features() {
        MakeObject product = new MakeObject();
        list = new ArrayList<>(product.getProduct());
    }

    public void showProducts() {

        for(Iterator<Product> p = list.iterator(); p.hasNext();) {
            Product pp = p.next();
            System.out.println(pp.getShop() + " " + pp.getPrice());
        }
    }

    public void showProductByLowPrice(String productType) {
        if (productType.equals(productType)) {
            sortByProductType(productType);
        }
    }

    public void sortByProductType(String productType) {
        List<Product> sortListOfProductType = new ArrayList<>();
        for (Iterator<Product> itr = list.iterator(); itr.hasNext();) {
            Product p = itr.next();
            if (p.getProduct().equals(productType)) {
                if (sortListOfProductType.size() == 3) break;
                sortListOfProductType.add(p);
            }
        }

    }

    public void sortByLowPrice(List<Product> lr) {
        Collections.sort(lr, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) return -1;
                if (o1.getPrice() == o2.getPrice()) return 0;
                return 1;
            }
        });
        showMostOfLowPrice("low");
    }

    public void sortByHighPrice() {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return -1;
                if (o1.getPrice() == o2.getPrice()) return 0;
                return 1;
            }
        });
        showMostOfLowPrice("high");
    }

    private void showMostOfLowPrice(String param) {
        System.out.println(String.format("3 top product of %s price", param));
        System.out.println(list.get(0).getShop() + " " + list.get(0).getProduct() + " " + list.get(0).getPrice());
        System.out.println(list.get(1).getShop() + " " + list.get(1).getProduct() + " " + list.get(1).getPrice());
        System.out.println(list.get(2).getShop() + " " + list.get(2).getProduct() + " " + list.get(2).getPrice());
    }

    public void displayShops() {
        Set<String> set = new HashSet<>();
        for (Iterator<Product> itr = list.iterator(); itr.hasNext();) {
            if(set.add(itr.next().getShop()))
                continue;
        }
        for (String result : set)
            System.out.println(result);
    }

}
