package legacy_console.model;

public class Product {

    private int productId;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private String barcode;

    public Product() {}

    public Product(int productId, String name, String category, int quantity, double price, String barcode) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.barcode = barcode;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
}
