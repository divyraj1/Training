package com.fareye.training.model;

import com.fareye.training.annotation.TitleValidation;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@NoArgsConstructor
@Getter
@Setter
@ToString
@TitleValidation()
@Entity
@Table(name = "todo")
public class ToDo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime due_date;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private String Body;
    private String Title;
    private String Status;
    @ManyToOne
    private User  user;

}
