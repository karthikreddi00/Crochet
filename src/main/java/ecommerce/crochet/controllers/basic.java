package ecommerce.crochet.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class basic {
    
        @RequestMapping("/")
        public String mainPage(){
            return "welcome to crochet bookings";
        }
}
