package com.example.homework11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {
    private BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public String useApi() {
        businessService.businessLogic();
        return "You used API";
    }
}
