// EcommercePlatformSearch.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EcommercePlatformSearch {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Laptop", "Electronics"));
        products.add(new Product("2", "Smartphone", "Electronics"));
        products.add(new Product("3", "Tablet", "Electronics"));
        products.add(new Product("4", "TV", "Electronics"));
        products.add(new Product("5", "Headphones", "Accessories"));

        // Linear search
        Product foundProduct = SearchAlgorithms.linearSearch(products, "Tablet");
        System.out.println("Linear Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));

        // Sort the products by productName for binary search
        Collections.sort(products, Comparator.comparing(Product::getProductName));

        // Binary search
        foundProduct = SearchAlgorithms.binarySearch(products, "Tablet");
        System.out.println("Binary Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));
    }
}
