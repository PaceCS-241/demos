import java.util.ArrayList;
import java.util.Arrays;

public class SortProducts {
    public static void main(String[] args) {
        System.out.println();
        ArrayList<Product> shoppingCart = new ArrayList<>();

        shoppingCart.add(new Product("Earbuds", 76.99, 50, 6.3, 2.2));
        shoppingCart.add(new Product("Dog Treats", 24.99, 450, 25, 18));

        // print original list
        System.out.println(Arrays.toString(shoppingCart.toArray()));
    }
}

class Product implements Comparable<Product>{
    String productName;
    Double productPrice;
    Double productWeight;
    Double productLength;
    Double productHeight;

    public Product(String name, double price, double weight, double length, double height) {
        productName = name;
        productPrice = price;
        productWeight = weight;
        productLength = length;
        productHeight = height;
    }

    @Override
    public int compareTo(Product o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public String toString() {
        return String.format("\n%s: $%.02f (Dimensions: %.1f x %.1f) (%.1f g)", 
            productName, productPrice, productLength, productHeight, productWeight);
    }
}