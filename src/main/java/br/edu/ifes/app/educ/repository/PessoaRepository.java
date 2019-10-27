/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.Pessoa;
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
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = ""
            + "SELECT (SELECT dm.DOMIDESCR FROM EDDOMI dm WHERE dm.DOMICODIGO = p.PESSGRAUESCOLARIDADEPAI) AS grau_pai,\n"
            + "       (SELECT dm.DOMIDESCR FROM EDDOMI dm WHERE dm.DOMICODIGO = p.PESSGRAUESCOLARIDADEMAE) AS grau_mae,\n"
            + "       a.ALUNGESTDURACAO AS duracao_gestacao,\n"
            + "       a.ALUNAUTISMO AS autismo,\n"
            + "       a.ALUNSUPERDOT AS superdotacao,\n"
            + "       a.ALUNBFAMILIA AS bolsa_familia,\n"
            + "       e.EMEBNOME AS escola,\n"
            + "       e.EMEBINTERNET AS escola_internet,\n"
            + "       e.EMEBEEINTEGRA AS escola_integral,\n"
            + "       p.PESSPAIVIVO AS pai_vivo,\n"
            + "       p.PESSMAEVIVA AS mae_viva,\n"
            + "       (SELECT dm.DOMIDESCR FROM EDDOMI dm WHERE dm.DOMICODIGO = p.PESSSEXO) AS sexo,\n"
            + "       (SELECT COUNT(fr.FREQCODIGO) FROM EDFREQUENCIA fr WHERE mt.MATRCODIGO = fr.MATRCODIGO) AS qtd_frequencia,\n"
            + "       (SELECT COUNT(fr.FREQCODIGO) FROM EDFREQUENCIA fr WHERE mt.MATRCODIGO = fr.MATRCODIGO AND FR.FREQPRESENCA = '1') AS qtd_presenca,\n"
            + "       (SELECT AVG(ba.NOTA) FROM BOLETIM_ALUNO ba WHERE ba.ALUNCODIGO = a.ALUNCODIGO AND (ba.DISCIPLINA = 'LÍNGUA PORTUGUESA' OR ba.DISCIPLINA = 'BNC - LÍNGUA PORTUGUESA')) AS media_portugues,\n"
            + "       (SELECT AVG(ba.NOTA) FROM BOLETIM_ALUNO ba WHERE ba.ALUNCODIGO = a.ALUNCODIGO AND (ba.DISCIPLINA = 'MATEMÁTICA' OR ba.DISCIPLINA = 'BNC - MATEMÁTICA')) AS media_matematica,\n"
            + "       (SELECT AVG(ba.NOTA) FROM BOLETIM_ALUNO ba WHERE ba.ALUNCODIGO = a.ALUNCODIGO AND (ba.DISCIPLINA = 'HISTÓRIA' OR ba.DISCIPLINA = 'BNC - HISTÓRIA')) AS media_historia,\n"
            + "       (SELECT AVG(ba.NOTA) FROM BOLETIM_ALUNO ba WHERE ba.ALUNCODIGO = a.ALUNCODIGO AND (ba.DISCIPLINA = 'GEOGRAFIA' OR ba.DISCIPLINA = 'BNC - GEOGRAFIA')) AS media_geografia,\n"
            + "       (SELECT AVG(ba.NOTA) FROM BOLETIM_ALUNO ba WHERE ba.ALUNCODIGO = a.ALUNCODIGO AND (ba.DISCIPLINA = 'CIÊNCIAS' OR ba.DISCIPLINA = 'BNC - CIÊNCIAS')) AS media_ciencias    \n"
            + "  FROM EDPESS p,\n"
            + "       EDALUN a,\n"
            + "       EDMATR mt,\n"
            + "       EDTURMALUN tm,\n"
            + "       EDTURM t,\n"
            + "       EDEMEB e\n"
            + " WHERE tm.TURMCODIGO = t.TURMCODIGO\n"
            + "   AND t.EMEBCODIGO = e.EMEBCODIGO\n"
            + "   AND tm.MATRCODIGO = mt.MATRCODIGO\n"
            + "   AND mt.ALUNCODIGO = a.ALUNCODIGO\n"
            + "   AND a.PESSCODIGO = p.PESSCODIGO\n"
            + "   AND tm.TMALCODIGO = :idTurmAlun")
    List<Object[]> getAlunInfo(@Param("idTurmAlun") Integer idTurmAlun);
}
