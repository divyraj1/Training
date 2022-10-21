package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    @Email
    private String email ;
    private String avtar_link;
    private boolean verified;
    private LocalDateTime createdAt ;
    private LocalDateTime modified ;
    private String password;
    private String Role;

}
