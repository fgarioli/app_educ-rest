package br.edu.ifes.app.educ.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCalendario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDCALECALECODIGO", sequenceName = "SEQ_EDCALE_CALECODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDCALECALECODIGO")
    @Basic(optional = false)
    @Column(name = "CALECODIGO")
    private Integer codCale;

    @Basic(optional = false)
    @Column(name = "CALEDT")
    private LocalDate dataCale;

    @Column(name = "CALEDESCR")
    private String descrCale;

    @Column(name = "CALETIPO")
    private Character tipoCale;

    @Column(name = "CALEPERIODO")
    private Integer periodoCale;

}
