/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.MensagemUsuario;
import br.edu.ifes.app.educ.repository.MensagemUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class MensagemUsuarioService {
    
    @Autowired
    private MensagemUsuarioRepository mensagemRepository;
    
    public List<MensagemUsuario> findMensagemByUsuario(Long idUsuario) {
        return mensagemRepository.findMensagemByUsuario(idUsuario);
    }
    
}
