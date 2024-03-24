package com.emuntiy.rest.webservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;


}
