package com.emuntiy.rest.webservice.controllers;

import com.emuntiy.rest.webservice.pojo.Name;
import com.emuntiy.rest.webservice.pojo.PersonV1;
import com.emuntiy.rest.webservice.pojo.PersonV2;
import com.emuntiy.rest.webservice.pojo.PersonV3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/v1/person")
    public PersonV1 getV1Person(){

        return new PersonV1("Prakash Dutta");
    }

    @GetMapping("/v2/person")
    public PersonV2 getV2Person(){

        return new PersonV2(new Name("Bikash", "Dutta"));
    }

    @GetMapping(path="/v3/person", params = "version=3")
    public PersonV3 getPersonVersion(){

        return new PersonV3("Shanghai");
    }
}
