package com.sankdev.rentaltracker.controller;

import com.sankdev.rentaltracker.entity.Agreement;
import com.sankdev.rentaltracker.service.AgreementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agreements")
public class AgreementController {

  private AgreementService agreementService;

  @Autowired
  public AgreementController(AgreementService theAgreementService) {
    agreementService = theAgreementService;
  }

  @GetMapping("/list")
  public String showAgreements(Model theModel) {

    List<Agreement> agreements = agreementService.findAll();

    theModel.addAttribute("agreements", agreements);

    return "list-agreements";
  }

}
