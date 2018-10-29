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
@Table(name = "EDMENSAGEM")
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "MSGCODIGO")
    @SequenceGenerator(name = "SEQEDMENSAGEMMSGCODIGO", sequenceName = "SEQ_EDMENSAGEM_MSGCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDMENSAGEMMSGCODIGO")
    private Long codMsg;

    @Basic(optional = false)
    @Column(name = "MSGDASSUNTO")
    private String assunto;
    
    @Basic(optional = false)
    @Column(name = "MSGMENSAGEM")
    private String mensagem;
    
    @OneToMany(mappedBy = "mensagem")
    private List<MensagemUsuario> destinatarios = new ArrayList<>();
    
    @JoinColumn(name = "USERCODIGO", referencedColumnName = "USERCODIGO")
    @ManyToOne(optional = false)
    private Usuario remetente;
    
}
