/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.NotaTrimestral;
import br.edu.ifes.app.educ.repository.NotaTrimestralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class NotaTrimestralService {
    
    @Autowired
    private NotaTrimestralRepository notaTrimestralRepository;
    
    public List<NotaTrimestral> findByTurmAlunId(Integer codTurmAlun) {
        return notaTrimestralRepository.findByTurmAlunId(codTurmAlun);
    }
    
    public List<NotaTrimestral> findByTurmAlunIdTrimestre(Integer codTurmAlun, Integer trimestre) {
        return notaTrimestralRepository.findByTurmAlunIdTrimestre(codTurmAlun, trimestre.shortValue());
    }
    
}
