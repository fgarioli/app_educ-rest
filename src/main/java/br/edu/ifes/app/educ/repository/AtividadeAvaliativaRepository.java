/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.AtividadeAvaliativa;
import br.edu.ifes.app.educ.model.view.AtividadeView;
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
public interface AtividadeAvaliativaRepository extends JpaRepository<AtividadeAvaliativa, Integer> {
    
    @Transactional(readOnly = true)
    @Query(nativeQuery = true,
            value = "SELECT * FROM NOTA_ATIVIDADE WHERE DISCCODIGO = :disccodigo AND ALUNCODIGO = :aluncodigo AND EXERCICIO = :exercicio AND ATIVPERIODO = :trimestre")
    public List<AtividadeView> findByAlunoExercicioTrimestreDisciplina(@Param("aluncodigo") Integer aluncodigo, @Param("exercicio") Integer exercicio, @Param("trimestre") Integer trimestre, @Param("disccodigo") Integer disccodigo);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT DISTINCT(af.DISCCODIGO), d.DISCDESCR FROM NOTA_ATIVIDADE af, EDDISC d WHERE af.ALUNCODIGO = :aluncodigo AND af.EXERCICIO = :exercicio AND af.ATIVPERIODO = :trimestre AND d.DISCCODIGO = af.DISCCODIGO ORDER BY d.DISCDESCR")
    public List<Object[]> findByAlunoExercicioTrimestre(@Param("aluncodigo") Integer aluncodigo, @Param("exercicio") Integer exercicio, @Param("trimestre") Integer trimestre);

}
