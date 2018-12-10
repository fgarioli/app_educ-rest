/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.GradeHoraria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fernando
 */
@Data
@NoArgsConstructor
public class GradeHorariaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

//    private TurmaDTO turma;
    private List<DiaSemanaDTO> diasSemana = new ArrayList<>();

    private List<TempoDTO> tempos = new ArrayList<>();

    public GradeHorariaDTO(List<GradeHoraria> listGrade) {
        if (listGrade != null && !listGrade.isEmpty()) {
//            this.turma = new TurmaDTO(listGrade.get(0).getTurma());
            listGrade.forEach((gh) -> {
                gh.getTempos().forEach((tp) -> {
                    tempos.add(new TempoDTO(tp));

                    switch (tp.getDiaSemana()) {
                        case 1:
                            if (!diasSemana.contains(DiaSemanaDTO.DOMINGO)) {
                                diasSemana.add(DiaSemanaDTO.DOMINGO);
                            }
                            break;
                        case 2:
                            if (!diasSemana.contains(DiaSemanaDTO.SEGUNDA)) {
                                diasSemana.add(DiaSemanaDTO.SEGUNDA);
                            }
                            break;
                        case 3:
                            if (!diasSemana.contains(DiaSemanaDTO.TERCA)) {
                                diasSemana.add(DiaSemanaDTO.TERCA);
                            }
                            break;
                        case 4:
                            if (!diasSemana.contains(DiaSemanaDTO.QUARTA)) {
                                diasSemana.add(DiaSemanaDTO.QUARTA);
                            }
                            break;
                        case 5:
                            if (!diasSemana.contains(DiaSemanaDTO.QUINTA)) {
                                diasSemana.add(DiaSemanaDTO.QUINTA);
                            }
                            break;
                        case 6:
                            if (!diasSemana.contains(DiaSemanaDTO.SEXTA)) {
                                diasSemana.add(DiaSemanaDTO.SEXTA);
                            }
                            break;
                        case 7:
                            if (!diasSemana.contains(DiaSemanaDTO.SABADO)) {
                                diasSemana.add(DiaSemanaDTO.SABADO);
                            }
                            break;
                        default:
                            break;
                    }
                });
            });
        }
    }

}
