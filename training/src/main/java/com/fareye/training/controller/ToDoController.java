package com.fareye.training.controller;

import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import com.fareye.training.model.User_Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoController
{
    @Autowired
    User_Todo user_todo;


    @PostMapping(path = "/addtodo")
    public List<ToDo> addTodo(@Valid @RequestBody  ToDo toDo, BindingResult bindingResult)
    {  //hello
        System.out.println(bindingResult.hasErrors());
        toDo.setCreated_date(java.time.LocalDateTime.now());
        user_todo.todolist.add(toDo);

        ArrayList<ToDo> todoList = user_todo.user_todoMap.get(user_todo.userEmailMap.get(toDo.getUser().getEmail()));
        if(todoList == null) {
            todoList= new ArrayList<ToDo>();
            todoList.add(toDo);
            user_todo.user_todoMap.put(user_todo.userEmailMap.get(toDo.getUser().getEmail()),todoList);
        }
        else
        {
            if(!todoList.contains(todoList))
                todoList.add(toDo);
        }

   //     System.out.println(user_todo.todolist);

        return  user_todo.todolist;
    }

    @GetMapping(path = "/gettodo")
    public List<ToDo> getTodo(@RequestParam String email)
    {   //toDo.setCreated_date(java.time.LocalDateTime.now());
       // user_todo.todolist.add(toDo);
        System.out.println(user_todo.todolist);
       // return  user_todo.todolist;
       return  user_todo.user_todoMap.get(user_todo.userEmailMap.get(email));
    }

}
