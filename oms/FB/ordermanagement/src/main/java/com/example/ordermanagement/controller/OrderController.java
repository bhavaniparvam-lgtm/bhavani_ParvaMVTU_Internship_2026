package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.OrderFormDto;
import com.example.ordermanagement.service.CustomerService;
import com.example.ordermanagement.service.OrderService;
import com.example.ordermanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;

    public OrderController(OrderService orderService,
                           CustomerService customerService,
                           ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list";
    }

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("orderForm", new OrderFormDto());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("products", productService.getAllProducts());
        return "orders/form";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("orderForm") OrderFormDto orderForm, Model model) {
        try {
            orderService.createOrder(orderForm);
            return "redirect:/orders";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("customers", customerService.getAllCustomers());
            model.addAttribute("products", productService.getAllProducts());
            return "orders/form";
        }
    }

    @GetMapping("/view/{id}")
    public String viewOrder(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "orders/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}