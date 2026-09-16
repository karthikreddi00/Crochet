package ecommerce.crochet.repository;

import ecommerce.crochet.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByName(String name);
}