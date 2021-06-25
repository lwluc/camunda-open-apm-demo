package de.lw.camunda.external.client;

import de.lw.camunda.external.client.customer.Customer;
import de.lw.camunda.external.client.customer.CustomerApiClient;
import info.novatec.micronaut.camunda.external.client.feature.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
@ExternalTaskSubscription(topicName = "exampleTopic")
public class Handler implements ExternalTaskHandler {

    protected static final Logger LOG = LoggerFactory.getLogger(Handler.class);

    private final CustomerApiClient customerApiClient;

    public Handler(CustomerApiClient customerApiClient) {
        this.customerApiClient = customerApiClient;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Customer customer = this.customerApiClient.fetchCustomer().blockingFirst();

        Map<String, Object> variables = new HashMap<>();
        variables.put("firstName", customer.getFirstName());
        variables.put("lastName", customer.getLastName());

        externalTaskService.complete(externalTask, variables);

        LOG.info("The External Task {} has been completed!", externalTask.getId());
    }
}