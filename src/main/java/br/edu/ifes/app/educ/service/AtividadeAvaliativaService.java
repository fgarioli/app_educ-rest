/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.AtividadeAvaliativa;
import br.edu.ifes.app.educ.repository.AtividadeAvaliativaRepository;
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
    
    public List<AtividadeAvaliativa> findByTurmAlunId(Integer turmAlunId) {
        return ativAvalRepository.findByTurmAlunId(turmAlunId);
    }
    
    public List<AtividadeAvaliativa> findByTurmAlunIdTrimestre(Integer turmAlunId, Integer trimestre) {
        return ativAvalRepository.findByTurmAlunIdTrimestre(turmAlunId, trimestre);
    }
    
}
