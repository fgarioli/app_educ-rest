package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "EDPAUTA")
public class Pauta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "PAUTACODIGO")
    @SequenceGenerator(name = "SEQEDPAUTAPAUTACODIGO", sequenceName = "SEQ_EDPAUTA_PAUTACODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDPAUTAPAUTACODIGO")
    private Integer codPauta;

    @Column(name = "PAUTADATA")
    private LocalDate dataPauta;

    @Column(name = "PAUTACONTEUDO")
    private String conteudo;

    @Column(name = "PAUTAQTDAULAS")
    private Integer qtdAulas;

    @Column(name = "PAUTAPERIODO")
    private Integer periodo;

    @JoinColumn(name = "GRHRCODIGO", referencedColumnName = "GRHRCODIGO")
    @ManyToOne
    private GradeHoraria gradeHoraria;

}
