package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.model.Aluno;
import br.edu.ifes.app.educ.model.Ano;
import br.edu.ifes.app.educ.model.Bairro;
import br.edu.ifes.app.educ.model.Cep;
import br.edu.ifes.app.educ.model.Cidade;
import br.edu.ifes.app.educ.model.Disciplina;
import br.edu.ifes.app.educ.model.Docente;
import br.edu.ifes.app.educ.model.Emeb;
import br.edu.ifes.app.educ.model.Estado;
import br.edu.ifes.app.educ.model.Funcionario;
import br.edu.ifes.app.educ.model.GradeCurricular;
import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.model.Matricula;
import br.edu.ifes.app.educ.model.Pessoa;
import br.edu.ifes.app.educ.model.Responsavel;
import br.edu.ifes.app.educ.model.Tempo;
import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.model.Turma;
import br.edu.ifes.app.educ.model.Usuario;
import br.edu.ifes.app.educ.model.Vinculo;
import br.edu.ifes.app.educ.repository.AlunoRepository;
import br.edu.ifes.app.educ.repository.AnoRepository;
import br.edu.ifes.app.educ.repository.BairroRepository;
import br.edu.ifes.app.educ.repository.CepRepository;
import br.edu.ifes.app.educ.repository.CidadeRepository;
import br.edu.ifes.app.educ.repository.DisciplinaRepository;
import br.edu.ifes.app.educ.repository.DocenteRepository;
import br.edu.ifes.app.educ.repository.EmebRepository;
import br.edu.ifes.app.educ.repository.EstadoRepository;
import br.edu.ifes.app.educ.repository.FuncionarioRepository;
import br.edu.ifes.app.educ.repository.GradeCurricularRepository;
import br.edu.ifes.app.educ.repository.GradeHorariaRepository;
import br.edu.ifes.app.educ.repository.MatriculaRepository;
import br.edu.ifes.app.educ.repository.PessoaRepository;
import br.edu.ifes.app.educ.repository.ResponsavelRepository;
import br.edu.ifes.app.educ.repository.TempoRepository;
import br.edu.ifes.app.educ.repository.TurmAlunRepository;
import br.edu.ifes.app.educ.repository.TurmaRepository;
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
    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private AnoRepository anoRepository;    
    @Autowired
    private GradeCurricularRepository gradeCurricularRepository;
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private GradeHorariaRepository gradeHorariaRepository;
    @Autowired
    private TempoRepository tempoRepository;
    @Autowired
    private EmebRepository emebRepository;
    @Autowired
    private TurmAlunRepository turmAlunRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private BairroRepository bairroRepository;
    @Autowired
    private CepRepository cepRepository;

    public void instantiateTestDatabase() throws ParseException {

        // ---------------------------------------- CRIAÇÃO DOS DADOS ----------------------------------------
        Pessoa p1 = Pessoa.builder().nomePess("Carlos Henrique Garioli").celular("99999999999").cpf("67156552007").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p2 = Pessoa.builder().nomePess("Lucas Ribeiro Garioli").celular("99999999999").cpf("24654143050").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p3 = Pessoa.builder().nomePess("Fernando Ribeiro Garioli").celular("99999999999").cpf("25423465001").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p4 = Pessoa.builder().nomePess("João da Silva").celular("99999999999").cpf("56296233035").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p5 = Pessoa.builder().nomePess("José Oliveira").celular("99999999999").cpf("79783119028").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p6 = Pessoa.builder().nomePess("Mariana Pereira").celular("99999999999").cpf("96591359044").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p7 = Pessoa.builder().nomePess("Adriana Bragança").celular("99999999999").cpf("62169218009").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p8 = Pessoa.builder().nomePess("Cláudia Bourbon").celular("99999999999").cpf("56841239024").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p9 = Pessoa.builder().nomePess("Alline Alves").celular("99999999999").cpf("61291032045").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p10 = Pessoa.builder().nomePess("Alexandre Barbosa").celular("99999999999").cpf("66861913022").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();

        Responsavel r1 = Responsavel.builder().pessoa(p1).build();
        Aluno a1 = Aluno.builder().pessoa(p2).build();
        Aluno a2 = Aluno.builder().pessoa(p3).build();

        Vinculo v1 = Vinculo.builder().aluno(a1).responsavel(r1).ehResp('1').build();
        Vinculo v2 = Vinculo.builder().aluno(a2).responsavel(r1).ehResp('1').build();

        Usuario u1 = Usuario.builder().pessoa(p1).login("95303831000").senha(pe.encode("123456")).build();
        Usuario u2 = Usuario.builder().pessoa(p2).login("05776036046").senha(pe.encode("123456")).build();
        Usuario u3 = Usuario.builder().pessoa(p3).login("80859538036").senha(pe.encode("123456")).build();
        
        Matricula m1 = Matricula.builder().aluno(a1).dtInic(LocalDate.now()).matr("TESTE2018").build();
        Matricula m2 = Matricula.builder().aluno(a2).dtInic(LocalDate.now()).matr("TESTE2018").build();
        
        Disciplina d1 = Disciplina.builder().nomeDisc("Matemática").build();
        Disciplina d2 = Disciplina.builder().nomeDisc("Português").build();
        Disciplina d3 = Disciplina.builder().nomeDisc("Inglês").build();
        Disciplina d4 = Disciplina.builder().nomeDisc("História").build();
        Disciplina d5 = Disciplina.builder().nomeDisc("Geografia").build();
        Disciplina d6 = Disciplina.builder().nomeDisc("Ciências").build();
        Disciplina d7 = Disciplina.builder().nomeDisc("Educação Física").build();
        
        Funcionario f1 = Funcionario.builder().ehDocente('1').pessoa(p4).build();
        Funcionario f2 = Funcionario.builder().ehDocente('1').pessoa(p5).build();
        Funcionario f3 = Funcionario.builder().ehDocente('1').pessoa(p6).build();
        Funcionario f4 = Funcionario.builder().ehDocente('1').pessoa(p7).build();
        Funcionario f5 = Funcionario.builder().ehDocente('1').pessoa(p8).build();
        Funcionario f6 = Funcionario.builder().ehDocente('1').pessoa(p9).build();
        Funcionario f7 = Funcionario.builder().ehDocente('1').pessoa(p10).build();
        
        Docente dc1 = Docente.builder().funcionario(f1).build();
        Docente dc2 = Docente.builder().funcionario(f2).build();
        Docente dc3 = Docente.builder().funcionario(f3).build();
        Docente dc4 = Docente.builder().funcionario(f4).build();
        Docente dc5 = Docente.builder().funcionario(f5).build();
        Docente dc6 = Docente.builder().funcionario(f6).build();
        Docente dc7 = Docente.builder().funcionario(f7).build();
        
        Ano an1 = Ano.builder().descrAno("1º").build();
        Ano an2 = Ano.builder().descrAno("2º").build();
        
        GradeCurricular gc1 = GradeCurricular.builder().ano(an1).disciplina(d1).build();
        GradeCurricular gc2 = GradeCurricular.builder().ano(an1).disciplina(d2).build();
        GradeCurricular gc3 = GradeCurricular.builder().ano(an1).disciplina(d3).build();
        GradeCurricular gc4 = GradeCurricular.builder().ano(an1).disciplina(d4).build();
        GradeCurricular gc5 = GradeCurricular.builder().ano(an1).disciplina(d5).build();
        GradeCurricular gc6 = GradeCurricular.builder().ano(an1).disciplina(d6).build();
        GradeCurricular gc7 = GradeCurricular.builder().ano(an1).disciplina(d7).build();
        
        GradeCurricular gc8 = GradeCurricular.builder().ano(an2).disciplina(d1).build();
        GradeCurricular gc9 = GradeCurricular.builder().ano(an2).disciplina(d2).build();
        GradeCurricular gc10 = GradeCurricular.builder().ano(an2).disciplina(d3).build();
        GradeCurricular gc11 = GradeCurricular.builder().ano(an2).disciplina(d4).build();
        GradeCurricular gc12 = GradeCurricular.builder().ano(an2).disciplina(d5).build();
        GradeCurricular gc13 = GradeCurricular.builder().ano(an2).disciplina(d6).build();
        GradeCurricular gc14 = GradeCurricular.builder().ano(an2).disciplina(d7).build();
        
        Estado e1 = Estado.builder().nomeEstado("Espírito Santo").siglaEstado("ES").build();
        
        Cidade c1 = Cidade.builder().estado(e1).nomeCidade("Cachoeiro de Itapemirim").build();
        
        Bairro b1 = Bairro.builder().cidade(c1).nomeBair("Centro").build();
        
        Cep cp1 = Cep.builder().bairro(b1).cep("29304689").complemento("teste").descrCep("Rua Teste").build();
        
        Emeb e = Emeb.builder().nomeEmeb("EMEB Teste").cep(cp1).build();
        
        Turma t1 = Turma.builder().dtInic(LocalDate.now()).emeb(e).exercicio(2018).nomeTurm("1º M1").build();
        Turma t2 = Turma.builder().dtInic(LocalDate.now()).emeb(e).exercicio(2018).nomeTurm("2º M1").build();
        
        TurmAlun tm1 = TurmAlun.builder().dtInic(LocalDate.now()).matricula(m1).turma(t1).build();
        TurmAlun tm2 = TurmAlun.builder().dtInic(LocalDate.now()).matricula(m2).turma(t2).build();
        
        GradeHoraria gh1 = GradeHoraria.builder().docente(dc1).gradeCurricular(gc1).turma(t1).build();
        GradeHoraria gh2 = GradeHoraria.builder().docente(dc2).gradeCurricular(gc2).turma(t1).build();
        GradeHoraria gh3 = GradeHoraria.builder().docente(dc3).gradeCurricular(gc3).turma(t1).build();
        GradeHoraria gh4 = GradeHoraria.builder().docente(dc4).gradeCurricular(gc4).turma(t1).build();
        GradeHoraria gh5 = GradeHoraria.builder().docente(dc5).gradeCurricular(gc5).turma(t1).build();
        GradeHoraria gh6 = GradeHoraria.builder().docente(dc6).gradeCurricular(gc6).turma(t1).build();
        GradeHoraria gh7 = GradeHoraria.builder().docente(dc7).gradeCurricular(gc7).turma(t1).build();
        
        GradeHoraria gh8 = GradeHoraria.builder().docente(dc1).gradeCurricular(gc8).turma(t2).build();
        GradeHoraria gh9 = GradeHoraria.builder().docente(dc2).gradeCurricular(gc9).turma(t2).build();
        GradeHoraria gh10 = GradeHoraria.builder().docente(dc3).gradeCurricular(gc10).turma(t2).build();
        GradeHoraria gh11 = GradeHoraria.builder().docente(dc4).gradeCurricular(gc11).turma(t2).build();
        GradeHoraria gh12 = GradeHoraria.builder().docente(dc5).gradeCurricular(gc12).turma(t2).build();
        GradeHoraria gh13 = GradeHoraria.builder().docente(dc6).gradeCurricular(gc13).turma(t2).build();
        GradeHoraria gh14 = GradeHoraria.builder().docente(dc7).gradeCurricular(gc14).turma(t2).build();
        
        Tempo tp1 = Tempo.builder().diaSemana(1).gradeHoraria(gh1).tempo(1).build();
        Tempo tp2 = Tempo.builder().diaSemana(1).gradeHoraria(gh1).tempo(2).build();
        Tempo tp3 = Tempo.builder().diaSemana(1).gradeHoraria(gh1).tempo(3).build();
        Tempo tp4 = Tempo.builder().diaSemana(1).gradeHoraria(gh1).tempo(4).build();
        Tempo tp5 = Tempo.builder().diaSemana(1).gradeHoraria(gh1).tempo(5).build();
        
        Tempo tp6 = Tempo.builder().diaSemana(2).gradeHoraria(gh2).tempo(1).build();
        Tempo tp7 = Tempo.builder().diaSemana(2).gradeHoraria(gh2).tempo(2).build();
        Tempo tp8 = Tempo.builder().diaSemana(2).gradeHoraria(gh2).tempo(3).build();
        Tempo tp9 = Tempo.builder().diaSemana(2).gradeHoraria(gh2).tempo(4).build();
        Tempo tp10 = Tempo.builder().diaSemana(2).gradeHoraria(gh2).tempo(5).build();
        
        Tempo tp11 = Tempo.builder().diaSemana(3).gradeHoraria(gh3).tempo(1).build();
        Tempo tp12 = Tempo.builder().diaSemana(3).gradeHoraria(gh3).tempo(2).build();
        Tempo tp13 = Tempo.builder().diaSemana(3).gradeHoraria(gh4).tempo(3).build();
        Tempo tp14 = Tempo.builder().diaSemana(3).gradeHoraria(gh4).tempo(4).build();
        Tempo tp15 = Tempo.builder().diaSemana(3).gradeHoraria(gh4).tempo(5).build();
        
        Tempo tp16 = Tempo.builder().diaSemana(4).gradeHoraria(gh5).tempo(1).build();
        Tempo tp17 = Tempo.builder().diaSemana(4).gradeHoraria(gh5).tempo(2).build();
        Tempo tp18 = Tempo.builder().diaSemana(4).gradeHoraria(gh5).tempo(3).build();
        Tempo tp19 = Tempo.builder().diaSemana(4).gradeHoraria(gh6).tempo(4).build();
        Tempo tp20 = Tempo.builder().diaSemana(4).gradeHoraria(gh6).tempo(5).build();
        
        Tempo tp21 = Tempo.builder().diaSemana(5).gradeHoraria(gh3).tempo(1).build();
        Tempo tp22 = Tempo.builder().diaSemana(5).gradeHoraria(gh7).tempo(2).build();
        Tempo tp23 = Tempo.builder().diaSemana(5).gradeHoraria(gh7).tempo(3).build();
        Tempo tp24 = Tempo.builder().diaSemana(5).gradeHoraria(gh4).tempo(4).build();
        Tempo tp25 = Tempo.builder().diaSemana(5).gradeHoraria(gh4).tempo(5).build();
        
        Tempo tp26 = Tempo.builder().diaSemana(1).gradeHoraria(gh8).tempo(1).build();
        Tempo tp27 = Tempo.builder().diaSemana(1).gradeHoraria(gh8).tempo(2).build();
        Tempo tp28 = Tempo.builder().diaSemana(1).gradeHoraria(gh8).tempo(3).build();
        Tempo tp29 = Tempo.builder().diaSemana(1).gradeHoraria(gh8).tempo(4).build();
        Tempo tp30 = Tempo.builder().diaSemana(1).gradeHoraria(gh8).tempo(5).build();
        
        Tempo tp31 = Tempo.builder().diaSemana(2).gradeHoraria(gh10).tempo(1).build();
        Tempo tp32 = Tempo.builder().diaSemana(2).gradeHoraria(gh10).tempo(2).build();
        Tempo tp33 = Tempo.builder().diaSemana(2).gradeHoraria(gh11).tempo(3).build();
        Tempo tp34 = Tempo.builder().diaSemana(2).gradeHoraria(gh11).tempo(4).build();
        Tempo tp35 = Tempo.builder().diaSemana(2).gradeHoraria(gh11).tempo(5).build();
        
        Tempo tp36 = Tempo.builder().diaSemana(3).gradeHoraria(gh9).tempo(1).build();
        Tempo tp37 = Tempo.builder().diaSemana(3).gradeHoraria(gh9).tempo(2).build();
        Tempo tp38 = Tempo.builder().diaSemana(3).gradeHoraria(gh12).tempo(3).build();
        Tempo tp39 = Tempo.builder().diaSemana(3).gradeHoraria(gh12).tempo(4).build();
        Tempo tp40 = Tempo.builder().diaSemana(3).gradeHoraria(gh12).tempo(5).build();
        
        Tempo tp41 = Tempo.builder().diaSemana(4).gradeHoraria(gh13).tempo(1).build();
        Tempo tp42 = Tempo.builder().diaSemana(4).gradeHoraria(gh13).tempo(2).build();
        Tempo tp43 = Tempo.builder().diaSemana(4).gradeHoraria(gh13).tempo(3).build();
        Tempo tp44 = Tempo.builder().diaSemana(4).gradeHoraria(gh14).tempo(4).build();
        Tempo tp45 = Tempo.builder().diaSemana(4).gradeHoraria(gh14).tempo(5).build();
        
        Tempo tp46 = Tempo.builder().diaSemana(5).gradeHoraria(gh14).tempo(1).build();
        Tempo tp47 = Tempo.builder().diaSemana(5).gradeHoraria(gh14).tempo(2).build();
        Tempo tp48 = Tempo.builder().diaSemana(5).gradeHoraria(gh10).tempo(3).build();
        Tempo tp49 = Tempo.builder().diaSemana(5).gradeHoraria(gh10).tempo(4).build();
        Tempo tp50 = Tempo.builder().diaSemana(5).gradeHoraria(gh9).tempo(5).build();
        

        // ---------------------------------------- INSERÇÃO DE DADOS ---------------------------------------- 
        pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
        responsavelRepository.save(r1);
        alunoRepository.saveAll(Arrays.asList(a1, a2));
        vinculoRepository.saveAll(Arrays.asList(v1, v2));
        usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
        matriculaRepository.saveAll(Arrays.asList(m1, m2));
        disciplinaRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7));
        funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f7));
        docenteRepository.saveAll(Arrays.asList(dc1, dc2, dc3, dc4, dc5, dc6, dc7));
        anoRepository.saveAll(Arrays.asList(an1, an2));
        gradeCurricularRepository.saveAll(Arrays.asList(gc1, gc2, gc3, gc4, gc5, gc6, gc7, gc8, gc9, gc10, gc11, gc12, gc13, gc14));
        estadoRepository.saveAll(Arrays.asList(e1));
        cidadeRepository.saveAll(Arrays.asList(c1));
        bairroRepository.saveAll(Arrays.asList(b1));
        cepRepository.saveAll(Arrays.asList(cp1));
        emebRepository.saveAll(Arrays.asList(e));
        turmaRepository.saveAll(Arrays.asList(t1, t2));
        turmAlunRepository.saveAll(Arrays.asList(tm1, tm2));
        gradeHorariaRepository.saveAll(Arrays.asList(gh1, gh2, gh3, gh4, gh5, gh6, gh7, gh8, gh9, gh10, gh11, gh12, gh13, gh14));
        tempoRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6, tp7, tp8, tp9, tp10, tp11, tp12, tp13, tp14, tp15, tp16, tp17, tp18, tp19, tp20, tp21, tp22, tp23, tp24, tp25, tp26, tp27, tp28, tp29, tp30, tp31, tp32, tp33, tp34, tp35, tp36, tp37, tp38, tp39, tp40, tp41, tp42, tp43, tp44, tp45, tp46, tp47, tp48, tp49, tp50));
    }
}
