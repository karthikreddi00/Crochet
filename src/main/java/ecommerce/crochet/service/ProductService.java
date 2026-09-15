package ecommerce.crochet.service;

import org.springframework.stereotype.Service;

@Service 
public class ProductService {

    public String getProducts(){
        return "1) teddy bear 2) flower";
    }
    public String addProduct(){
        return "added successfully";
    }
    public String updateProducts(){
        return "updated successfully";
    }
}
