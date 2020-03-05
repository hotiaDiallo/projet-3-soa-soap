package com.ib.library.service.batch;

import com.ib.library.model.Loan;

import java.util.List;

public interface LateLoan {
    List<Loan> findAllLateLoansByUser(String email);
    void sendEmail(String email);
}
