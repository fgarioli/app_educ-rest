package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDMATR")
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDMATRMATRCODIGO", sequenceName = "SEQ_EDMATR_MATRCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDMATRMATRCODIGO")
    @Basic(optional = false)
    @Column(name = "MATRCODIGO")
    private Integer codMatr;

    @Column(name = "MATRMATRICULA")
    private String matr;

    @Basic(optional = false)
    @Column(name = "MATRDTINIC")
    private LocalDate dtInic;

    @Column(name = "MATRDTFIM")
    private LocalDate dtFim;

    @JoinColumn(name = "ALUNCODIGO", referencedColumnName = "ALUNCODIGO")
    @ManyToOne(optional = false)
    private Aluno aluno;

    @OneToMany(mappedBy = "matricula")
    private List<TurmAlun> turmAlun = new ArrayList<>();

}
