// SortOrders.java
import java.util.ArrayList;
import java.util.List;

public class SortOrders {
    public static void main(String[] args) {
        // Create a list of orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Alice", 250.0));
        orders.add(new Order("2", "Bob", 150.0));
        orders.add(new Order("3", "Charlie", 300.0));
        orders.add(new Order("4", "Diana", 200.0));

        // Print unsorted orders
        System.out.println("Unsorted Orders:");
        orders.forEach(System.out::println);

        // Apply Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("\nOrders Sorted with Bubble Sort:");
        orders.forEach(System.out::println);

        // Recreate list for Quick Sort
        orders.clear();
        orders.add(new Order("1", "Alice", 250.0));
        orders.add(new Order("2", "Bob", 150.0));
        orders.add(new Order("3", "Charlie", 300.0));
        orders.add(new Order("4", "Diana", 200.0));

        // Apply Quick Sort
        QuickSort.quickSort(orders, 0, orders.size() - 1);
        System.out.println("\nOrders Sorted with Quick Sort:");
        orders.forEach(System.out::println);
    }
}
