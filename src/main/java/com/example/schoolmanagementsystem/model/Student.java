package com.example.schoolmanagementsystem.model;

import com.example.schoolmanagementsystem.enumeration.Level;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "STUDENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "First name is required.")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Column(name = "age")
    @NotEmpty(message = "Age is required.")
    private String age;

    @Column(name = "phone")
    @NotEmpty(message = "Mobile phone is required.")
    private String phone;

    @Column(name = "level")
    private Level level;
}
