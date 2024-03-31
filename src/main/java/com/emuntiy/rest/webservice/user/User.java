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

    @Size(min = 5)
    private String name;

    @Past
    private LocalDate birthDate;


}
