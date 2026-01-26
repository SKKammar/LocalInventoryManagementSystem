import ui.InventoryUI;
import util.DBConnection;

public class Main {
    public static void main(String[] args) {

        System.out.println("Checking database connection...");

        if (DBConnection.testConnection()) {
            System.out.println("Database connected successfully.\n");
            new InventoryUI().start();
        } else {
            System.out.println("Failed to connect to database.");
            System.out.println("Please check MySQL credentials and try again.");
        }
    }
}
