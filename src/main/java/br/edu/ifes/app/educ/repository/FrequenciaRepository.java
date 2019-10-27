/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.Frequencia;
import br.edu.ifes.app.educ.model.view.FrequenciaView;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Query(nativeQuery = true,
            value = "SELECT * FROM ALUNO_FREQUENCIA WHERE DISCCODIGO = :disccodigo AND ALUNCODIGO = :aluncodigo AND EXERCICIO = :exercicio AND PAUTAPERIODO = :trimestre",
            countQuery = "SELECT count(*) FROM ALUNO_FREQUENCIA WHERE DISCCODIGO = :disccodigo AND ALUNCODIGO = :aluncodigo AND EXERCICIO = :exercicio AND PAUTAPERIODO = :trimestre")
    public Page<FrequenciaView> findByAlunoExercicioTrimestreDisciplina(@Param("aluncodigo") Integer aluncodigo, @Param("exercicio") Integer exercicio, @Param("trimestre") Integer trimestre, @Param("disccodigo") Integer disccodigo, Pageable pageable);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT DISTINCT(af.DISCCODIGO), d.DISCDESCR FROM ALUNO_FREQUENCIA af, EDDISC d WHERE af.ALUNCODIGO = :aluncodigo AND af.EXERCICIO = :exercicio AND af.PAUTAPERIODO = :trimestre AND d.DISCCODIGO = AF.DISCCODIGO ORDER BY d.DISCDESCR")
    public List<Object[]> findByAlunoExercicioTrimestre(@Param("aluncodigo") Integer aluncodigo, @Param("exercicio") Integer exercicio, @Param("trimestre") Integer trimestre);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT SUM(QT_FALTA) FROM ALUNO_FREQUENCIA WHERE ALUNCODIGO = :aluncodigo AND EXERCICIO = :exercicio AND PAUTAPERIODO = :trimestre")
    public BigDecimal getFaltasByTrimetre(@Param("aluncodigo") Integer aluncodigo, @Param("exercicio") Integer exercicio, @Param("trimestre") Integer trimestre);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "SELECT SUM(QT_FALTA) FROM ALUNO_FREQUENCIA WHERE ALUNCODIGO = :aluncodigo AND EXERCICIO = :exercicio AND PAUTAPERIODO = :trimestre AND DISCCODIGO = :disccodigo")
    public BigDecimal getFaltasByTrimetreDisciplina(@Param("aluncodigo") Integer aluncodigo, @Param("exercicio") Integer exercicio, @Param("trimestre") Integer trimestre, @Param("disccodigo") Integer disccodigo);

}
