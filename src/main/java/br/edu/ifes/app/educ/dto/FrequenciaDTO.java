/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.Disciplina;
import br.edu.ifes.app.educ.model.Frequencia;
import br.edu.ifes.app.educ.model.GradeHoraria;
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
public class FrequenciaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String disciplina;
    
    private Integer totalAulas;
    
    private Integer totalFaltas = 0;
    
    List<FrequenciaAulaDTO> listFreq = new ArrayList<>();
    
    private FrequenciaDTO(Disciplina disc, List<Frequencia> list) {
        this.disciplina = disc.getNomeDisc();
        this.totalAulas = list.size();
        for (Frequencia f : list) {
            if (!f.isPresenca()) {
                totalFaltas++;
            }
            listFreq.add(new FrequenciaAulaDTO(f));
        }
    }
    
    public static List<FrequenciaDTO> gerarFrequenciasDTO(List<Frequencia> listFreq) {
        List<GradeHoraria> listGrade = new ArrayList<>();
        for (Frequencia f : listFreq) {
            if (!listGrade.contains(f.getPauta().getGradeHoraria())) {
                listGrade.add(f.getPauta().getGradeHoraria());
            }
        }
        
        List<FrequenciaDTO> listFreqDTO = new ArrayList<>();
        for (GradeHoraria gh : listGrade) {
            List<Frequencia> listFreqGrade = new ArrayList<>();
            for (Frequencia f : listFreq) {
                if (f.getPauta().getGradeHoraria().equals(gh)) {
                    listFreqGrade.add(f);
                }
            }
            
            if (!listFreqGrade.isEmpty()) {
                listFreqDTO.add(new FrequenciaDTO(gh.getGradeCurricular().getDisciplina(), listFreqGrade));
            }
        }
        
        return listFreqDTO;
    }
    
}
