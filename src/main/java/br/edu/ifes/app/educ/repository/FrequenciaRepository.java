/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.Frequencia;
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
public interface FrequenciaRepository extends JpaRepository<Frequencia, Integer> {
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM Frequencia obj WHERE obj.notaTrimestral.turmAlun.codTurmAlun = :turmAlunId ORDER BY obj.pauta.dataPauta")
    public List<Frequencia> findByTurmAlunId(@Param("turmAlunId") Integer turmAlunId);

    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM Frequencia obj WHERE obj.notaTrimestral.turmAlun.codTurmAlun = :turmAlunId AND obj.notaTrimestral.periodo.numPeriodo = :trimestre ORDER BY obj.pauta.dataPauta, obj.notaTrimestral.periodo.numPeriodo")
    public List<Frequencia> findByTurmAlunIdTrimestre(@Param("turmAlunId") Integer turmAlunId, @Param("trimestre") Short trimestre);

}
