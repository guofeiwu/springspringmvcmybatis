package com.integrate.ssm.model.service;

import com.integrate.ssm.model.Person;
import com.integrate.ssm.model.query.PersonQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GuofeiWu on 2017/8/18.
 */

@Service
public class PersonService {

    @Autowired
    private PersonQuery personQuery;

    public List<Person> getAllPersons(){
        List<Person> persons = personQuery.getAllPerson();
        if(personQuery == null){
            System.out.println("personQuery is null");
        }else{
            System.out.println("personQuery is not null"+persons);
        }
        return persons;
    }
}
