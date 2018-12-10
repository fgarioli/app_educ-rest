/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.AtividadeAvaliativa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernando
 */
@Repository
public interface AtividadeAvaliativaRepository extends JpaRepository<AtividadeAvaliativa, Integer>{
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM AtividadeAvaliativa obj, TurmAlun tln WHERE obj.gradeHoraria.turma = tln.turma AND tln.codTurmAlun = :turmAlunId")
    public List<AtividadeAvaliativa> findByTurmAlunId(@Param("turmAlunId") Integer turmAlunId);
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM AtividadeAvaliativa obj, TurmAlun tln WHERE obj.gradeHoraria.turma = tln.turma AND tln.codTurmAlun = :turmAlunId AND obj.periodo = :trimestre")
    public List<AtividadeAvaliativa> findByTurmAlunIdTrimestre(@Param("turmAlunId") Integer turmAlunId, @Param("trimestre") Integer trimestre);
    
}
