/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.Cep;
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
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String numero;

    private String rua;
    
    private String bairro;
    
    private String cidade;
    
    private String uf;
    
    private String cep;
    
    public EnderecoDTO(Cep cep, String numero) {
        this.numero = numero;
        this.rua = cep.getDescrCep();
        this.bairro = cep.getBairro().getNomeBair();
        this.cidade = cep.getBairro().getCidade().getNomeCidade();
        this.uf = cep.getBairro().getCidade().getEstado().getSiglaEstado();
        this.cep = cep.getCep();
    }

}
