/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.AtividadeAvaliativaDTO;
import br.edu.ifes.app.educ.dto.DisciplinaDTO;
import br.edu.ifes.app.educ.model.view.AtividadeView;
import br.edu.ifes.app.educ.service.AtividadeAvaliativaService;
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
@RequestMapping(value = "/ativ")
public class AtividadeAvaliativaResource {

    @Autowired
    private AtividadeAvaliativaService ativAvalService;

    @RequestMapping(value = "/{idTurmAlun}/{trimestre}/{discId}", method = RequestMethod.GET)
    public ResponseEntity<List<AtividadeAvaliativaDTO>> getListAtividade(@PathVariable Integer idTurmAlun, @PathVariable Integer trimestre, @PathVariable Integer discId) {
        List<AtividadeView> list = ativAvalService.findByAlunoExercicioTrimestreDisciplina(idTurmAlun, trimestre, discId);
        return ResponseEntity.ok().body(AtividadeAvaliativaDTO.getList(list));
    }

    @RequestMapping(value = "/{idTurmAlun}/{trimestre}", method = RequestMethod.GET)
    public ResponseEntity<List<DisciplinaDTO>> getListDisciplina(@PathVariable Integer idTurmAlun, @PathVariable Integer trimestre) {
        List<DisciplinaDTO> list = ativAvalService.getListDisciplina(idTurmAlun, trimestre);
        return ResponseEntity.ok().body(list);
    }
}
