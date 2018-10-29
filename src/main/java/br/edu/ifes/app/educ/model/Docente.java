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
@Table(name = "EDDOCE")
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDDOCEDOCECODIGO", sequenceName = "SEQ_EDDOCE_DOCECODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDDOCEDOCECODIGO")
    @Basic(optional = false)
    @Column(name = "DOCECODIGO")
    private Integer codDoce;

    @JoinColumn(name = "FUNCICODIGO", referencedColumnName = "FUNCICODIGO")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

}
