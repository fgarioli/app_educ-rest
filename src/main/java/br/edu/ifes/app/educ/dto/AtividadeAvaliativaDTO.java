/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.view.AtividadeView;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class AtividadeAvaliativaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String descricao;

    private LocalDate data;

    private Double valor;

    private Double nota;

    private String notaDescr;

    private AtividadeAvaliativaDTO(AtividadeView ativ) {
        this.descricao = ativ.getDESCRICAO();
        this.data = ativ.getATIVDATA();
        this.valor = ativ.getATIVVALOR();
        this.nota = ativ.getNOTAATIV();
        this.notaDescr = ativ.getNOTADESCR();
    }

    public static List<AtividadeAvaliativaDTO> getList(List<AtividadeView> listAtiv) {
        List<AtividadeAvaliativaDTO> lista = new ArrayList<>();
        listAtiv.forEach((aa) -> {
            lista.add(new AtividadeAvaliativaDTO(aa));
        });

        return lista;
    }

}
