package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EDPARENTE")
public class Responsavel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDPARENPARENCODIGO", sequenceName = "SEQ_EDPARENTE_PARENCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDPARENPARENCODIGO")
    @Basic(optional = false)
    @Column(name = "PARENCODIGO")
    private Integer codResp;

    @JoinColumn(name = "PESSCODIGO", referencedColumnName = "PESSCODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "responsavel")
    private List<Vinculo> vinculos = new ArrayList<>();

}
