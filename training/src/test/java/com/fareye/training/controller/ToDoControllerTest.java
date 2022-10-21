package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ToDoControllerTest {

    @Test
    void addTodo()
    {
        ToDo todo =new ToDo();
        todo.setBody("Hello Mr Ram .Singh this Side");
        todo.setTitle("Every6");
        todo.setStatus("Completed");
        User u=new User();
        u.setEmail("munaa1@gmail.com");
        todo.setUser(u);

        RestTemplate rs=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ToDo> entity = new HttpEntity<ToDo>(todo,headers);
        ResponseEntity<String> response = rs.exchange(
                "http://localhost:8080/addtodo", HttpMethod.POST, entity, String.class);
        String u1=response.getBody();
        assertEquals("todo has been added Succesfully",u1);



    }

    @Test
    void getTodo()
    {
        ToDo todo =new ToDo();
        todo.setBody("Hello Mr Ram .Singh this Side");
        todo.setTitle("Every");
        todo.setStatus("Completed");
        User u=new User();
        u.setEmail("munaa1@gmail.com");
        todo.setUser(u);




    }

    @Test
    void updateTodo() {
        ToDo todo =new ToDo();
        todo.setBody("Hello Mr Ram .Singh this Side");
        todo.setTitle("Every");
        todo.setStatus(" Not Completed");
        User u=new User();
        u.setEmail("munaa1@gmail.com");
        todo.setUser(u);
        RestTemplate rs=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ToDo> entity = new HttpEntity<ToDo>(todo,headers);
        ResponseEntity<String> response = rs.exchange(
                "http://localhost:8080/updatetodo", HttpMethod.PUT, entity, String.class);
        String u1=response.getBody();
        assertEquals("to do has been updated succesfully",u1);

    }

    @Test
    void deleteTodo()
    {
        ToDo todo =new ToDo();
        todo.setBody("Hello Mr Ram .Singh this Side");
         todo.setTitle("Every1");
        todo.setStatus("Completed");
        User u=new User();
        u.setEmail("munaa1@gmail.com");
        todo.setUser(u);
        RestTemplate rs=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ToDo> entity = new HttpEntity<ToDo>(todo,headers);
        ResponseEntity<String> response = rs.exchange(
                "http://localhost:8080/deleteTodo", HttpMethod.DELETE, entity, String.class);
        String u1=response.getBody();
        assertEquals("To Do Deleted SuccessFully",u1);


    }

    @Test
    void add()
    {
//        assertEquals(4,toDoController.add(2,2));
    }
}