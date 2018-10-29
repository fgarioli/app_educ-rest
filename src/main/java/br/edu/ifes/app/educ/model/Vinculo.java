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
@Table(name = "EDALUN_PARENTE")
public class Vinculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDALUNPARENALUNPARENCODIGO", sequenceName = "SEQ_EDALUNPAREN_PARENCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDALUNPARENALUNPARENCODIGO")
    @Basic(optional = false)
    @Column(name = "ALUNPARENCODIGO")
    private Integer codVinc;

    @Column(name = "EHRESPONSAVEL")
    private Character ehResp;

    @JoinColumn(name = "PARENCODIGO", referencedColumnName = "PARENCODIGO")
    @ManyToOne(optional = false)
    private Responsavel responsavel;

    @JoinColumn(name = "ALUNCODIGO", referencedColumnName = "ALUNCODIGO")
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Boolean isEhResp() {
        return Character.valueOf('1').equals(ehResp);
    }

    public void setEhResp(Boolean ehResp) {
        this.ehResp = ehResp ? '1' : '0';
    }

}
