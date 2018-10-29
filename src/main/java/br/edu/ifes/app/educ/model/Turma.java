package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDTURM")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDTURMTURMCODIGO", sequenceName = "SEQ_EDTURM_TURMCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDTURMTURMCODIGO")
    @Basic(optional = false)
    @Column(name = "TURMCODIGO")
    private Integer codTurm;

    @Basic(optional = false)
    @Column(name = "TURMNOME")
    private String nomeTurm;

    @Basic(optional = false)
    @Column(name = "TURMEXERCICIO")
    private Integer exercicio;

    @Column(name = "TURMDTINIC")
    private LocalDate dtInic;

    @Column(name = "TURMDTFIM")
    private LocalDate dtFim;

    @JoinColumn(name = "EMEBCODIGO", referencedColumnName = "EMEBCODIGO")
    @ManyToOne(optional = false)
    private Emeb emeb;

}
