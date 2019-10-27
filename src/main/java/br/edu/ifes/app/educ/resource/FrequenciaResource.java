/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.FrequenciaDTO;
import br.edu.ifes.app.educ.dto.DisciplinaDTO;
import br.edu.ifes.app.educ.model.view.FrequenciaView;
import br.edu.ifes.app.educ.service.FrequenciaService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping(value = "/freq")
public class FrequenciaResource {

    @Autowired
    private FrequenciaService frequenciaService;

    @RequestMapping(value = "/{idTurmAlun}/{trimestre}/{discId}", method = RequestMethod.GET)
    public ResponseEntity<Page<FrequenciaDTO>> getListFrequencia(@PathVariable Integer idTurmAlun, @PathVariable Integer trimestre, @PathVariable Integer discId, Pageable p) {
        Page<FrequenciaView> list = frequenciaService.findByAlunoExercicioTrimestreDisciplina(idTurmAlun, trimestre, discId, p);
        final Page<FrequenciaDTO> contactDtoPage = list.map(this::convertToFreqDTO);
        return ResponseEntity.ok().body(contactDtoPage);
    }

    @RequestMapping(value = "/{idTurmAlun}/{trimestre}/{discId}/total", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getFaltasByTrimetreDisciplina(@PathVariable Integer idTurmAlun, @PathVariable Integer trimestre, @PathVariable Integer discId) {
        return ResponseEntity.ok().body(frequenciaService.getFaltasByTrimetreDisciplina(idTurmAlun, trimestre, discId));
    }

    @RequestMapping(value = "/{idTurmAlun}/{trimestre}", method = RequestMethod.GET)
    public ResponseEntity<List<DisciplinaDTO>> getListDisciplina(@PathVariable Integer idTurmAlun, @PathVariable Integer trimestre) {
        List<DisciplinaDTO> list = frequenciaService.getListDisciplina(idTurmAlun, trimestre);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{idTurmAlun}/{trimestre}/total", method = RequestMethod.GET)
    public ResponseEntity<BigDecimal> getFaltasByTrimetre(@PathVariable Integer idTurmAlun, @PathVariable Integer trimestre) {
        return ResponseEntity.ok().body(frequenciaService.getFaltasByTrimetre(idTurmAlun, trimestre));
    }

    public FrequenciaDTO convertToFreqDTO(final FrequenciaView fv) {
        return new FrequenciaDTO(fv);
    }
}
