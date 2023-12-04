package org.sid.orderservice.services;
import org.sid.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="inventory-service")
public interface InventoryRestServiceClient {
    @GetMapping("/products/{id}?Projection=fullProduct")
    public Product productById(@PathVariable Long id);
    @GetMapping("/products?Projection=fullProduct")
    public PagedModel<Product> allProducts();
}
