/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.repository.NotaTrimestralRepository;
import br.edu.ifes.app.educ.repository.TurmAlunRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifes.app.educ.model.view.BoletimView;

/**
 *
 * @author fernando
 */
@Service
public class NotaTrimestralService {
    
    @Autowired
    private NotaTrimestralRepository notaTrimestralRepository;
    
    @Autowired
    private TurmAlunRepository turmAlunRepository;
    
    public List<BoletimView> findByTurmAlunId(Integer codTurmAlun) {
        TurmAlun ta = turmAlunRepository.getOne(codTurmAlun);
        return notaTrimestralRepository.getBoletim(ta.getTurma().getExercicio(), ta.getMatricula().getCodMatr());
    }
    
    public List<BoletimView> findByTurmAlunIdTrimestre(Integer codTurmAlun, Integer trimestre) {
        TurmAlun ta = turmAlunRepository.getOne(codTurmAlun);
        return notaTrimestralRepository.getBoletimByTrimestre(ta.getTurma().getExercicio(), ta.getMatricula().getCodMatr(), trimestre);
    }
    
}
