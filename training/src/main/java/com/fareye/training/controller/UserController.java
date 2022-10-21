package com.fareye.training.controller;


import com.fareye.training.Handler.UserDoesNotExitException;
import com.fareye.training.model.User;
import com.fareye.training.model.UserRepository;
import com.fareye.training.model.User_Todo;
import com.fareye.training.service.UserService;
import com.fareye.training.utills.EncryptDecryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController
{
    @Autowired
    User_Todo user_todo;

    @Autowired
    EncryptDecryptUtil ed;

    @Autowired
    UserService us;

    @Autowired
    UserRepository userRepository;
    @PostMapping(path = "/add")
   // @CrossOrigin(origins = "http://localhost:3000")
//    public List<User> add(@RequestBody User user1) throws Exception
    public String add(@RequestBody User user1) throws Exception{
        user1.setCreatedAt(java.time.LocalDateTime.now());
        ed.init();
        try {
            user1.setPassword(ed.encrypt(user1.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        user1.setAvtar_link(us.avatarUrl(user1.getFirstname()));
        user_todo.userList.add(user1);
        user_todo.userEmailMap.put(user1.getEmail(),user1);
        System.out.println(user_todo.todolist);
      //  userRepository.save(user1);
        return "User Added Successfully";
       // return user_todo.userList;
    }

    @GetMapping(path = "/getUsers")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getUser()
    {
        return user_todo.userList;
    }

    @PutMapping(path = "/putUser")
    @CrossOrigin(origins = "http://localhost:3000")
    // public List<User> putuser(@RequestBody User user1) throws Exception
    public String putuser(@RequestBody User user1) throws Exception
    {

        if(user_todo.userEmailMap.get(user1.getEmail())==null)
        {
            throw new UserDoesNotExitException("User Does Not Exist");
        }
        for(int i =0 ;i < user_todo.userList.size();  ++i ) {

            if (user1.getEmail().equals(user_todo.userList.get(i).getEmail())) {
                User u = user_todo.userList.get(i);
                ed.init();
                u.setModified(java.time.LocalDateTime.now());
                u.setFirstname(user1.getFirstname());
                u.setLastname(user1.getLastname());
                u.setPassword(user1.getPassword());
                u.setEmail(user1.getEmail());
                u.setRole(user1.getRole());

            }
        }
       // return user_todo.userList;
        return "user updated Succesfully";
    }

    @DeleteMapping(path = "/DeleteUser")
    @CrossOrigin(origins = "http://localhost:3000")
  //  public List<User> deleteuser(@RequestBody User user1) throws Exception
    public String deleteuser(@RequestBody User user1) throws Exception
    {
        if(user_todo.userEmailMap.get(user1.getEmail())==null)
        {
            throw new UserDoesNotExitException("User Does Not Exist");
        }
        for(int i =0 ;i < user_todo.userList.size(); ++i ) {

            if (user1.getEmail().equals(user_todo.userList.get(i).getEmail())) {

                user_todo.userEmailMap.remove(user_todo.userList.get(i).getEmail());
                user_todo.user_todoMap.remove(user_todo.userList.get(i));
                user_todo.userList.remove(i);

            }
        }
       // return user_todo.userList;
        return "User Deleted SuccesFully";
    }


}
