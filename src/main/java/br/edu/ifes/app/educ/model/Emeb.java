package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "EDEMEB")
public class Emeb implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDEMEBEMEBCODIGO", sequenceName = "SEQ_EDEMEB_EMEBCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDEMEBEMEBCODIGO")
    @Basic(optional = false)
    @Column(name = "EMEBCODIGO")
    private Integer codEmeb;

    @Basic(optional = false)
    @Column(name = "EMEBNOME")
    private String nomeEmeb;

    @JoinColumn(name = "CEPCODIGO", referencedColumnName = "CEPCODIGO")
    @ManyToOne
    private Cep cep;
    
}
