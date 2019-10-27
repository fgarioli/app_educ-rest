/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.dto.DisciplinaDTO;
import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.model.view.FrequenciaView;
import br.edu.ifes.app.educ.repository.FrequenciaRepository;
import br.edu.ifes.app.educ.repository.TurmAlunRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class FrequenciaService {

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    @Autowired
    private TurmAlunRepository turmAlunRepository;

    public Page<FrequenciaView> findByAlunoExercicioTrimestreDisciplina(Integer turmAlunId, Integer trimestre, Integer disccodigo, Pageable p) {
        TurmAlun ta = turmAlunRepository.getOne(turmAlunId);
        return frequenciaRepository.findByAlunoExercicioTrimestreDisciplina(ta.getMatricula().getAluno().getCodAlun(), ta.getTurma().getExercicio(), trimestre, disccodigo, p);
    }

    public List<DisciplinaDTO> getListDisciplina(Integer turmAlunId, Integer trimestre) {
        TurmAlun ta = turmAlunRepository.getOne(turmAlunId);
        List<DisciplinaDTO> listDisc = new ArrayList<>();
        List<Object[]> listData = frequenciaRepository.findByAlunoExercicioTrimestre(ta.getMatricula().getAluno().getCodAlun(), ta.getTurma().getExercicio(), trimestre);

        for (Object[] fv : listData) {
            listDisc.add(new DisciplinaDTO(((BigDecimal) fv[0]).intValue(), (String) fv[1]));
        }

        return listDisc;
    }

    public BigDecimal getFaltasByTrimetre(Integer turmAlunId, Integer trimestre) {
        TurmAlun ta = turmAlunRepository.getOne(turmAlunId);
        return this.frequenciaRepository.getFaltasByTrimetre(ta.getMatricula().getAluno().getCodAlun(), ta.getTurma().getExercicio(), trimestre);
    }

    public BigDecimal getFaltasByTrimetreDisciplina(Integer turmAlunId, Integer trimestre, Integer disccodigo) {
        TurmAlun ta = turmAlunRepository.getOne(turmAlunId);
        return this.frequenciaRepository.getFaltasByTrimetreDisciplina(ta.getMatricula().getAluno().getCodAlun(), ta.getTurma().getExercicio(), trimestre, disccodigo);
    }

}
