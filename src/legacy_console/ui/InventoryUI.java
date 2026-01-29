package legacy_console.ui;

import legacy_console.model.Product;
import legacy_console.service.InventoryService;

import java.util.Scanner;

public class InventoryUI {

    private InventoryService service = new InventoryService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            try {
                System.out.println("\n=== Inventory Management System ===");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Search Product");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addProductUI();
                    case 2 -> viewAllProducts();
                    case 3 -> updateProductUI();
                    case 4 -> deleteProductUI();
                    case 5 -> searchProductUI();
                    case 6 -> { System.out.println("Exiting..."); return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid input.");
                sc.nextLine();
            }
        }
    }

    private void addProductUI() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Barcode: ");
        String barcode = sc.nextLine();

        Product p = new Product(id, name, category, qty, price, barcode);
        System.out.println(service.addProduct(p) ? "Product added successfully!" : "Failed to add product.");
    }

    private void viewAllProducts() {
        System.out.println("\nID | Name | Category | Qty | Price | Barcode");
        System.out.println("----------------------------------");
        service.getAllProducts().forEach(p ->
                System.out.printf("%d | %s | %s | %d | %.2f%n",
                        p.getProductId(), p.getName(), p.getCategory(),
                        p.getQuantity(), p.getPrice(), p.getBarcode())
        );
    }

    private void updateProductUI() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("New Name: ");
        String name = sc.nextLine();
        System.out.print("New Category: ");
        String category = sc.nextLine();
        System.out.print("New Quantity: ");
        int qty = sc.nextInt();
        System.out.print("New Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("New Barcode: ");
        String barcode = sc.nextLine();

        Product p = new Product(id, name, category, qty, price, barcode);
        System.out.println(service.updateProduct(p) ? "Updated successfully." : "Update failed.");
    }

    private void deleteProductUI() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        System.out.println(service.deleteProduct(id) ? "Deleted successfully." : "Delete failed.");
    }

    private void searchProductUI() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        Product p = service.searchProduct(id);

        if (p != null) {
            System.out.println(p.getProductId() + " | " + p.getName() + " | " +
                    p.getCategory() + " | " + p.getQuantity() + " | " + p.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
}
