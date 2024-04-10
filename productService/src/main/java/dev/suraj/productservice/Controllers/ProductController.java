package dev.suraj.productservice.Controllers;

import dev.suraj.productservice.DTOs.ExceptionDTO;
import dev.suraj.productservice.DTOs.FakeStoreProductDTO;
import dev.suraj.productservice.Models.Product;
import dev.suraj.productservice.Services.FakeStoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// ProductController -> localhost:8080/products
@RestController

@RequestMapping("/products")

public class ProductController {
    private final FakeStoreProductService fakeStoreProductService;
    ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }
    // localhost:8080/products/321
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return fakeStoreProductService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return fakeStoreProductService.getAllProducts();
    }
}
