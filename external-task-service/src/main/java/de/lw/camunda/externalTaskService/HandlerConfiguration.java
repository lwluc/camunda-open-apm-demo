package de.lw.camunda.externalTaskService;

import de.lw.camunda.externalTaskService.customer.Customer;
import de.lw.camunda.externalTaskService.customer.CustomerService;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HandlerConfiguration {

  private CustomerService customerService;

  protected static final Logger LOG = LoggerFactory.getLogger(HandlerConfiguration.class);

  HandlerConfiguration(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Bean
  @ExternalTaskSubscription("exampleTopic")
  public ExternalTaskHandler exampleTopic() {
    return (externalTask, externalTaskService) -> {

      Customer customer = this.customerService.fetchData();

      Map<String, Object> variables = new HashMap<>();
      variables.put("firstName", customer.getFirstName());
      variables.put("lastName", customer.getLastName());

      externalTaskService.complete(externalTask, variables);

      LOG.info("The External Task {} has been completed!", externalTask.getId());
    };
  }
}
