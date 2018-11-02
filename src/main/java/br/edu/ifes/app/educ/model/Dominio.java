package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "EDDOMI")
public class Dominio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDDOMIDOMICODIGO", sequenceName = "SEQ_EDDOMI_DOMICODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDDOMIDOMICODIGO")
    @Basic(optional = false)
    @Column(name = "DOMICODIGO")
    private Integer codDomi;

    @Basic(optional = false)
    @Column(name = "DOMIDESCR")
    private String descrDomi;

    @Column(name = "DOMIVALOR")
    private String valorDomi;

}
