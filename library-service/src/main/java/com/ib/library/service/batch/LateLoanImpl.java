package com.ib.library.service.batch;

import com.ib.library.model.Loan;
import com.ib.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LateLoanImpl implements LateLoan {

    @Autowired
    public LoanRepository loanRepository;


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<Loan> findAllLateLoansByUser(String email) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        List<Loan> loans = loanRepository.findLoanByUser_email(email);
        List<Loan> lateLoans = new ArrayList<>();
        for(Loan loan : loans){
            if (loan.getReturningDate().after(currentDate)){
                lateLoans.add(loan);
            }
        }
        return lateLoans;
    }

    public void sendEmail(String email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("");
        msg.setText("Hello," +"\n" +
                "you have exceeded the deadline for your book by 2 days");

        javaMailSender.send(msg);

    }
}
