package com.sankdev.rentaltracker.controller;

import com.sankdev.rentaltracker.entity.Rental;
import com.sankdev.rentaltracker.service.RentalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rentals")
public class RentalController {

  private RentalService rentalService;

  @Autowired
  public RentalController(RentalService theRentalService) {
    rentalService = theRentalService;
  }

  @GetMapping("/list")
  public String listRentals(Model theModel) {

    List<Rental> rentals = rentalService.findAll();

    theModel.addAttribute("rentals", rentals);

    return "rentals/list-rentals";
  }

  @GetMapping("/list/vacant")
  public String listRentalsVacant(Model theModel) {

    List<Rental> rentals = rentalService.findAllVacant();

    theModel.addAttribute("rentals", rentals);

    return "rentals/list-rentals";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model theModel) {
    Rental theRental = new Rental();

    theModel.addAttribute("rental", theRental);

    return "rentals/rental-form";
  }

  @PostMapping("/save")
  public String saveRental(@ModelAttribute("rental") Rental theRental) {

    //save the rental
    rentalService.save(theRental);

    // use a redirect to prevent duplicate submissions
    return "redirect:/rentals/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("rentalId") int theId) {

    // delete the rental
    rentalService.deleteById(theId);

    // redirect to /rentals/list
    return "redirect:/rentals/list";

  }
}
