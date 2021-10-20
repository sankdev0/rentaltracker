package com.sankdev.rentaltracker.controller;

import com.sankdev.rentaltracker.entity.Person;
import com.sankdev.rentaltracker.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {

  private PersonService personService;

  @Autowired
  public PersonController(PersonService thePersonService) {
    personService = thePersonService;
  }

  @GetMapping("/list")
  public String listPeople(Model theModel) {

    List<Person> people = personService.findAll();

    theModel.addAttribute("people", people);

    return "list-people";
  }
}
