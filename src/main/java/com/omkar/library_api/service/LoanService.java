package com.omkar.library_api.service;

import com.omkar.library_api.model.Loan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class LoanService {

    private Map<Long, Loan> loans = new HashMap<>();
    private Long idCounter = 1L;

    public Loan issueBook(Loan loan) {
        loan.setId(idCounter++);
        loan.setIssueDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(7));
        loans.put(loan.getId(), loan);
        return loan;
    }

    public long calculateFine(Long loanId) {

        Loan loan = loans.get(loanId);

        if (loan == null || loan.getReturnDate() == null) {
            return 0;
        }

        long daysLate = ChronoUnit.DAYS.between(
                loan.getDueDate(),
                loan.getReturnDate()
        );

        return daysLate > 0 ? daysLate * 10 : 0;
    }
}
