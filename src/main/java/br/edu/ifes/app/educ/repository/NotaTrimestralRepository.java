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
import br.edu.ifes.app.educ.model.view.BoletimView;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernando
 */
@Repository
public interface NotaTrimestralRepository extends JpaRepository<NotaTrimestral, Integer> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT * FROM BOLETIM_ALUNO WHERE EXERCICIO = :exercicio AND MATRCODIGO = :matrcodigo ORDER BY NUMPERIODO, DISCIPLINA")
    List<BoletimView> getBoletim(@Param("exercicio") Integer exercicio, @Param("matrcodigo") Integer matrcodigo);
    
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT * FROM BOLETIM_ALUNO WHERE EXERCICIO = :exercicio AND MATRCODIGO = :matrcodigo AND NUMPERIODO = :trimestre ORDER BY NUMPERIODO, DISCIPLINA")
    List<BoletimView> getBoletimByTrimestre(@Param("exercicio") Integer exercicio, @Param("matrcodigo") Integer matrcodigo, @Param("trimestre") Integer trimestre);

}
