package com.omkar.library_api.controllers;

import com.omkar.library_api.model.Loan;
import com.omkar.library_api.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping("/issue")
    public Loan issueBook(@RequestBody Loan loan) {
        return service.issueBook(loan);
    }

    @GetMapping("/fine/{id}")
    public long calculateFine(@PathVariable Long id) {
        return service.calculateFine(id);
    }
}
