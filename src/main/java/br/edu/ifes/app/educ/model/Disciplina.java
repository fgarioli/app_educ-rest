package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDDISC")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDDISCDISCCODIGO", sequenceName = "SEQ_EDDISC_DISCCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDDISCDISCCODIGO")
    @Basic(optional = false)
    @Column(name = "DISCCODIGO")
    private Integer codDisc;

    @Basic(optional = false)
    @Column(name = "DISCDESCR")
    private String nomeDisc;

}
