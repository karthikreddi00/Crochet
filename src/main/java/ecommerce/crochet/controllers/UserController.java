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
import org.springframework.web.bind.annotation.RestController;

import ecommerce.crochet.entity.User;
import ecommerce.crochet.service.UserService;

@RestController 
@RequestMapping("/users")
public class UserController {
    
    private final UserService userservice;
    
    public UserController(UserService userService){
        this.userservice = userService;
    }

    //new user
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
                return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userservice.addUser(user));
    }

    //get all users
    @GetMapping 
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userservice.getUsers());
    }

    // get user by id
    @GetMapping ("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = userservice.getUser(id);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());
        return ResponseEntity.notFound().build();
    }

    //updateuser by id
    @PutMapping ("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        User modified = userservice.updateUser(user, id);
        
       return ResponseEntity.ok(modified);
    }

    // deleteing user by id
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletUser(@PathVariable Long id){
        userservice.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
