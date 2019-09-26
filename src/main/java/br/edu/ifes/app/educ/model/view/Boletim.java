/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.model.view;

/**
 *
 * @author fernando
 */
public interface Boletim {
    Integer getFALTA();
    Character getFRAVTIPOAVALIACAO();
    Character getRESULTADO();
    String getDESCRICAO();
    Double getNOTA();
    Double getN_RECUPERACAO();
    Integer getNUMPERIODO();
    String getDISCIPLINA();
    Integer getEXERCICIO();
    Integer getMATRCODIGO();
}
