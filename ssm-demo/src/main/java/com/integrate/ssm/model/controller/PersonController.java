package com.integrate.ssm.model.controller;

import com.integrate.ssm.model.Person;
import com.integrate.ssm.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by GuofeiWu on 2017/8/20.
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/getPersons")
    public String getPerson(Map<String,Object> map){
        System.out.println("PersonController");
        List<Person> persons =  personService.getAllPersons();
        System.out.println("PersonController");
        map.put("persons",persons);
        return "list";
    }
}
