package ecommerce.crochet.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.crochet.entity.Product;
import ecommerce.crochet.service.ProductService;


@RestController 
@RequestMapping("/api")
public class ProductController {
         private final ProductService productService;
         
         public ProductController(ProductService productService){
            this.productService = productService;
         }  
       

         //geting all products
        @GetMapping("/products")
        public List<Product> getProducts(){
            return productService.getProducts();
        }

         //add product
        @PostMapping("/products")
        @ResponseStatus(HttpStatus.CREATED)
        public void postproducts(@RequestBody Product product){
             productService.addProduct(product);
        }

           // get product by id
        @GetMapping("/products/{id}")
        public Product getProduct(@PathVariable Long id){
            return productService.getProduct(id);
        }

        //search product by id
        @GetMapping("/products/search")
        public List<Product> searchProducts(@RequestParam String name){
            return productService.searchProducts(name);
        }

        //updating product by id
        @PutMapping("/products/{id}")
        public void updateProduct(@RequestBody  Product product, @PathVariable Long id){
             productService.updateProduct(product, id);
        }

        //deleteing product by id
        @DeleteMapping("/products/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteProduct(@PathVariable Long id){
             productService.deleteProduct(id);
        }
}
