/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.GradeCurricular;
import br.edu.ifes.app.educ.model.NotaTrimestral;
import br.edu.ifes.app.educ.model.view.Boletim;
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

    private Integer qtdFaltas;
    private Character tipoAvaliacao;
    private Character resultado;
    private String descricao;
    private Double nota;
    private Double notaRec;
    private Integer periodo;
    private String disciplina;

    private BoletimDTO(Boletim b) {
        this.disciplina = b.getDISCIPLINA();
        this.qtdFaltas = b.getFALTA();
        this.tipoAvaliacao = b.getFRAVTIPOAVALIACAO();
        this.resultado = b.getRESULTADO();
        this.periodo = b.getNUMPERIODO();
        this.descricao = b.getDESCRICAO();
        this.nota = b.getNOTA();
        this.notaRec = b.getN_RECUPERACAO();
        this.disciplina = b.getDISCIPLINA();
    }

    public static List<BoletimDTO> gerarBoletim(List<Boletim> listNotas) {
        List<BoletimDTO> list = new ArrayList<>();
        for (Boletim b : listNotas) {
            list.add(new BoletimDTO(b));
        }

        return list;
    }

}
