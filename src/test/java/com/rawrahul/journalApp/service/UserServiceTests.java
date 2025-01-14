//package com.rawrahul.journalApp.service;
//
//import com.rawrahul.journalApp.entity.User;
//import com.rawrahul.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired UserService userService;
//
//
////    @ParameterizedTest
////    @CsvSource({
////            "rahul",
////            "riya",
////            "raw",
////            "ram"  // This test case will cause the test to fail
////    })
//
//    //other method
////    @ValueSource(strings = {
////            "rahul",
////            "riya",
////            "raw",
//////            "ram"  // This will cause the test to fail
////    })
//
//    //one more method
//
//    @Disabled
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public  void testSaveNewUser(User user){
//        assertTrue(userService.saveNewUser(user));
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1, 1, 2",
//            "2, 10, 12"  //value of a, b, expected
////            "3, 3, 9"
//    })
//    public  void test(int a, int b, int expected){
//        assertEquals(expected, a+b);
//    }
//
//
//    @Disabled
//    @Test
//    public void test1(){
//        assertEquals(5, 2+3);
//    }
//
//}
