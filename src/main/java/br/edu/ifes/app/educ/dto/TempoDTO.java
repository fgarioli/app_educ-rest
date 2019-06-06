/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.model.Tempo;
import java.io.Serializable;
import java.util.Comparator;
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
public class TempoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String docente;

    private String disciplina;

    private Integer diaSemana;

    private Integer tempo;

    private String turno;

    public TempoDTO(Tempo tp) {
        this.docente = tp.getGradeHoraria().getDocente().getFuncionario().getPessoa().getNomePess();
        this.disciplina = tp.getGradeHoraria().getGradeCurricular().getDisciplina().getNomeDisc();
        this.diaSemana = tp.getDiaSemana();
        this.tempo = tp.getTempo();
        this.turno = tp.getGradeHoraria().getTurma().getTurno().getTurndescr();
    }

    public static Comparator<TempoDTO> tempoComparator = (TempoDTO t1, TempoDTO t2) -> t1.tempo - t2.tempo;

}
