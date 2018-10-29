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
@Table(name = "EDCIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDCIDACIDACODIGO", sequenceName = "SEQ_EDCIDA_CIDACODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDCIDACIDACODIGO")
    @Basic(optional = false)
    @Column(name = "CIDACODIGO")
    private Integer codCidade;

    @Column(name = "CIDADESCR")
    private String nomeCidade;

    @JoinColumn(name = "ESTACODIGO", referencedColumnName = "ESTACODIGO")
    @ManyToOne(optional = false)
    private Estado estado;

}
