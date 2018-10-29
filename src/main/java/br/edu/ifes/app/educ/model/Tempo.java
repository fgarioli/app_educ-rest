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
@Table(name = "EDTEMPO")
public class Tempo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "TEMPCODIGO")
    @SequenceGenerator(name = "SEQEDTEMPOTEMPCODIGO", sequenceName = "SEQ_EDTEMPO_TEMPCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDTEMPOTEMPCODIGO")
    private Integer codTempo;

    @Basic(optional = false)
    @Column(name = "TEMPAULA")
    private Integer tempo;

    @Basic(optional = false)
    @Column(name = "TEMPDIASEMANA")
    private Integer diaSemana;

    @JoinColumn(name = "GRHRCODIGO", referencedColumnName = "GRHRCODIGO")
    @ManyToOne(optional = false)
    private GradeHoraria gradeHoraria;

}
