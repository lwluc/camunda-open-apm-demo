package de.lw.camunda.engine.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService() {}

    public Customer fetchData() {
        final String uri = "http://external-service:7788/customers/1";
        log.info("Fetch data from uri {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Customer.class);
    }
}
