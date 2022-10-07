package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User
{
    private String firstname;
    private String lastname;
    @Email
    private String email ;
    private boolean verified;
    private LocalDateTime createdAt ;
    private LocalDateTime modified ;
    private String password;
    private String Role;

}
