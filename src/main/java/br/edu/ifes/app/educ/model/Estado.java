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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDESTA")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDESTAESTACODIGO", sequenceName = "SEQ_EDESTA_ESTACODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDESTAESTACODIGO")
    @Basic(optional = false)
    @Column(name = "ESTACODIGO")
    private Integer codEstado;

    @Column(name = "ESTADESCR")
    private String nomeEstado;

    @Column(name = "ESTAUF")
    private String siglaEstado;
    
}
