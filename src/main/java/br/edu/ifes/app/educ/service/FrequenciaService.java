/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.Frequencia;
import br.edu.ifes.app.educ.repository.FrequenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class FrequenciaService {
    
    @Autowired
    private FrequenciaRepository frequenciaRepository;
    
    public List<Frequencia> findByTurmAlunId(Integer turmAlunId) {
        return frequenciaRepository.findByTurmAlunId(turmAlunId);
    }
    
    public List<Frequencia> findByTurmAlunIdTrimestre(Integer turmAlunId, Integer trimestre) {
        return frequenciaRepository.findByTurmAlunIdTrimestre(turmAlunId, trimestre.shortValue());
    }
    
}
