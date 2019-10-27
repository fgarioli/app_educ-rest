/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.dto.DisciplinaDTO;
import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.model.view.AtividadeView;
import br.edu.ifes.app.educ.repository.AtividadeAvaliativaRepository;
import br.edu.ifes.app.educ.repository.TurmAlunRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class AtividadeAvaliativaService {

    @Autowired
    private AtividadeAvaliativaRepository ativAvalRepository;

    @Autowired
    private TurmAlunRepository turmAlunRepository;

    public List<AtividadeView> findByAlunoExercicioTrimestreDisciplina(Integer turmAlunId, Integer trimestre, Integer disccodigo) {
        TurmAlun ta = turmAlunRepository.getOne(turmAlunId);
        return ativAvalRepository.findByAlunoExercicioTrimestreDisciplina(ta.getMatricula().getAluno().getCodAlun(), ta.getTurma().getExercicio(), trimestre, disccodigo);
    }

    public List<DisciplinaDTO> getListDisciplina(Integer turmAlunId, Integer trimestre) {
        TurmAlun ta = turmAlunRepository.getOne(turmAlunId);
        
        List<DisciplinaDTO> listDisc = new ArrayList<>();
        List<Object[]> listData = ativAvalRepository.findByAlunoExercicioTrimestre(ta.getMatricula().getAluno().getCodAlun(), ta.getTurma().getExercicio(), trimestre);

        for (Object[] fv : listData) {
            listDisc.add(new DisciplinaDTO(((BigDecimal) fv[0]).intValue(), (String) fv[1]));
        }

        return listDisc;
    }

}
