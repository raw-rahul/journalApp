package com.rawrahul.journalApp.service;

import com.rawrahul.journalApp.entity.User;
import com.rawrahul.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
//@Service  //this annotation is used as alternative of component, but make the code more readable
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);  //we can use annotation @Slf4j instead of this

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user){
        userRepository.save(user);
    }

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        }catch (Exception e){
//            logger.info("Noice u detected it"); // with declaring the Logger variable
            log.info("duplicacy not allowed"); // use with annotation @Slf4j
            log.error("duplicacy error occured for {}", user.getUsername(), e);  // {} this is placeholder, user's name will be printed here
            log.warn("this is waring for duplicacy");
            log.debug("debuggin");
            log.trace("tracing everything");
            return false;
        }
    }
    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByusername(String username){
        return userRepository.findByusername(username);
    }

}
