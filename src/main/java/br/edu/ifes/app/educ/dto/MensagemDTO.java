/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.MensagemUsuario;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fernando
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long codMsg;
    
    private String assunto;
    
    private String mensagem;
    
    private String remetente;
    
    public MensagemDTO(MensagemUsuario msg) {
        this.codMsg = msg.getCodMsgUs();
        this.assunto = msg.getMensagem().getAssunto();
        this.mensagem = msg.getMensagem().getMensagem();
        this.remetente = msg.getMensagem().getRemetente().getPessoa().getNomePess();
    }
    
}
