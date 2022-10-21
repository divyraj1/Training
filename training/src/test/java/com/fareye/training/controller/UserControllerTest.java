package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
        classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {


   @Mock
    UserService userService;

    @Test
    void adduser() throws MalformedURLException {


        User u1=new User();
        Mockito.when(userService.avatarUrl(u1.getFirstname())).thenReturn("https://avatars.githubusercontentrr.com/u/121330?v=4");
         u1.setFirstname(("Paramveer"));
         u1.setLastname("Singh");
         u1.setEmail("munaa3@gmail.com");
         u1.setPassword("1234");
         u1.setRole("user");
//         u1.setAvtar_link(userService.avatarUrl(u1.getFirstname()));
          RestTemplate rs=new RestTemplate();
          HttpHeaders headers = new HttpHeaders();
          headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
          HttpEntity<User> entity = new HttpEntity<User>(u1,headers);
           ResponseEntity<String> response = rs.exchange(
                 "http://localhost:8080/add", HttpMethod.POST, entity, String.class);
        String s=response.getBody();
        assertEquals("User Added Successfully",s);

      //  String u = rs.postForObject("http://localhost:8080/add", u1, String.class);
    }

    @Test
    void getUser() {
        RestTemplate rs=new RestTemplate();
        User[] u = rs.getForObject("http://localhost:8080/getUsers", User[].class);

    }

    @Test
    void putuser() {

        User u1=new User();
        u1.setFirstname(("Paramveer"));
        u1.setLastname("Singh");
        u1.setEmail("munaa1@gmail.com");
        u1.setPassword("1234");
        u1.setRole("user");
        RestTemplate rs=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<User> entity = new HttpEntity<User>(u1,headers);
        ResponseEntity<String> response = rs.exchange(
                "http://localhost:8080/putUser", HttpMethod.PUT, entity, String.class);
        String string=response.getBody();
        assertEquals("user updated Succesfully",string);
    }

    @Test
    void deleteuser() {
        User u1=new User();
        u1.setFirstname(("Paramveer"));
        u1.setLastname("Singh");
        u1.setEmail("munaa1@gmail.com");
        u1.setPassword("1234");
        u1.setRole("user");
        RestTemplate rs=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<User> entity = new HttpEntity<User>(u1,headers);
        ResponseEntity<String> response = rs.exchange(
                "http://localhost:8080/DeleteUser", HttpMethod.DELETE, entity, String.class);
        String string=response.getBody();
        assertEquals("User Deleted SuccesFully",string);


    }
}