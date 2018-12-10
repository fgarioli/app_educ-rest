/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.NotaTrimestral;
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
public interface NotaTrimestralRepository extends JpaRepository<NotaTrimestral, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM NotaTrimestral obj WHERE obj.turmAlun.codTurmAlun = :turmAlunId GROUP BY obj.gradeCurricular.disciplina.nomeDisc ORDER BY obj.periodo.numPeriodo")
    public List<NotaTrimestral> findByTurmAlunId(@Param("turmAlunId") Integer turmAlunId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM NotaTrimestral obj WHERE obj.turmAlun.codTurmAlun = :turmAlunId AND obj.periodo.numPeriodo = :trimestre GROUP BY obj.gradeCurricular.disciplina.nomeDisc ORDER BY obj.periodo.numPeriodo")
    public List<NotaTrimestral> findByTurmAlunIdTrimestre(@Param("turmAlunId") Integer turmAlunId, @Param("trimestre") Short trimestre);

}
