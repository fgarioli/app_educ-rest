/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.view.FrequenciaView;
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
public class FrequenciaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer qtdFaltas;

    private String conteudo;

    private LocalDate dataAula;

    public FrequenciaDTO(FrequenciaView fv) {
        this.conteudo = fv.getPAUTACONTEUDO();
        this.qtdFaltas = fv.getQT_FALTA();
        this.dataAula = fv.getPAUTADATA();
    }

}
