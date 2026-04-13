package com.example.task3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @DateTimeFormat
    @Column(name = "dateTime",nullable = false)
    private LocalDateTime createDate;

    public User(String name,String email) {
        this.name = name;
        this.email = email;
        this.createDate = LocalDateTime.now();
    }

    public String toString(){
        return "id = ' " + id + " '" +
                ", name = ' " + name + " '" +
                ", mail=' " + email + " '";
    }
}
