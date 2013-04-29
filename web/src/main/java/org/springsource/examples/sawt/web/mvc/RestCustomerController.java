package org.springsource.examples.sawt.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springsource.examples.sawt.CustomerService;
import org.springsource.examples.sawt.services.model.Customer;

import javax.inject.Inject;

@Controller
public class RestCustomerController {

    private static final String CUSTOMERS_URL = "/customers";
    private static final String CUSTOMER_BY_ID_URL = "/customer/{customerId}";

    @Inject
    private CustomerService customerService;

    @RequestMapping(value = CUSTOMER_BY_ID_URL, method = RequestMethod.POST)
    @ResponseBody
    public Customer updateCustomer(@RequestBody Customer customer) {
        return this.customerService.updateCustomer(
                customer.getId().longValue(),
                customer.getFirstName(),
                customer.getLastName());
    }

    @RequestMapping(value = CUSTOMER_BY_ID_URL, method = RequestMethod.GET)
    @ResponseBody
    public Customer loadCustomerById(@PathVariable long customerId) {
        return this.customerService.getCustomerById(customerId);
    }

    @RequestMapping(value = CUSTOMERS_URL, method = RequestMethod.PUT)
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer) {
        return this.customerService.createCustomer(
                customer.getFirstName(),
                customer.getLastName());
    }

}
