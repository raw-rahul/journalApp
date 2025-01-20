package com.rawrahul.journalApp.controller;

import com.rawrahul.journalApp.api.response.WeatherResponse;
import com.rawrahul.journalApp.entity.User;
import com.rawrahul.journalApp.repository.UserRepository;
import com.rawrahul.journalApp.service.UserService;
import com.rawrahul.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

//    @GetMapping
//    public List<User> getAll(){
//        return userService.getAll();
//    }



    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){


//        User userInDb = userService.findByusername(user.getUsername());

//        whenever user authenticate , details store in SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByusername(username);
        userInDb.setUsername(user.getUsername());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByusername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping()
    public ResponseEntity<?> getGreeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        String greeting = "";
        if(weatherResponse != null){
            greeting = " Weather feels like "+ weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+ authentication.getName() + greeting, HttpStatus.OK);
    }
}
