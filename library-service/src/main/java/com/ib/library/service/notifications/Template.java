package com.ib.library.service.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class Template {

    @Autowired
    public JavaMailSender emailSender;

    MimeMessage message = emailSender.createMimeMessage();

    boolean multipart = true;

    MimeMessageHelper helper;
    {
        try {
            helper = new MimeMessageHelper(message, multipart, "utf-8");
            String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                    +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";

            message.setContent(htmlMsg, "text/html");

            helper.setTo(MyConstants.FRIEND_EMAIL);

            helper.setSubject("Test send HTML email");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
