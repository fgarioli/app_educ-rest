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
public interface AtividadeView {

    Integer getALUNCODIGO();

    String getALUNNOME();

    Double getNOTAATIV();

    Double getATIVVALOR();

    LocalDate getATIVDATA();

    Integer getDISCCODIGO();

    Integer getGRCUCODIGO();

    Integer getEXERCICIO();

    Integer getATIVPERIODO();

    String getDESCRICAO();

    Integer getTURMCODIGO();

    String getNOTADESCR();
}
