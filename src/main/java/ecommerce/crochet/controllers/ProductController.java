package ecommerce.crochet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.crochet.entity.Product;
import ecommerce.crochet.service.ProductService;


@RestController 
@RequestMapping("/product")
public class ProductController {
         private final ProductService productService;
         
         public ProductController(ProductService productService){
            this.productService = productService;
         }  
       

         //geting all products
        @GetMapping
        public ResponseEntity<List<Product>> getProducts(){
            return ResponseEntity.ok(productService.getProducts());
        }

         //add product
        @PostMapping
        public ResponseEntity<Product> postproducts(@RequestBody Product product){
             return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.addProduct(product));
        }

           // get product by id
        @GetMapping("/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable Long id){
             Optional<Product> product = productService.getProduct(id);
             if(product.isPresent())
                return ResponseEntity.ok(product.get());
            return ResponseEntity.notFound().build();
        }

        //search product by id
        @GetMapping("/search")
        public ResponseEntity<List<Product>> searchProducts(@RequestParam String name){
            return ResponseEntity.ok(productService.searchProducts(name));
        }

        //updating product by id
        @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@RequestBody  Product product, @PathVariable Long id){

            return ResponseEntity.ok(productService.updateProduct(product, id));
        }

        //deleteing product by id
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
             productService.deleteProduct(id);
             return ResponseEntity.noContent().build();
        }
}
