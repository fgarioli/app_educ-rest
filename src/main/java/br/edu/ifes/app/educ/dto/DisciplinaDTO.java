/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.Disciplina;
import br.edu.ifes.app.educ.model.GradeHoraria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
public class DisciplinaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String disciplina;

    public static List<DisciplinaDTO> gerarListDiscGrhr(List<Disciplina> listDisc) {
        List<DisciplinaDTO> list = new ArrayList<>();

        for (Disciplina d : listDisc) {
            DisciplinaDTO dTO = new DisciplinaDTO(d.getCodDisc(), d.getNomeDisc());
        }

        return list;
    }

}
