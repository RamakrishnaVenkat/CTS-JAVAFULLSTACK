// SearchAlgorithms.java
import java.util.List;

public class SearchAlgorithms {

    // Linear search
    public static Product linearSearch(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search (requires sorted array)
    public static Product binarySearch(List<Product> products, String productName) {
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = products.get(middle).getProductName().compareToIgnoreCase(productName);

            if (comparison == 0) {
                return products.get(middle);
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null;
    }
}
