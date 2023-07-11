package com.aift.lukie.Model.Teritary;

import java.util.*;

import javax.crypto.SecretKey;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.aift.lukie.utilities.Utils;

import lombok.Getter;
import lombok.Setter;

@Entity // Hibernate to make a table out of this class
@Table(name = "user")
@Getter
@Setter
public class User {

    // consturctor
    public User(){}

    // duplicated constructor 
    public <K> User(HashMap<String,K> other) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        for (Map.Entry<String, K> entry : other.entrySet()){
            Utils.setElements(this, entry.getKey(),entry.getValue());
        }
    }

    /**
    * @Description -- primary key
    */
    @Id
    @Column(name = "username", columnDefinition = "varchar(200)",nullable = false)
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty(message="cannot be empty")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(200)",nullable = false)
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty(message="cannot be empty")
    private String password;

    @Column(name = "role", columnDefinition = "varchar(50)",nullable = false)
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty(message="cannot be empty")
    private String role;

    @Column(name = "uuid", columnDefinition = "varchar(600)",nullable = false)
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotEmpty(message="cannot be empty")
    private String uuid;

}
