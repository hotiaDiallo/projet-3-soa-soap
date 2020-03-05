package com.ib.library.service.batch;

import com.ib.library.model.Loan;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobTasklet implements Tasklet {

    @Autowired
    public LateLoan lateLoan;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<Loan> loans = this.lateLoan.findAllLateLoansByUser("ibrah");
        EmailService service = new EmailService();

        for (Loan loan : loans) {
            String to = loan.getUser().getEmail();
            String subject = "Return date exceeded for the book";
            String text = "Return date exceeded for the book";

            service.sendSimpleMessage(to, subject, text);
            //LOGGER.info("Message correctly sent to the user: " + loan.getUser().getFirstName() + " " + loan.getUser().getLastName());
        }
        return RepeatStatus.FINISHED;
    }
}
