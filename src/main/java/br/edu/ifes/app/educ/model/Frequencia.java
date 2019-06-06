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
@Table(name = "EDFREQUENCIA")
public class Frequencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FREQCODIGO")
    @Basic(optional = false)
    @SequenceGenerator(name = "SEQEDFREQCOD", sequenceName = "SEQ_EDFREQUENCIA_FREQCOD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDFREQCOD")
    private Integer codFreq;

    @Basic(optional = false)
    @Column(name = "FREQPRESENCA")
    private Character presenca;

    @JoinColumn(name = "PAUTACODIGO", referencedColumnName = "PAUTACODIGO")
    @ManyToOne(optional = false)
    private Pauta pauta;

    @JoinColumn(name = "TEMPCODIGO", referencedColumnName = "TEMPCODIGO")
    @ManyToOne(optional = false)
    private Tempo tempo;

    @JoinColumn(name = "NOTACODIGO", referencedColumnName = "NOTACODIGO")
    @ManyToOne(optional = false)
    private NotaTrimestral notaTrimestral;

    public Boolean isPresenca() {
        return Character.valueOf('1').equals(presenca);
    }

    public void setPresenca(Boolean presenca) {
        this.presenca = presenca ? '1' : '0';
    }

}
