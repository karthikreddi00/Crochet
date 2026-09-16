package ecommerce.crochet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.crochet.entity.User;

public interface  UserRepository extends JpaRepository<User,Long> {
    
}
