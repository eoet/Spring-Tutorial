package com.ifi.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
