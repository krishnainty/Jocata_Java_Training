package com.jocata.OrderManagementSystem.controller;

import com.jocata.OrderManagementSystem.bean.CustomerBean;
import com.jocata.OrderManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oms/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/create")
    Object createCustomer(@RequestBody CustomerBean customerBean){
        return customerService.createCustomer(customerBean);
    }
    @PostMapping("/getById/{customerId}")
    public Object getCustomerById(@PathVariable int customerId){
        return customerService.getCustomerById(customerId);



    }
    @GetMapping("/getAll")
    public Object getAllCustomers(){
        return customerService.getAllCustomers();

    }
    @DeleteMapping("/delete/{customerId}")
    public Object deleteCustomer(@PathVariable int customerId){
       return customerService.deleteCustomer(customerId);

    }
    @PutMapping("/update")
    public Object updateCustomer(@RequestBody CustomerBean customerBean){
        return customerService.updateCustomer(customerBean);

    }
}
