package com.example.ordermanagement.controller;

import com.example.ordermanagement.service.DashboardService;
import com.example.ordermanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final DashboardService dashboardService;
    private final ProductService productService;

    public HomeController(DashboardService dashboardService, ProductService productService) {
        this.dashboardService = dashboardService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("customerCount", dashboardService.getCustomerCount());
        model.addAttribute("productCount", dashboardService.getProductCount());
        model.addAttribute("orderCount", dashboardService.getOrderCount());
        model.addAttribute("outOfStockCount", dashboardService.getOutOfStockCount());
        model.addAttribute("outOfStockProducts", productService.getOutOfStockProducts());
        return "index";
    }
}