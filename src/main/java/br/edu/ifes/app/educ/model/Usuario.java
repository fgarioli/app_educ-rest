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
@Table(name = "EDUSUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SEQEDUSUARIOUSERCODIGO", sequenceName = "SEQ_EDUSUARIO_USERCODIGO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQEDUSUARIOUSERCODIGO")
    @Basic(optional = false)
    @Column(name = "USERCODIGO")
    private Long codUsuario;

    @Column(name = "USERLOGIN")
    private String login;

    @Column(name = "USERSENHA")
    private String senha;

    @OneToMany(mappedBy = "destinatario")
    private List<MensagemUsuario> caixaEntrada = new ArrayList<>();

    @OneToMany(mappedBy = "remetente")
    private List<Mensagem> caixaSaida = new ArrayList<>();

    @JoinColumn(name = "PESSCODIGO", referencedColumnName = "PESSCODIGO")
    @ManyToOne
    private Pessoa pessoa;

}
