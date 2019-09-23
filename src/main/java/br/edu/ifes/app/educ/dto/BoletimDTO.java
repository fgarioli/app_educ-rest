/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.GradeCurricular;
import br.edu.ifes.app.educ.model.NotaTrimestral;
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
public class BoletimDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String disciplina;

    private Double notaTrim1;

    private Double notaTrim2;

    private Double notaTrim3;

    private Double recTrim1;

    private Double recTrim2;

    private Double recTrim3;

    private Integer faltasTrim1;

    private Integer faltasTrim2;

    private Integer faltasTrim3;

    private Double notaAnual = 0.0;

    private Integer totalFaltas = 0;

    private BoletimDTO(GradeCurricular grade, List<NotaTrimestral> listNotas) {
        this.disciplina = grade.getDisciplina().getNomeDisc();

        for (NotaTrimestral nt : listNotas) {
            notaAnual += nt.getNotaValor() == null ? 0 : nt.getNotaValor();
            totalFaltas += nt.getQtdFaltas();
            if (nt.getPeriodo().getNumPeriodo().equals(new Short("1"))) {
                notaTrim1 = nt.getNotaValor() == null ? 0 : nt.getNotaValor();
                recTrim1 = nt.getNotaRecuperacao() == null ? 0 : nt.getNotaRecuperacao();
                faltasTrim1 = nt.getQtdFaltas();
            } else if (nt.getPeriodo().getNumPeriodo().equals(new Short("2"))) {
                notaTrim2 = nt.getNotaValor() == null ? 0 : nt.getNotaValor();
                recTrim2 = nt.getNotaRecuperacao() == null ? 0 : nt.getNotaRecuperacao();
                faltasTrim3 = nt.getQtdFaltas();
            } else if (nt.getPeriodo().getNumPeriodo().equals(new Short("3"))) {
                notaTrim3 = nt.getNotaValor() == null ? 0 : nt.getNotaValor();
                recTrim3 = nt.getNotaRecuperacao() == null ? 0 : nt.getNotaRecuperacao();
                faltasTrim3 = nt.getQtdFaltas();
            }
        }
    }

    public static List<BoletimDTO> gerarBoletim(List<NotaTrimestral> listNotas) {
        List<GradeCurricular> listGrcu = new ArrayList<>();
        for (NotaTrimestral nt : listNotas) {
            if (!listGrcu.contains(nt.getGradeCurricular())) {
                listGrcu.add(nt.getGradeCurricular());
            }
        }

        List<BoletimDTO> listBoletim = new ArrayList<>();

        for (GradeCurricular gc : listGrcu) {
            List<NotaTrimestral> listNotasGrcu = new ArrayList<>();
            for (NotaTrimestral nt : listNotas) {
                if (nt.getGradeCurricular().equals(gc)) {
                    listNotasGrcu.add(nt);
                }
            }

            if (!listNotasGrcu.isEmpty()) {
                listBoletim.add(new BoletimDTO(gc, listNotasGrcu));
            }
        }

        return listBoletim;
    }

}
