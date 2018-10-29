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
@Table(name = "EDBAIR")
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDBAIRBAIRCODIGO", sequenceName = "SEQ_EDBAIR_BAIRCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDBAIRBAIRCODIGO")
    @Basic(optional = false)
    @Column(name = "BAIRCODIGO")
    private Integer codBair;

    @Basic(optional = false)
    @Column(name = "BAIRDESCR")
    private String nomeBair;

    @JoinColumn(name = "CIDACODIGO", referencedColumnName = "CIDACODIGO")
    @ManyToOne(optional = false)
    private Cidade cidade;
    
}
