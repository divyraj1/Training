package com.fareye.training.annotation;


import com.fareye.training.model.ToDo;
import com.fareye.training.model.User;
import com.fareye.training.model.User_Todo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;


public class TitleValidator implements ConstraintValidator<TitleValidation, ToDo> {

     @Autowired
    User_Todo user_todo;
    public boolean isValid(ToDo toDo, ConstraintValidatorContext cxt) {

        User u=user_todo.userEmailMap.get(toDo.getUser().getEmail());
        ArrayList<ToDo> l = user_todo.user_todoMap.get(u);
       if(l!=null&&l.size()!=0) {
           for (ToDo t : l) {
               if (t.getTitle().equals(toDo.getTitle())) {
                   return false;
               }
           }
       }
        return true;
    }

}
