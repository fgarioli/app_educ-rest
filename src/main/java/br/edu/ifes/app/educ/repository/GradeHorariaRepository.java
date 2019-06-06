/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.GradeHoraria;
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
public interface GradeHorariaRepository extends JpaRepository<GradeHoraria, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM GradeHoraria obj, TurmAlun tml WHERE obj.turma.codTurm = tml.turma.codTurm AND tml.codTurmAlun = :codTurmAlun")
    public List<GradeHoraria> findByTurmAlun(@Param("codTurmAlun") Integer codTurmAlun);

}
