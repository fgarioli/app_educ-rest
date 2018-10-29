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
@Table(name = "EDALUN")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDALUNALUNCODIGO", sequenceName = "SEQ_EDALUN_ALUNCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDALUNALUNCODIGO")
    @Basic(optional = false)
    @Column(name = "ALUNCODIGO")
    private Integer codAlun;
    
    @JoinColumn(name = "PESSCODIGO", referencedColumnName = "PESSCODIGO")
    @ManyToOne(optional = false)
    private Pessoa pessoa;

}
