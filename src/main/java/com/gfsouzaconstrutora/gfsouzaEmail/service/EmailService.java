package com.gfsouzaconstrutora.gfsouzaEmail.service;

import com.gfsouzaconstrutora.gfsouzaEmail.model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    public JavaMailSender javaMailSender;

    public void enviarEmail (Email email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);

        mimeMessageHelper.setFrom(email.getRemetente());
        mimeMessageHelper.setTo(email.getDestinatario());
        mimeMessageHelper.setSubject(email.getAssunto());
        mimeMessageHelper.setText(email.getNome());
        mimeMessageHelper.setText(email.getEmail());
        mimeMessageHelper.setText(email.getTelefone());
        mimeMessageHelper.setText(email.getMensagem());

        javaMailSender.send(message);
    }
}
