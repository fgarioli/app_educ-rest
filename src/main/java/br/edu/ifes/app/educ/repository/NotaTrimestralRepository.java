/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.NotaTrimestral;
import br.edu.ifes.app.educ.model.view.Boletim;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fernando
 */
@Repository
public interface NotaTrimestralRepository extends JpaRepository<NotaTrimestral, Integer> {

//    @Transactional(readOnly = true)
//    @Query(value = "SELECT obj FROM NotaTrimestral obj WHERE obj.turmAlun.codTurmAlun = :turmAlunId ORDER BY obj.periodo.numPeriodo")
//    public List<NotaTrimestral> findByTurmAlunId(@Param("turmAlunId") Integer turmAlunId);
//
//    @Transactional(readOnly = true)
//    @Query(value = "SELECT obj FROM NotaTrimestral obj WHERE obj.turmAlun.codTurmAlun = :turmAlunId AND obj.periodo.numPeriodo = :trimestre ORDER BY obj.periodo.numPeriodo")
//    public List<NotaTrimestral> findByTurmAlunIdTrimestre(@Param("turmAlunId") Integer turmAlunId, @Param("trimestre") Short trimestre);

    @Query(nativeQuery = true, value = "SELECT * FROM BOLETIM_ALUNO WHERE EXERCICIO = :exercicio AND MATRCODIGO = :matrcodigo ORDER BY NUMPERIODO, DISCIPLINA")
    List<Boletim> getBoletim(@Param("exercicio") Integer exercicio, @Param("matrcodigo") Integer matrcodigo);
    
    @Query(nativeQuery = true, value = "SELECT * FROM BOLETIM_ALUNO WHERE EXERCICIO = :exercicio AND MATRCODIGO = :matrcodigo AND NUMPERIODO = :trimestre ORDER BY NUMPERIODO, DISCIPLINA")
    List<Boletim> getBoletimByTrimestre(@Param("exercicio") Integer exercicio, @Param("matrcodigo") Integer matrcodigo, @Param("trimestre") Integer trimestre);

}
