package com.rawrahul.journalApp.service;

import com.rawrahul.journalApp.entity.User;
import com.rawrahul.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


// first method
//@SpringBootTest
//public class UserDetailsServiceImplTests {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Test
//    public void loadUserByUsernameTest(){
//        when(userRepository.findByusername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("nehru").password("jinna").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("rahul");
//        Assertions.assertNotNull(user);
//    }
//
//}

// second method
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Disabled
    @Test
    public void loadUserByUsernameTest(){
        when(userRepository.findByusername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("nehru").password("jinna").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("rahul");
        Assertions.assertNotNull(user);
    }
}
