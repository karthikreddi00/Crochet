package ecommerce.crochet.service;

import ecommerce.crochet.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import ecommerce.crochet.entity.User;
import ecommerce.crochet.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
       return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }


    public User updateUser(@RequestBody User user, @PathVariable Long id){
        User modifiedUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        modifiedUser.setName(user.getName());
        modifiedUser.setEmail(user.getEmail());
        modifiedUser.setPassword(user.getPassword());
        return userRepository.save(modifiedUser);
    }

    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }


}
