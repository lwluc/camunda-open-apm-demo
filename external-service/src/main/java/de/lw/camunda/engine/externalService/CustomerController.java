package de.lw.camunda.engine.externalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping("/{id}")
    Customer getOne(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
