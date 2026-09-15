package ecommerce.crochet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.crochet.service.ProductService;


@RestController 
@RequestMapping("/api")
public class ProductController {
         private final ProductService productService;
         
         public ProductController(ProductService productService){
            this.productService = productService;
         }  
       
        @GetMapping("/products")
        public String getProducts(){
            return productService.getProducts();
        }

        @PostMapping("/products")
        public String postproducts(){
            return productService.addProduct();
        }

}
