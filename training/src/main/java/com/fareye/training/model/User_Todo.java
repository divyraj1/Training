package com.fareye.training.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class User_Todo
{
    public ArrayList<ToDo>todolist;
    public List<User> userList ;

    public HashMap<String,User>userEmailMap;

    public HashMap<User,ArrayList<ToDo>> user_todoMap;
    User_Todo()
    {
        todolist=new ArrayList<ToDo>();
        userList =new ArrayList<User>();
        user_todoMap=new HashMap<>();
        userEmailMap=new HashMap();
    }
}
