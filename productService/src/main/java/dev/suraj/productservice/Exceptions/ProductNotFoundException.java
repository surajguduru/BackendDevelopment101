package dev.suraj.productservice.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
public class ProductNotFoundException extends RuntimeException{
    private Long id;
    public Long getId(){
        return id;
    }
    public ProductNotFoundException(Long id, String message){
        super("Product with id: " + id + " not found");
        this.id = id;
    }
}
