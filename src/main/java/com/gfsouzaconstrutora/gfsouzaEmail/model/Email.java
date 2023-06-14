package com.gfsouzaconstrutora.gfsouzaEmail.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email {

    private String remetente;
    private String destinatario;
    private String assunto;
    private String nome;
    private String email;
    private String telefone;
    private String mensagem;
}
