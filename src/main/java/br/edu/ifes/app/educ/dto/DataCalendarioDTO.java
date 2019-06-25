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

    private String tipoCale;

    private Integer periodoCale;

    private String idCale;

    public DataCalendarioDTO(DataCalendario data) {
        this.codCale = data.getCodCale();
        this.dataCale = data.getDataCale();
        this.descrCale = data.getDescrCale();
        this.tipoCale = getTipo(data.getTipoCale());
        this.periodoCale = data.getPeriodoCale();
        this.idCale = data.getTipoCale() != null ? data.getTipoCale().toString() : null;
    }

    private String getTipo(Character tipo) {
        switch (tipo) {
            case 'D':
                return "DIA LETIVO";
            case 'I':
                return "INÍCIO DO ANO LETIVO";
            case 'N':
                return "FERIADO NACIONAL";
            case 'U':
                return "PONTO FACULTATIVO";
            case 'T':
                return "FIM DO TRIMESTRE";
            case 'E':
                return "RECESSO";
            case 'P':
                return "PLANEJAMENTO";
            case 'R':
                return "RESULTADO FINAL";
            case 'Z':
                return "CONSELHO DE CLASSE";
            case 'X':
                return "PLANTÃO PEDAGÓGICO";
            case 'L':
                return "RECUPERAÇÃO FINAL";
            default:
                return "";
        }
    }

}
