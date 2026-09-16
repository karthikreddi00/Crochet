package ecommerce.crochet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ecommerce.crochet.entity.User;
import ecommerce.crochet.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
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


    public User updateUser(User user, Long id){
        User modifiedUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        modifiedUser.setName(user.getName());
        modifiedUser.setEmail(user.getEmail());
        modifiedUser.setPassword(user.getPassword());
        return userRepository.save(modifiedUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
