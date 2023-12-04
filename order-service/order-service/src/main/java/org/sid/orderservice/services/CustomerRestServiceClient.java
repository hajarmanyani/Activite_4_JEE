package org.sid.orderservice.services;
import org.sid.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer-service")
public interface CustomerRestServiceClient {
    @GetMapping("/customers/{id}?Projection=fullCustomer")
    public Customer customerById(@PathVariable Long id);
    @GetMapping("/customers?Projection=fullCustomer")
    public PagedModel<Customer> allCustomers();
}
