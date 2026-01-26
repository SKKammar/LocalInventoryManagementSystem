package service;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class InventoryService {

    private ProductDAO productDAO = new ProductDAO();

    public boolean addProduct(Product product) {
        if (productDAO.productExists(product.getProductId())) {
            System.out.println("Product ID already exists.");
            return false;
        }
        if (product.getQuantity() < 0 || product.getPrice() <= 0) {
            System.out.println("Invalid quantity or price.");
            return false;
        }
        return productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public boolean updateProduct(Product product) {
        if (product.getQuantity() < 0 || product.getPrice() <= 0) {
            System.out.println("Invalid values.");
            return false;
        }
        return productDAO.updateProduct(product);
    }

    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }

    public Product searchProduct(int id) {
        return productDAO.searchProduct(id);
    }
}
