package com.fareye.training.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class ToDo
{   @NotNull
    private LocalDateTime due_date;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private String Body;
    private String Title;
    private String Status;
    private User  user;

}
