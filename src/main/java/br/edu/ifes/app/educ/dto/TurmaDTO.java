/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import br.edu.ifes.app.educ.model.Turma;
import java.io.Serializable;
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
public class TurmaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codTurm;
    
    private String nomeTurm;
    
    private Integer exercicio;
    
    private EmebDTO emeb;
    
    public TurmaDTO(Turma turma) {
        this.codTurm = turma.getCodTurm();
        this.nomeTurm = turma.getNomeTurm();
        this.exercicio = turma.getExercicio();
        this.emeb = new EmebDTO(turma.getEmeb());
    }
    
}
