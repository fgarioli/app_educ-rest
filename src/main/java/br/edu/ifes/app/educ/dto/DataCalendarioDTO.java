/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.DataCalendario;
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
public class DataCalendarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codCale;
    
    private LocalDate dataCale;
    
    private String descrCale;
    
    private Character tipoCale;
    
    private Integer periodoCale;
    
    public DataCalendarioDTO(DataCalendario data) {
        this.codCale = data.getCodCale();
        this.dataCale = data.getDataCale();
        this.descrCale = data.getDescrCale();
        this.tipoCale = data.getTipoCale();
        this.periodoCale = data.getPeriodoCale();
    }
    
}
