package com.innoverasolutions.resource_management.controller;

import com.innoverasolutions.resource_management.model.Investment;
import com.innoverasolutions.resource_management.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    // Display all investments
    @GetMapping
    public String getAllInvestments(Model model) {
        model.addAttribute("investments", investmentService.getAllInvestments());
        return "investments/list";  // Thymeleaf template for listing investments
    }

    // Show form to add a new investment
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("investment", new Investment());
        return "investments/add";  // Thymeleaf template for adding new investment
    }

    // Save a new investment
    @PostMapping
    public String addInvestment(@ModelAttribute Investment investment) {
        investmentService.addInvestment(investment);
        return "redirect:/investments";  // Redirect to the list of investments
    }

    // Show form to edit an existing investment
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Investment investment = investmentService.getInvestmentById(id).orElseThrow();
        model.addAttribute("investment", investment);
        return "investments/edit";  // Thymeleaf template for editing investment
    }

    // Update an existing investment
    @PostMapping("/edit/{id}")
    public String updateInvestment(@PathVariable("id") Long id, @ModelAttribute Investment investment) {
        investment.setId(id);
        investmentService.updateInvestment(investment);
        return "redirect:/investments";  // Redirect to the list of investments
    }

    // Delete an investment
    @GetMapping("/delete/{id}")
    public String deleteInvestment(@PathVariable("id") Long id) {
        investmentService.deleteInvestment(id);
        return "redirect:/investments";  // Redirect to the list of investments
    }
}
