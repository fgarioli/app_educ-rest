/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.AtividadeAvaliativaDTO;
import br.edu.ifes.app.educ.dto.BoletimDTO;
import br.edu.ifes.app.educ.dto.FrequenciaDTO;
import br.edu.ifes.app.educ.dto.GradeHorariaDTO;
import br.edu.ifes.app.educ.dto.TurmAlunDTO;
import br.edu.ifes.app.educ.model.AtividadeAvaliativa;
import br.edu.ifes.app.educ.model.Frequencia;
import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.model.NotaTrimestral;
import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.service.AtividadeAvaliativaService;
import br.edu.ifes.app.educ.service.FrequenciaService;
import br.edu.ifes.app.educ.service.GradeHorariaService;
import br.edu.ifes.app.educ.service.NotaTrimestralService;
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
@RequestMapping(value = "/aluno")
public class AlunoResource {

    @Autowired
    private NotaTrimestralService notaTrimestralService;

    @Autowired
    private FrequenciaService frequenciaService;

    @Autowired
    private GradeHorariaService gradeHorariaService;

    @Autowired
    private AtividadeAvaliativaService ativAvalService;
    
    @Autowired
    private TurmAlunService turmAlunService;
    
    @RequestMapping(value = "/alun/{alunId}/{ano}", method = RequestMethod.GET)
    public ResponseEntity<List<TurmAlunDTO>> findByAlunIdAno(@PathVariable Integer alunId, @PathVariable Integer ano) {
        List<TurmAlun> list = turmAlunService.findByAlunIdAno(alunId, ano);
        List<TurmAlunDTO> listDTO = new ArrayList<>();

        list.forEach((a) -> {
            listDTO.add(new TurmAlunDTO(a));
        });

        return ResponseEntity.ok().body(listDTO);
    }
    
    @RequestMapping(value = "/{pessId}/{ano}", method = RequestMethod.GET)
    public ResponseEntity<List<TurmAlunDTO>> findByPessIdAno(@PathVariable Integer pessId, @PathVariable Integer ano) {
        List<TurmAlun> list = turmAlunService.findByPessIdAno(pessId, ano);
        List<TurmAlunDTO> listDTO = new ArrayList<>();

        list.forEach((a) -> {
            listDTO.add(new TurmAlunDTO(a));
        });

        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = {"/boletim/{idTurmAlun}", "/boletim/{idTurmAlun}/{trimestre}"}, method = RequestMethod.GET)
    public ResponseEntity<List<BoletimDTO>> findBoletimByTurmAlunIdTrimestre(@PathVariable Integer idTurmAlun, @PathVariable(required = false) Integer trimestre) {
        List<NotaTrimestral> list = trimestre == null ? notaTrimestralService.findByTurmAlunId(idTurmAlun) : notaTrimestralService.findByTurmAlunIdTrimestre(idTurmAlun, trimestre);

        List<BoletimDTO> listBoletim = BoletimDTO.gerarBoletim(list);

        return ResponseEntity.ok().body(listBoletim);
    }

    @RequestMapping(value = {"/freq/{idTurmAlun}", "/freq/{idTurmAlun}/{trimestre}"}, method = RequestMethod.GET)
    public ResponseEntity<List<FrequenciaDTO>> findFreqByTurmAlunIdTrimestre(@PathVariable Integer idTurmAlun, @PathVariable(required = false) Integer trimestre) {
        List<Frequencia> list = trimestre == null ? frequenciaService.findByTurmAlunId(idTurmAlun) : frequenciaService.findByTurmAlunIdTrimestre(idTurmAlun, trimestre);

        List<FrequenciaDTO> listDTO = FrequenciaDTO.gerarFrequenciasDTO(list);

        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/grade/{idTurmAlun}", method = RequestMethod.GET)
    public ResponseEntity<GradeHorariaDTO> findGradeHorariaByTurmAlunId(@PathVariable Integer idTurmAlun) {
        List<GradeHoraria> list = gradeHorariaService.findByTurmAlun(idTurmAlun);

        GradeHorariaDTO ghdto = new GradeHorariaDTO(list);

        return ResponseEntity.ok().body(ghdto);
    }

    @RequestMapping(value = {"/ativ/{turmAlunId}", "/ativ/{turmAlunId}/{trimestre}"}, method = RequestMethod.GET)
    public ResponseEntity<List<AtividadeAvaliativaDTO>> findAtivAvalByTurmAlunIdTrimestre(@PathVariable Integer turmAlunId, @PathVariable(required = false) Integer trimestre) {
        List<AtividadeAvaliativa> listAtivAval = trimestre == null ? ativAvalService.findByTurmAlunId(turmAlunId) : ativAvalService.findByTurmAlunIdTrimestre(turmAlunId, trimestre);

        List<AtividadeAvaliativaDTO> list = AtividadeAvaliativaDTO.getList(listAtivAval);

        return ResponseEntity.ok().body(list);
    }

}
