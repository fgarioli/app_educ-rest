/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDTURN")
public class Turno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SEQEDTURNTURNCODIGO", sequenceName = "SEQ_EDTURN_TURNCODIGO", allocationSize=1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDTURNTURNCODIGO") 
    @Basic(optional = false)
    @Column(name = "TURNCODIGO")
    private Integer turncodigo;
    
    @Basic(optional = false)
    @Column(name = "TURNDESCR")
    private String turndescr;
    
}
