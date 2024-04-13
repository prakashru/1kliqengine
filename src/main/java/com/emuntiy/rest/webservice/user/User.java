package com.emuntiy.rest.webservice.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class User {
    private Integer id;

    @Size(min = 5, message = "Name should be minimum 5 characters")
    private String name;

    @Past(message="Birthdate should be in past date")
    private LocalDate birthDate;


}
