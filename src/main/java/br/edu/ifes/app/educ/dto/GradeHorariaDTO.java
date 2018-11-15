/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.model.Tempo;
import java.io.Serializable;
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
public class GradeHorariaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private TurmaDTO turma;

    private List<TempoDTO> listaTempos = new ArrayList<>();

    public GradeHorariaDTO(List<GradeHoraria> listGrade) {
        if (listGrade != null && !listGrade.isEmpty()) {
            this.turma = new TurmaDTO(listGrade.get(0).getTurma());
            listGrade.forEach((gh) -> {
                gh.getTempos().forEach((tp) -> {
                    listaTempos.add(new TempoDTO(tp));
                });
            });
        }
    }

}
