/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.repository.GradeHorariaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class GradeHorariaService {
    
    @Autowired
    private GradeHorariaRepository gradeHorariaRepository;
    
    public List<GradeHoraria> findByTurmAlun(Integer codTurmAlun) {
        return gradeHorariaRepository.findByTurmAlun(codTurmAlun);
    }
    
}
