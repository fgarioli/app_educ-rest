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
@Table(name = "EDMENSAGEM_USUARIO")
public class MensagemUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "MSGUSCODIGO")
    @SequenceGenerator(name = "SEQEDMENSAGEMUSUARIOMSGUSCODIGO", sequenceName = "SEQ_EDMENSAGEM_USUARIO_MSGUSCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDMENSAGEMUSUARIOMSGUSCODIGO")
    private Long codMsgUs;

    @JoinColumn(name = "MSGCODIGO", referencedColumnName = "MSGCODIGO")
    @ManyToOne(optional = false)
    private Mensagem mensagem;

    @JoinColumn(name = "USERCODIGO", referencedColumnName = "USERCODIGO")
    @ManyToOne(optional = false)
    private Usuario destinatario;

}
