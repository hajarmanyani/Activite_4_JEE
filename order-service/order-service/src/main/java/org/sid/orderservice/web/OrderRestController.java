package org.sid.orderservice.web;
import org.sid.orderservice.entities.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestServiceClient;
import org.sid.orderservice.services.InventoryRestServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestServiceClient customerRestServiceClient;
    private InventoryRestServiceClient inventoryRestServiceClient;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestServiceClient customerRestServiceClient, InventoryRestServiceClient inventoryRestServiceClient) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestServiceClient = customerRestServiceClient;
        this.inventoryRestServiceClient = inventoryRestServiceClient;
    }
    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null && order.getCustomerId() != null) {
            Customer customer=customerRestServiceClient.customerById(order.getCustomerId());
            order.setCustomer(customer);
            order.getProductItems().forEach(pi -> {
                Product product=inventoryRestServiceClient.productById(pi.getProductId());
                pi.setProduct(product);
            });
        }
        return order;
    }
}
