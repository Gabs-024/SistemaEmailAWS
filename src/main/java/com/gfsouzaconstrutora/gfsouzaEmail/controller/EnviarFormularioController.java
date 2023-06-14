package com.gfsouzaconstrutora.gfsouzaEmail.controller;

import com.gfsouzaconstrutora.gfsouzaEmail.model.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EnviarFormularioController {
    private final JavaMailSender mailSender;
    private final String remetente;
    private final String destinatario;

    public EnviarFormularioController(JavaMailSender mailSender,
                                      @Value("${mail.remetente}") String remetente,
                                      @Value("${mail.destinatario}") String destinatario) {
        this.mailSender = mailSender;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }
    @PostMapping("/enviar")
    public ModelAndView enviarFormulario(@RequestBody Email emailForm) {
        String remetente = emailForm.getRemetente();
        String destinatario = emailForm.getDestinatario();
        String assunto = emailForm.getAssunto();
        String nome = emailForm.getNome();
        String email = emailForm.getEmail();
        String telefone = emailForm.getTelefone();
        String mensagem = emailForm.getMensagem();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(remetente);
        message.setTo(destinatario);
        message.setSubject(assunto);
        message.setText("Nome: " + nome +
                        "\nE-mail: " + email +
                        "\nTelefone: " + telefone +
                        "\nMensagem: " + mensagem);

        mailSender.send(message);

        ModelAndView modelAndView = new ModelAndView("enviarFormulario");
        modelAndView.addObject("mensagem", "Email enviado com sucesso!");
        return modelAndView;
    }

    @RequestMapping("/")
    public String exibirFormulario() {
        return "enviarFormulario";
    }
}
