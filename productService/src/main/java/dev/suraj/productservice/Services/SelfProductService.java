package dev.suraj.productservice.Services;

import dev.suraj.productservice.Models.Product;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public class SelfProductService {
    @Override
    public Product getProductById(Long id){
        Optional<Product> product = productRepository.findById(id);

    }
}
