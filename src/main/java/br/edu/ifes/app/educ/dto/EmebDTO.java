/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.Emeb;
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
public class EmebDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codEmeb;
    
    private String nomeEmeb;
    
    private EnderecoDTO endereco;
    
    public EmebDTO(Emeb emeb) {
        this.codEmeb = emeb.getCodEmeb();
        this.nomeEmeb = emeb.getNomeEmeb();
        this.endereco = new EnderecoDTO(emeb.getCep(), emeb.getNumero());
    }
    
}
