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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDNOTA_AVAL")
public class NotaAtivAval implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "NAVALCODIGO")
    @SequenceGenerator(name = "SEQEDNOTAAVALNOTACODIGO", sequenceName = "SEQ_EDNOTA_AVAL_NOTACODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDNOTAAVALNOTACODIGO")
    private Integer codNotaAtiv;

    @Column(name = "NOTAATIV")
    private Double notaValor;

    @Column(name = "NOTADESCR")
    private String notaDescr;

    @JoinColumn(name = "NOTACODIGO", referencedColumnName = "NOTACODIGO")
    @ManyToOne(optional = true)
    private NotaTrimestral notaTrimestral;

    @JoinColumn(name = "ATIVCODIGO", referencedColumnName = "ativcodigo")
    @ManyToOne(optional = false)
    private AtividadeAvaliativa atividadeAvaliativa;
    
}
