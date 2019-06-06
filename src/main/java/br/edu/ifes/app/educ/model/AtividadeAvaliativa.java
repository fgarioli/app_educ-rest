package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "EDATIV_AVAL")
public class AtividadeAvaliativa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ATIVCODIGO")
    @SequenceGenerator(name = "SEQEDATIVAVALATIVCODIGO", sequenceName = "SEQ_EDATIV_AVAL_ATIVCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDATIVAVALATIVCODIGO")
    private Integer codAtivAval;

    @Basic(optional = false)
    @Column(name = "ATIVDATA")
    private LocalDate dataAtiv;

    @Column(name = "ATIVDESCR")
    private String descrAtiv;

    @Column(name = "ATIVPERIODO")
    private Integer periodo;

    @Column(name = "ATIVVALOR")
    private Double valor;

    @JoinColumn(name = "GRHRCODIGO", referencedColumnName = "GRHRCODIGO")
    @ManyToOne(optional = false)
    private GradeHoraria gradeHoraria;

    @JoinColumn(name = "ATIVTIPO", referencedColumnName = "DOMICODIGO")
    @ManyToOne
    private Dominio tipoAtiv;
    
    @OneToMany(mappedBy = "atividadeAvaliativa")
    private List<NotaAtivAval> notas;

}
