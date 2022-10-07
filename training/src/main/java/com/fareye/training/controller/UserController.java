package com.fareye.training.controller;


import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import com.fareye.training.model.User_Todo;
import com.fareye.training.utills.EncryptDecryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController
{
    @Autowired
    User_Todo user_todo;

    @Autowired
    EncryptDecryptUtil ed;
  //  List<User> user =new ArrayList<User>();
   // List<ToDo> todoList =new ArrayList<ToDo>();

    @GetMapping(path = "/hello")
    public String hello(@RequestParam String name)
     {
         return "Hello "+name;
     }
    @PostMapping(path = "/add")
    public List<User> add(@RequestBody User user1) throws Exception {   user1.setCreatedAt(java.time.LocalDateTime.now());
        System.out.println("Password"+user1.getPassword());
        ed.init();
        try {
            user1.setPassword(ed.encrypt(user1.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        user_todo.userList.add(user1);
        user_todo.userEmailMap.put(user1.getEmail(),user1);
        System.out.println(user_todo.todolist);
        return user_todo.userList;
    }

    @GetMapping(path = "/getUser")
    public List<User> add()
    {
        return user_todo.userList;
    }

}
