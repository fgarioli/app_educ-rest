/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.MensagemDTO;
import br.edu.ifes.app.educ.model.MensagemUsuario;
import br.edu.ifes.app.educ.service.MensagemUsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernando
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
    
    @Autowired
    private MensagemUsuarioService mensagemService;
    
    @RequestMapping(value = "/msg/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<MensagemDTO>> findMensagemByUsuario(@PathVariable Integer idUsuario) {
        List<MensagemUsuario> list = mensagemService.findMensagemByUsuario(idUsuario);

        List<MensagemDTO> listDTO = new ArrayList<>();

        list.forEach((a) -> {
            listDTO.add(new MensagemDTO(a));
        });

        return ResponseEntity.ok().body(listDTO);
    }
    
}
