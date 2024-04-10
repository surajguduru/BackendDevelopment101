package dev.suraj.productservice.Services;

import dev.suraj.productservice.DTOs.FakeStoreProductDTO;
import dev.suraj.productservice.Exceptions.ProductNotFoundException;
import dev.suraj.productservice.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null){
            throw new ProductNotFoundException(id, "Please pass a valid product id");
        }
        Product product = convertFakeStoreProductDTOToProduct(fakeStoreProductDTO);
        return product;
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOs){
            products.add(convertFakeStoreProductDTOToProduct(fakeStoreProductDTO));
        }
        return products;
    }
    private Product convertFakeStoreProductDTOToProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        return product;
    }
}
