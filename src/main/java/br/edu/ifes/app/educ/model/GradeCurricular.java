package br.edu.ifes.app.educ.model;

import java.io.Serializable;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDGRCU")
public class GradeCurricular implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDGRCUGRCUCODIGO", sequenceName = "SEQ_EDGRCU_GRCUCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDGRCUGRCUCODIGO")
    @Basic(optional = false)
    @Column(name = "GRCUCODIGO")
    private Integer codGrCu;

    @JoinColumn(name = "DISCCODIGO", referencedColumnName = "DISCCODIGO")
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    @JoinColumn(name = "ANOCODIGO", referencedColumnName = "ANOCODIGO")
    @ManyToOne(optional = false)
    private Ano ano;
    
}
