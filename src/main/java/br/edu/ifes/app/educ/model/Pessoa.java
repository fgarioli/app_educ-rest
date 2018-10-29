package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "EDPESS")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDPESSPESSCODIGO", sequenceName = "SEQ_EDPESS_PESSCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDPESSPESSCODIGO")
    @Basic(optional = false)
    @Column(name = "PESSCODIGO")
    private Integer codPess;
    
    @Basic(optional = false)
    @Column(name = "PESSNOME")
    private String nomePess;
    
    @Column(name = "PESSCPF")
    private String cpf;
    
    @Column(name = "PESSRG")
    private String rg;
    
    @Column(name = "PESSDTEXPEDRG")
    private LocalDate dtExpRg;
    
    @Column(name = "PESSRGCOMPL")
    private String rgCompl;
    
    @Column(name = "PESSDTNASC")
    private LocalDate dtNasc;
    
    @Column(name = "PESSEMAIL")
    private String email;
    
    @Column(name = "PESSNACIONALIDADE")
    private String nacionalidade;
    
    @Column(name = "PESSNOMEPAI")
    private String nomePai;
    
    @Column(name = "PESSNOMEMAE")
    private String nomeMae;
    
    @Column(name = "PESSTELEFONE")
    private String telefone;
    
    @Column(name = "PESSTELEFONEPAI")
    private String telefonePai;
    
    @Column(name = "PESSTELEFONEMAE")
    private String telefoneMae;
    
    @Column(name = "PESSCELULAR")
    private String celular;
    
}
