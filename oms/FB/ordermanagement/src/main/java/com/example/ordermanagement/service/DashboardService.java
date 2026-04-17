package com.example.ordermanagement.service;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;

    public DashboardService(CustomerService customerService,
                            ProductService productService,
                            OrderService orderService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
    }

    public long getCustomerCount() {
        return customerService.getAllCustomers().size();
    }

    public long getProductCount() {
        return productService.getAllProducts().size();
    }

    public long getOrderCount() {
        return orderService.getAllOrders().size();
    }

    public long getOutOfStockCount() {
        return productService.getOutOfStockProducts().size();
    }
}