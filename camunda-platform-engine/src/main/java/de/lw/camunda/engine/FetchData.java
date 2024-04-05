package de.lw.camunda.engine;

import de.lw.camunda.engine.customer.Customer;
import de.lw.camunda.engine.customer.CustomerService;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FetchData implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(FetchData.class);

    private CustomerService fetchDataService;

    public FetchData(CustomerService fetchDataService) {
        this.fetchDataService = fetchDataService;
    }

    @WithSpan
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Fetching Data from Service");
        Customer customer = this.fetchDataService.fetchData();
        String customerName = customer.getFirstName() + " " + customer.getLastName();
        log.info("Service returned customer {}", customerName);
        delegateExecution.setVariable("data", customerName);
    }
}
