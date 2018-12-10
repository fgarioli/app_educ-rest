/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.TurmAlunDTO;
import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.service.TurmAlunService;
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
@RequestMapping(value = "/resp")
public class ResponsavelResource {

    @Autowired
    private TurmAlunService turmAlunService;

    @RequestMapping(value = "/{idResp}/{ano}", method = RequestMethod.GET)
    public ResponseEntity<List<TurmAlunDTO>> findByResponsavel(@PathVariable Integer idResp, @PathVariable Integer ano) {
        List<TurmAlun> list = turmAlunService.findByResponsavel(idResp, ano);
        List<TurmAlunDTO> listDTO = new ArrayList<>();

        list.forEach((a) -> {
            listDTO.add(new TurmAlunDTO(a));
        });

        return ResponseEntity.ok().body(listDTO);
    }

}
