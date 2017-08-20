package com.integrate.ssm.model.query;

import com.integrate.ssm.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by GuofeiWu on 2017/8/18.
 */

@Component
public interface PersonQuery {
    List<Person> getAllPerson();
}
