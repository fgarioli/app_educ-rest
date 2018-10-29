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
@Table(name = "EDCEP")
public class Cep implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDCEPCEPCODIGO", sequenceName = "SEQ_EDCEP_CEPCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDCEPCEPCODIGO")
    @Basic(optional = false)
    @Column(name = "CEPCODIGO")
    private Integer codCep;

    @Basic(optional = false)
    @Column(name = "CEPDESCR")
    private String descrCep;

    @Basic(optional = false)
    @Column(name = "CEPCEP")
    private String cep;

    @Column(name = "CEPCOMPLEMENTO")
    private String complemento;

    @JoinColumn(name = "BAIRCODIGO", referencedColumnName = "BAIRCODIGO")
    @ManyToOne(optional = false)
    private Bairro bairro;
}
