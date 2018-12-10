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

/**
 *
 * @author fernando
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDAVAL")
public class Periodo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "SEQEDAVALAVALCODIGO", sequenceName = "SEQ_EDAVAL_AVALCODIGO", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDAVALAVALCODIGO")
    @Column(name = "AVALCODIGO")
    private Integer codPeriodo;
    
    @Column(name = "AVALNUMPERIODO")
    private Short numPeriodo;
    
}
