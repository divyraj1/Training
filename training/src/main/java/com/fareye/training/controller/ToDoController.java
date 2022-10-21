package com.fareye.training.controller;

import com.fareye.training.Handler.TitleDoesNotExistException;
import com.fareye.training.Handler.UserDoesNotExitException;
import com.fareye.training.model.ToDo;
import com.fareye.training.model.User_Todo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @CrossOrigin(origins = "http://localhost:3000")
//    public List<ToDo> addTodo(@Valid @RequestBody  ToDo toDo)
    public String addTodo(@Valid @RequestBody  ToDo toDo)
    {

         if(user_todo.userEmailMap.get(toDo.getUser().getEmail())==null)
         {
             throw new UserDoesNotExitException("User Does Not Exist");
         }
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
       // return  user_todo.todolist;
        return "todo has been added Succesfully";
    }

    @GetMapping(path = "/gettodo")
   // @CrossOrigin(origins = "http://localhost:3000")
    public List<ToDo> getTodo(@RequestParam String email)
    {
        if(user_todo.userEmailMap.get(email)==null)
        {
            throw new UserDoesNotExitException("User Does Not Exist");
        }
        List<ToDo>tl= user_todo.user_todoMap.get(user_todo.userEmailMap.get(email));
       return  tl;
    }

    @PutMapping(path = "/updatetodo")
    @CrossOrigin(origins = "http://localhost:3000")
    //public List<ToDo> updateTodo(@Valid @RequestBody  ToDo toDo)
    public String updateTodo(@RequestBody  ToDo toDo)
    {
        if(user_todo.userEmailMap.get(toDo.getUser().getEmail())==null)
        {
            throw new UserDoesNotExitException("User Does Not Exist");
        }
        ArrayList<ToDo>td=user_todo.user_todoMap.get(user_todo.userEmailMap.get(toDo.getUser().getEmail()));
        boolean titleExist=false;
        for(int i =0 ;i < td.size();  ++i ) {

            if (toDo.getTitle().equals(td.get(i).getTitle())) {
                titleExist=true;
                ToDo toDo1=td.get(i);
                toDo1.setModified_date(java.time.LocalDateTime.now());
                toDo1.setBody(toDo.getBody());
                toDo1.setTitle(toDo.getTitle());
                toDo1.setStatus(toDo.getStatus());

            }
        }
       if(titleExist==false)
       {
           throw new TitleDoesNotExistException("No Todo With Given Title Exist");
       }
     //  return  user_todo.todolist;
        return "to do has been updated succesfully";
    }
    @DeleteMapping(path = "/deleteTodo")
//    public List<ToDo> deleteTodo(@RequestBody  ToDo toDo)
    public String deleteTodo(@RequestBody  ToDo toDo)
    {
        if(user_todo.userEmailMap.get(toDo.getUser().getEmail())==null)
        {
            throw new UserDoesNotExitException("User Does Not Exist");
        }

        ArrayList<ToDo>td=user_todo.user_todoMap.get(user_todo.userEmailMap.get(toDo.getUser().getEmail()));
        boolean titleExist=false;
        if(td!=null){
        for(int i =0 ;i < td.size();  ++i ) {

            if (toDo.getTitle().equals(td.get(i).getTitle())) {
                titleExist=true;
                td.remove(i);
            }
        }
      }else{

        }
        if(titleExist==false)
        {
            throw new TitleDoesNotExistException("No Todo With Given Title Exist");
        }
        return  "To Do Deleted SuccessFully";
    }

    public static int add(int a,int b)
    {
        return a+b;
    }
}
