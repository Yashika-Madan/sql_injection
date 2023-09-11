package com.sqlInjection.demo.contollers;

import com.sqlInjection.demo.dto.LoginCredentials;
import com.sqlInjection.demo.entities.Customer;
import com.sqlInjection.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ModelAndView checkConditionAndRedirect(@ModelAttribute LoginCredentials loginCredentials) {
        System.out.println(loginCredentials);
        Customer customer = customerService.login(loginCredentials.getUsername(), loginCredentials.getPassword());
        System.out.println("Customer response from database = " + customer);
        if(customer != null) {
            System.out.println("Customer is not null");
            ModelAndView modelAndView = new ModelAndView("user-dashboard");
            System.out.println("model and view object created");
            System.out.println(modelAndView);

            // Add response parameters to the ModelAndView
            modelAndView.addObject("accountNumber", customer.getAccountNumber());
            modelAndView.addObject("balance", customer.getBalance());

            return modelAndView;
        }else {
            return null;
        }


    }
}
