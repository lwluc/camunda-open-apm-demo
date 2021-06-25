package de.lw.camunda.external.client.customer;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

import static io.micronaut.http.HttpHeaders.ACCEPT;

@Client(CustomerConfiguration.URI)
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface CustomerApiClient {

    @Get("/customers/1")
    Flowable<Customer> fetchCustomer();
}