package de.lw.camunda.externalTaskService.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static de.lw.camunda.externalTaskService.Utils.isRunningInsideDocker;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService() {}

    public Customer fetchData() {
        String host = isRunningInsideDocker() ? "external-service" : "localhost";
        final String baseURI = "http://%s:7788/customers/1";
        String uri = String.format(baseURI, host);
        log.info("Fetch data from uri {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Customer.class);
    }
}
