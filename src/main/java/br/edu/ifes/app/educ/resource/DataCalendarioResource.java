/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.DataCalendarioDTO;
import br.edu.ifes.app.educ.model.DataCalendario;
import br.edu.ifes.app.educ.service.DataCalendarioService;
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
@RequestMapping(value = "/cale")
public class DataCalendarioResource {
    
    @Autowired
    private DataCalendarioService calendarioService;
    
    @RequestMapping(value = "/{ano}", method = RequestMethod.GET)
    public ResponseEntity<List<DataCalendarioDTO>> findCalendarioByAno(@PathVariable Integer ano) {
        List<DataCalendario> list = calendarioService.findDataCalendarioByAno(ano);

        List<DataCalendarioDTO> listDTO = new ArrayList<>();

        list.forEach((a) -> {
            listDTO.add(new DataCalendarioDTO(a));
        });

        return ResponseEntity.ok().body(listDTO);
    }
    
}
