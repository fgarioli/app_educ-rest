/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.DataCalendario;
import br.edu.ifes.app.educ.repository.DataCalendarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class DataCalendarioService {
    
    @Autowired
    private DataCalendarioRepository calendarioRepository;
    
    public List<DataCalendario> findDataCalendarioByAno(Integer ano) {
        return calendarioRepository.findDataCalendarioByAno(ano);
    }
    
}
