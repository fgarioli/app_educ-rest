package br.edu.ifes.app.educ.model;

import java.io.Serializable;
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
import javax.persistence.OrderBy;
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
@Table(name = "EDGRHR")
public class GradeHoraria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDGRHRGRHRCODIGO", sequenceName = "SEQ_EDGRHR_GRHRCODIGO", allocationSize=1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDGRHRGRHRCODIGO")
    @Basic(optional = false)
    @Column(name = "GRHRCODIGO")
    private Integer codGrHr;

    @JoinColumn(name = "DOCECODIGO", referencedColumnName = "DOCECODIGO")
    @ManyToOne(optional = false)
    private Docente docente;

    @JoinColumn(name = "GRCUCODIGO", referencedColumnName = "GRCUCODIGO")
    @ManyToOne(optional = false)
    private GradeCurricular gradeCurricular;

    @OneToMany(mappedBy = "gradeHoraria")
    @OrderBy("diaSemana")
    private List<Tempo> tempos;

    @JoinColumn(name = "TURMCODIGO", referencedColumnName = "TURMCODIGO")
    @ManyToOne(optional = false)
    private Turma turma;
    
}
