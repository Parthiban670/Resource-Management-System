package com.innoverasolutions.resource_management.controller;

import com.innoverasolutions.resource_management.model.Payment;
import com.innoverasolutions.resource_management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String listPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payments/list";
    }

    @GetMapping("/add")
    public String addPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payments/add";
    }

    @PostMapping("/add")
    public String savePayment(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/edit/{id}")
    public String editPaymentForm(@PathVariable Long id, Model model) {
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "payments/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePayment(@PathVariable Long id, @ModelAttribute Payment payment) {
        payment.setId(id);
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "redirect:/payments";
    }

}

