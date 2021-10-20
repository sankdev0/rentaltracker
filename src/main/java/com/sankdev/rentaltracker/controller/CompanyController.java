package com.sankdev.rentaltracker.controller;

import com.sankdev.rentaltracker.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {

  private final CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService theCompanyService) {
    companyService = theCompanyService;
  }

  @GetMapping("/list")
  public String listCompanies(Model theModel) {

    theModel.addAttribute("companies", companyService.findAll());

    return "list-companies";
  }

}
