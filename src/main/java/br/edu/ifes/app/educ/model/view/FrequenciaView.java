/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.model.view;

import java.time.LocalDate;

/**
 *
 * @author fernando
 */
public interface FrequenciaView {

    Integer getALUNCODIGO();

    LocalDate getPAUTADATA();

    Integer getPAUTAPERIODO();

    Integer getQT_FALTA();

    Integer getEXERCICIO();
    
    Integer getDISCCODIGO();
    
    Integer getGRCUCODIGO();

    String getPAUTACONTEUDO();
    
    Integer getTURMCODIGO();
}
