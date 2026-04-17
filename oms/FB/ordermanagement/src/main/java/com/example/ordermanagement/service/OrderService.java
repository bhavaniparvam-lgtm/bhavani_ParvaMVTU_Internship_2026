package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderFormDto;
import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.CustomerOrder;
import com.example.ordermanagement.entity.OrderItem;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.repository.CustomerOrderRepository;
import com.example.ordermanagement.repository.CustomerRepository;
import com.example.ordermanagement.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderService(CustomerOrderRepository customerOrderRepository,
                        CustomerRepository customerRepository,
                        ProductRepository productRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder getOrderById(Long id) {
        return customerOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Transactional
    public void createOrder(OrderFormDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (dto.getQuantity() == null || dto.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        if (product.getStockQuantity() < dto.getQuantity()) {
            throw new RuntimeException("Insufficient stock available");
        }

        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());
        order.setStatus(dto.getStatus());

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(dto.getQuantity());
        item.setUnitPrice(product.getPrice());

        BigDecimal subTotal = product.getPrice().multiply(BigDecimal.valueOf(dto.getQuantity()));
        item.setSubTotal(subTotal);

        order.addOrderItem(item);
        order.setTotalAmount(subTotal);

        product.setStockQuantity(product.getStockQuantity() - dto.getQuantity());

        customerOrderRepository.save(order);
        productRepository.save(product);
    }

    public void deleteOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }
}