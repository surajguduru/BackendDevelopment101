package dev.suraj.productservice.Services;
import dev.suraj.productservice.Models.Product;
import java.util.List;
public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
