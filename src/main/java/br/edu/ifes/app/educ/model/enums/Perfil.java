/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author fernando
 */
@Getter
@AllArgsConstructor
public enum Perfil {

    RESPONSAVEL(1, "ROLE_RESP"),
    ALUNO(2, "ROLE_ALUN");

    private Integer cod;
    private String descricao;

    public static Perfil toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
    
}
