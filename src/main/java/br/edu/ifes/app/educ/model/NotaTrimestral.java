package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "EDNOTA")
public class NotaTrimestral implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDNOTANOTACODIGO", sequenceName = "SEQ_EDNOTA_NOTACODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDNOTANOTACODIGO")
    @Basic(optional = false)
    @Column(name = "NOTACODIGO")
    private Integer codNotaTrim;

    @Column(name = "NOTAVALOR")
    private Double notaValor;

    @Column(name = "NOTACONCEITO")
    private String notaConceito;

    @Column(name = "NOTAFALTA")
    private Integer qtdFaltas;

    @Lob
    @Column(name = "NOTADESCR")
    private String notaDescr;

    @OneToMany(mappedBy = "notaTrimestral")
    private List<Frequencia> frequencia = new ArrayList<>();

    @JoinColumn(name = "TMALCODIGO", referencedColumnName = "TMALCODIGO")
    @ManyToOne(optional = true)
    private TurmAlun turmAlun;

    @OneToMany(mappedBy = "notaTrimestral")
    private List<NotaAtivAval> notaAtivAval = new ArrayList<>();
    
    @JoinColumn(name = "ATIVCODIGOREC", referencedColumnName = "ATIVCODIGO")
    @ManyToOne(optional = true)
    private AtividadeAvaliativa recuperacao;
    
    @Column(name = "NOTAREC")
    private Double notaRecuperacao;
    
    @JoinColumn(name = "AVALCODIGO", referencedColumnName = "AVALCODIGO")
    @ManyToOne(optional = false)
    private Periodo periodo;
    
    @JoinColumn(name = "GRCUCODIGO", referencedColumnName = "GRCUCODIGO")
    @ManyToOne(optional = false)
    private GradeCurricular gradeCurricular;

}
