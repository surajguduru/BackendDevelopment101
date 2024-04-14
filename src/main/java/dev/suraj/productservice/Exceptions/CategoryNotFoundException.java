package dev.suraj.productservice.Exceptions;
import dev.suraj.productservice.Repositories.ProductRepository;
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}