package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.Investment;
import com.innoverasolutions.resource_management.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    // Add a new investment
    public Investment addInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    // Update an existing investment
    public Investment updateInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    // Delete an investment by ID
    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }

    // Get all investments
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    // Get a specific investment by ID
    public Optional<Investment> getInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }
}
