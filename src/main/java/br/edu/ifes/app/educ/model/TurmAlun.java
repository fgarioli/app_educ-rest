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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDTURMALUN")
public class TurmAlun implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDTURMALUNTMALCODIGO", sequenceName = "SEQ_EDTURMALUN_TMALCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDTURMALUNTMALCODIGO")
    @Basic(optional = false)
    @Column(name = "TMALCODIGO")
    private Integer codTurmAlun;
    
    @Column(name = "TMALDTINCLUSAO")
    private LocalDate dtInic;
    
    @Column(name = "TMALDTFIM")
    private LocalDate dtFim;
    
    @JoinColumn(name = "MATRCODIGO", referencedColumnName = "MATRCODIGO")
    @ManyToOne(optional = false)
    private Matricula matricula;
    
    @JoinColumn(name = "TURMCODIGO", referencedColumnName = "TURMCODIGO")
    @ManyToOne(optional = false)
    private Turma turma;
    
    @Basic
    @Column(name = "TMALRESULTADO")
    private String resultado;
    
}
