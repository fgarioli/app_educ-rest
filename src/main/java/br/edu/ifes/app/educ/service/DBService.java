package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.Aluno;
import br.edu.ifes.app.educ.model.Pessoa;
import br.edu.ifes.app.educ.model.Responsavel;
import br.edu.ifes.app.educ.model.Usuario;
import br.edu.ifes.app.educ.model.Vinculo;
import br.edu.ifes.app.educ.repository.AlunoRepository;
import br.edu.ifes.app.educ.repository.PessoaRepository;
import br.edu.ifes.app.educ.repository.ResponsavelRepository;
import br.edu.ifes.app.educ.repository.UsuarioRepository;
import br.edu.ifes.app.educ.repository.VinculoRepository;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ResponsavelRepository responsavelRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private VinculoRepository vinculoRepository;

    public void instantiateTestDatabase() throws ParseException {

        // ---------------------------------------- CRIAÇÃO DOS DADOS ----------------------------------------
        Pessoa p1 = Pessoa.builder()
                .nomePess("Carlos Henrique Garioli")
                .celular("99999999999")
                .cpf("95303831000")
                .dtExpRg(LocalDate.now())
                .dtNasc(LocalDate.now())
                .email("teste@teste.com.br")
                .nacionalidade("brasileiro")
                .nomeMae("Maria das Graças")
                .nomePai("José da Silva")
                .rg("123456")
                .rgCompl("teste")
                .telefone("289998989899")
                .telefoneMae("12333336666")
                .telefonePai("12444448888").build();

        Pessoa p2 = Pessoa.builder()
                .nomePess("Lucas Ribeiro Garioli")
                .celular("99999999999")
                .cpf("05776036046")
                .dtExpRg(LocalDate.now())
                .dtNasc(LocalDate.now())
                .email("teste@teste.com.br")
                .nacionalidade("brasileiro")
                .nomeMae("Maria das Graças")
                .nomePai("José da Silva")
                .rg("123456")
                .rgCompl("teste")
                .telefone("289998989899")
                .telefoneMae("12333336666")
                .telefonePai("12444448888").build();

        Pessoa p3 = Pessoa.builder()
                .nomePess("Fernando Ribeiro Garioli")
                .celular("99999999999")
                .cpf("80859538036")
                .dtExpRg(LocalDate.now())
                .dtNasc(LocalDate.now())
                .email("teste@teste.com.br")
                .nacionalidade("brasileiro")
                .nomeMae("Maria das Graças")
                .nomePai("José da Silva")
                .rg("123456")
                .rgCompl("teste")
                .telefone("289998989899")
                .telefoneMae("12333336666")
                .telefonePai("12444448888").build();

        Responsavel r1 = Responsavel.builder().pessoa(p1).build();
        Aluno a1 = Aluno.builder().pessoa(p2).build();
        Aluno a2 = Aluno.builder().pessoa(p3).build();

        Vinculo v1 = Vinculo.builder().aluno(a1).responsavel(r1).ehResp('1').build();
        Vinculo v2 = Vinculo.builder().aluno(a2).responsavel(r1).ehResp('1').build();

        Usuario u1 = Usuario.builder().pessoa(p1).login("95303831000").senha(pe.encode("123456")).build();
        Usuario u2 = Usuario.builder().pessoa(p2).login("05776036046").senha(pe.encode("123456")).build();
        Usuario u3 = Usuario.builder().pessoa(p3).login("80859538036").senha(pe.encode("123456")).build();

        // ---------------------------------------- INSERÇÃO DE DADOS ---------------------------------------- 
        pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));
        responsavelRepository.save(r1);
        alunoRepository.saveAll(Arrays.asList(a1, a2));
        vinculoRepository.saveAll(Arrays.asList(v1, v2));
        usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
