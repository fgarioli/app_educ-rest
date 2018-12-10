/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.Frequencia;
import java.io.Serializable;
import java.time.LocalDate;
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
public class FrequenciaAulaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private LocalDate data;
    
    private String conteudo;
    
    private Boolean presenca;
    
    private Integer periodo;
    
    private Integer tempo;
    
    public FrequenciaAulaDTO(Frequencia f) {
        this.data = f.getPauta().getDataPauta();
        this.conteudo = f.getPauta().getConteudo();
        this.presenca = f.isPresenca();
        this.periodo = f.getPauta().getPeriodo();
        this.tempo = f.getTempo().getTempo();
    }
    
}
