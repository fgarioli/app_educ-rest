/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.repository.TurmAlunRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class TurmAlunService {
    
    @Autowired
    private TurmAlunRepository turmAlunRepository;
    
    public List<TurmAlun> findByResponsavel(Integer respId, Integer ano) {
        return turmAlunRepository.findByResponsavel(respId, ano);
    }
    
}
