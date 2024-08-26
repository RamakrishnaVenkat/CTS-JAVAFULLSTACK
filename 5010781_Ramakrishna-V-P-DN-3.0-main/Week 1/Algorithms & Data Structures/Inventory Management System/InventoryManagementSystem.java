// InventoryManagementSystem.java
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        Product p1 = new Product("1", "Laptop", 10, 1000.0);
        Product p2 = new Product("2", "Phone", 20, 500.0);
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        // Display all products
        System.out.println("Initial Inventory:");
        inventory.displayProducts();

        // Update a product
        p1.setPrice(900.0);
        inventory.updateProduct(p1);

        // Display all products
        System.out.println("\nUpdated Inventory:");
        inventory.displayProducts();

        // Delete a product
        inventory.deleteProduct("2");

        // Display all products
        System.out.println("\nFinal Inventory:");
        inventory.displayProducts();
    }
}
