/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.resource;

import br.edu.ifes.app.educ.dto.GradeHorariaDTO;
import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.service.GradeHorariaService;
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
@RequestMapping(value = "/grade")
public class GradeHorariaResource {
    
    @Autowired
    private GradeHorariaService gradeHorariaService;
    
    @RequestMapping(value = "/{idTurmAlun}", method = RequestMethod.GET)
    public ResponseEntity<GradeHorariaDTO> findByTurmAlun(@PathVariable Integer idTurmAlun) {
        List<GradeHoraria> list = gradeHorariaService.findByTurmAlun(idTurmAlun);

        GradeHorariaDTO ghdto = new GradeHorariaDTO(list);

        return ResponseEntity.ok().body(ghdto);
    }
    
}
