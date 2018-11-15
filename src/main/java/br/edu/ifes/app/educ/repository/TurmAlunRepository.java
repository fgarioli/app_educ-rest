/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.TurmAlun;
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
public interface TurmAlunRepository extends JpaRepository<TurmAlun, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM TurmAlun obj, Vinculo vin WHERE obj.matricula.aluno = vin.aluno AND vin.responsavel.codResp = :respId AND obj.turma.exercicio = :ano")
    public List<TurmAlun> findByResponsavel(@Param("respId") Integer respId, @Param("ano") Integer ano);

}
