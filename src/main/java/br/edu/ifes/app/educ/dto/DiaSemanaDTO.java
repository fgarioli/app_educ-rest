/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author fernando
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum DiaSemanaDTO {
    DOMINGO(1, "Domingo"),
    SEGUNDA(2, "Segunda-Feira"),
    TERCA(3, "Terça-Feira"),
    QUARTA(4, "Quarta-Feira"),
    QUINTA(5, "Quinta-Feira"),
    SEXTA(6, "Sexta-Feira"),
    SABADO(7, "Sábado");
    
    private Integer idDia;    
    private String dia;
}
