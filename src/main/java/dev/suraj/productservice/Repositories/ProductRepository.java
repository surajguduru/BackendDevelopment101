package dev.suraj.productservice.Repositories;

import dev.suraj.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    @Override
    Product save(Product product);
}
