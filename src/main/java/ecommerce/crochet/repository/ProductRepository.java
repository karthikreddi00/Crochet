package ecommerce.crochet.repository;

import ecommerce.crochet.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{

}