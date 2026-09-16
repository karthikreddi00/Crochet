package ecommerce.crochet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.crochet.entity.Product;
import ecommerce.crochet.repository.ProductRepository;

@Service 
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
           this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
           return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("product not found"));
    }

    public void addProduct(Product product) {
       productRepository.save(product);
    }

    public List<Product> searchProducts(String name) {
        return productRepository.findByName(name);
    }

    public void updateProduct(Product product, Long id) {
         Product  modifiedProduct = productRepository.findById(id)
                                    .orElseThrow(() -> new RuntimeException("product not found"));
           modifiedProduct.setName(product.getName());
           modifiedProduct.setDescription(product.getDescription());
           modifiedProduct.setPrice(product.getPrice());
           modifiedProduct.setStock(product.getStock());
           productRepository.save(modifiedProduct);
    }

    public void deleteProduct(Long id) {
      productRepository.deleteById(id);
    }

   
}
