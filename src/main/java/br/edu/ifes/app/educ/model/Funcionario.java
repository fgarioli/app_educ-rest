package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "EDFUNCI")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDFUNCFUNCICODIGO", sequenceName = "SEQ_EDFUNC_FUNCICODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDFUNCFUNCICODIGO")
    @Basic(optional = false)
    @Column(name = "FUNCICODIGO")
    private Integer codFunci;

    @Column(name = "FUNCIDOCENTE")
    private Character ehDocente;

    @JoinColumn(name = "PESSCODIGO", referencedColumnName = "PESSCODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pessoa pessoa;
    
    public Boolean isEhDocente() {
        return Character.valueOf('1').equals(ehDocente);
    }

    public void setEhDocente(Boolean ehDocente) {
        this.ehDocente = ehDocente ? '1' : '0';
    }

}
