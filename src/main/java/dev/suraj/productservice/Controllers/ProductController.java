package dev.suraj.productservice.Controllers;

import dev.suraj.productservice.DTOs.ExceptionDTO;
import dev.suraj.productservice.DTOs.FakeStoreProductDTO;
import dev.suraj.productservice.Models.Product;
import dev.suraj.productservice.Services.FakeStoreProductService;
import dev.suraj.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ProductController -> localhost:8080/products
@RestController

@RequestMapping("/products")

public class ProductController {
    private ProductService productService;
    ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // localhost:8080/products/321
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
