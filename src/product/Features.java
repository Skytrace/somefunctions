package product;

import java.util.*;

/**
 * Created by sobolev-a on 16.01.14.
 */

public class Features {

    private List<Product> list;
    private int numbersOfPage = 0;
    private int numberOfElementsPerPage = 8;
    private int numbersElementOnLastPage = 0;
    private boolean flag = false;

    public Features() {
        MakeObject product = new MakeObject();
        list = new ArrayList<>(product.getProduct());
        int listSize = list.size();
        numbersOfPage = listSize / numberOfElementsPerPage;
        numbersElementOnLastPage = listSize % numberOfElementsPerPage;
        if (numbersElementOnLastPage != 0) {
            numbersOfPage += 1;
            flag = true;
        }

    }

    public void showProducts() {
        int index = 0;
        for(Iterator<Product> p = list.iterator(); p.hasNext();) {
            index += 1;
            Product pp = p.next();
            System.out.println( index + " " + pp.getShop() + " " + pp.getPrice() + " " + pp.getProduct());
            if (index == numberOfElementsPerPage) break;
        }
    }

    public void showContentByPageNumber(int pageNumber) {
        int elements = pageNumber * numberOfElementsPerPage;
        int elementsResult = elements - numberOfElementsPerPage;
        int j;
        if (pageNumber <= numbersOfPage) {
            if (flag && pageNumber == numbersOfPage) numberOfElementsPerPage = numbersElementOnLastPage;
                for (int index = 0; index < numberOfElementsPerPage; index++) {
                    j = elementsResult++;
                    System.out.println(list.get(j).getProduct() + " " + list.get(j).getShop() + " " + list.get(j).getPrice());
                }
            }
         else {
            throw new IllegalArgumentException("Page does not exist");
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

        for (Iterator<Product> itr = sortListOfProductType.iterator(); itr.hasNext(); ) {
            Product p = itr.next();
            System.out.println(p.getProduct() + " " + p.getPrice());
        }
    }

    public void sortByLowPrice() {
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) return -1;
                if (o1.getPrice() == o2.getPrice()) return 0;
                return 1;
            }
        });
        showtopThreeProductPrice("low");
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
        showtopThreeProductPrice("high");
    }

    private void showtopThreeProductPrice(String param) {
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
