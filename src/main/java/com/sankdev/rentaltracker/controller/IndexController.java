package com.sankdev.rentaltracker.controller;

import com.sankdev.rentaltracker.Organization;
import com.sankdev.rentaltracker.service.AgreementService;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

  private Organization organization;
  @DateTimeFormat(pattern = "dd.MM.yyyy")
  private LocalDate reportDate;
  private AgreementService agreementService;
  private BigDecimal rentalAmount;

  @Autowired
  public IndexController(AgreementService theAgreementService) {
    agreementService = theAgreementService;
  }

  @PostConstruct
  private void loadData() {
    organization = new Organization();
    reportDate = LocalDate.now();
  }

  @RequestMapping("/")
  public String index(Model theModel) {

    theModel.addAttribute("reportDate", reportDate);

    theModel.addAttribute("organization", organization);

    rentalAmount = agreementService.getRentalAmount(reportDate);

    theModel.addAttribute("rentalAmount", rentalAmount);

    return "index";
  }

  @GetMapping("/recalculateRentalAmount")
  public String recalculateRentalAmount(
      @RequestParam(name = "reportDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate theReportDate) {

    reportDate = theReportDate;

    rentalAmount = agreementService.getRentalAmount(reportDate);

    return "redirect:";

  }

}
