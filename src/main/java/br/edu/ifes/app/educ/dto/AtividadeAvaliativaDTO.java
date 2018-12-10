/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.AtividadeAvaliativa;
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
    
    private Integer codAtiv;
    
    private LocalDate dataAtiv;
    
    private Integer periodo;
    
    private String tipo;
    
    private Double valor;
    
    private Double nota;
    
    private String notaDescr;
    
    private String disciplina;
    
    private AtividadeAvaliativaDTO(AtividadeAvaliativa ativAval) {
        this.codAtiv = ativAval.getCodAtivAval();
        this.dataAtiv = ativAval.getDataAtiv();
        this.periodo = ativAval.getPeriodo();
        this.tipo = ativAval.getTipoAtiv().getDescrDomi();
        this.valor = ativAval.getValor();
        this.disciplina = ativAval.getGradeHoraria().getGradeCurricular().getDisciplina().getNomeDisc();
        if (ativAval.getNotas() != null && !ativAval.getNotas().isEmpty()) {
            this.nota = ativAval.getNotas().get(0).getNotaValor();
            this.notaDescr = ativAval.getNotas().get(0).getNotaDescr();
        }        
    }
    
    public static List<AtividadeAvaliativaDTO> getList(List<AtividadeAvaliativa> listAtiv) {
        List<AtividadeAvaliativaDTO> lista = new ArrayList<>();
        listAtiv.forEach((aa) -> {
            lista.add(new AtividadeAvaliativaDTO(aa));
        });
        
        return lista;
    }
    
}
