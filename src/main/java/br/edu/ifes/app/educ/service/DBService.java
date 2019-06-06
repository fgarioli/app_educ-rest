package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.security.ShaPasswordEncoder;
import br.edu.ifes.app.educ.model.Aluno;
import br.edu.ifes.app.educ.model.Ano;
import br.edu.ifes.app.educ.model.AtividadeAvaliativa;
import br.edu.ifes.app.educ.model.Bairro;
import br.edu.ifes.app.educ.model.Cep;
import br.edu.ifes.app.educ.model.Cidade;
import br.edu.ifes.app.educ.model.DataCalendario;
import br.edu.ifes.app.educ.model.Disciplina;
import br.edu.ifes.app.educ.model.Docente;
import br.edu.ifes.app.educ.model.Dominio;
import br.edu.ifes.app.educ.model.Emeb;
import br.edu.ifes.app.educ.model.Estado;
import br.edu.ifes.app.educ.model.Frequencia;
import br.edu.ifes.app.educ.model.Funcionario;
import br.edu.ifes.app.educ.model.GradeCurricular;
import br.edu.ifes.app.educ.model.GradeHoraria;
import br.edu.ifes.app.educ.model.Matricula;
import br.edu.ifes.app.educ.model.Mensagem;
import br.edu.ifes.app.educ.model.MensagemUsuario;
import br.edu.ifes.app.educ.model.NotaAtivAval;
import br.edu.ifes.app.educ.model.NotaTrimestral;
import br.edu.ifes.app.educ.model.Pauta;
import br.edu.ifes.app.educ.model.Periodo;
import br.edu.ifes.app.educ.model.Pessoa;
import br.edu.ifes.app.educ.model.Responsavel;
import br.edu.ifes.app.educ.model.Tempo;
import br.edu.ifes.app.educ.model.TurmAlun;
import br.edu.ifes.app.educ.model.Turma;
import br.edu.ifes.app.educ.model.Turno;
import br.edu.ifes.app.educ.model.Usuario;
import br.edu.ifes.app.educ.model.Vinculo;
import br.edu.ifes.app.educ.repository.AlunoRepository;
import br.edu.ifes.app.educ.repository.AnoRepository;
import br.edu.ifes.app.educ.repository.AtividadeAvaliativaRepository;
import br.edu.ifes.app.educ.repository.BairroRepository;
import br.edu.ifes.app.educ.repository.CepRepository;
import br.edu.ifes.app.educ.repository.CidadeRepository;
import br.edu.ifes.app.educ.repository.DataCalendarioRepository;
import br.edu.ifes.app.educ.repository.DisciplinaRepository;
import br.edu.ifes.app.educ.repository.DocenteRepository;
import br.edu.ifes.app.educ.repository.DominioRepository;
import br.edu.ifes.app.educ.repository.EmebRepository;
import br.edu.ifes.app.educ.repository.EstadoRepository;
import br.edu.ifes.app.educ.repository.FrequenciaRepository;
import br.edu.ifes.app.educ.repository.FuncionarioRepository;
import br.edu.ifes.app.educ.repository.GradeCurricularRepository;
import br.edu.ifes.app.educ.repository.GradeHorariaRepository;
import br.edu.ifes.app.educ.repository.MatriculaRepository;
import br.edu.ifes.app.educ.repository.MensagemRepository;
import br.edu.ifes.app.educ.repository.MensagemUsuarioRepository;
import br.edu.ifes.app.educ.repository.NotaAtivAvalRepository;
import br.edu.ifes.app.educ.repository.NotaTrimestralRepository;
import br.edu.ifes.app.educ.repository.PautaRepository;
import br.edu.ifes.app.educ.repository.PeriodoRepository;
import br.edu.ifes.app.educ.repository.PessoaRepository;
import br.edu.ifes.app.educ.repository.ResponsavelRepository;
import br.edu.ifes.app.educ.repository.TempoRepository;
import br.edu.ifes.app.educ.repository.TurmAlunRepository;
import br.edu.ifes.app.educ.repository.TurmaRepository;
import br.edu.ifes.app.educ.repository.TurnoRepository;
import br.edu.ifes.app.educ.repository.UsuarioRepository;
import br.edu.ifes.app.educ.repository.VinculoRepository;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DBService {

//    @Autowired
//    private BCryptPasswordEncoder pe;
    @Autowired
    private ShaPasswordEncoder pe;
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
    @Autowired
    private PeriodoRepository periodoRepository;
    @Autowired
    private DominioRepository dominioRepository;
    @Autowired
    private AtividadeAvaliativaRepository ativAvalRepository;
    @Autowired
    private NotaTrimestralRepository notaTrimestralRepository;
    @Autowired
    private NotaAtivAvalRepository notaAtivAvalRepository;
    @Autowired
    private PautaRepository pautaRepository;
    @Autowired
    private FrequenciaRepository frequenciaRepository;
    @Autowired
    private DataCalendarioRepository dataRepository;
    @Autowired
    private MensagemRepository mensagemRepository;
    @Autowired
    private MensagemUsuarioRepository mensagemUsuarioRepository;
    @Autowired
    private TurnoRepository turnoRepository;

    public void instantiateTestDatabase() throws ParseException {

        // ---------------------------------------- CRIAÇÃO DOS DADOS ----------------------------------------
        Pessoa p1 = Pessoa.builder().nomePess("Carlos Henrique Garioli").celular("99999999999").cpf("67156552007").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
        Pessoa p2 = Pessoa.builder().nomePess("Pedro Henrique Silva").celular("99999999999").cpf("24654143050").dtExpRg(LocalDate.now()).dtNasc(LocalDate.now()).email("teste@teste.com.br").nacionalidade("brasileiro").nomeMae("Maria das Graças").nomePai("José da Silva").rg("123456").rgCompl("teste").telefone("289998989899").telefoneMae("12333336666").telefonePai("12444448888").build();
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

        Usuario u1 = Usuario.builder().pessoa(p1).login("teste").senha(pe.encode("123")).build();
        Usuario u2 = Usuario.builder().pessoa(p2).login("24654143050").senha(pe.encode("123456")).build();
        Usuario u3 = Usuario.builder().pessoa(p3).login("25423465001").senha(pe.encode("123456")).build();

        Matricula m1 = Matricula.builder().aluno(a1).dtInic(LocalDate.now()).matr("TESTE2019").build();
        Matricula m2 = Matricula.builder().aluno(a2).dtInic(LocalDate.now()).matr("TESTE2019").build();

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

        Emeb e = Emeb.builder().nomeEmeb("EMEB SANDRA MONTEIRO").cep(cp1).build();

        Turno tn1 = Turno.builder().turndescr("MATUTINO").build();
        Turno tn2 = Turno.builder().turndescr("VESPERTINO").build();
        Turno tn3 = Turno.builder().turndescr("NOTURNO").build();

        Turma t1 = Turma.builder().dtInic(LocalDate.now()).emeb(e).exercicio(2019).nomeTurm("MATERNAL II V1").turno(tn1).build();
        Turma t2 = Turma.builder().dtInic(LocalDate.now()).emeb(e).exercicio(2019).nomeTurm("2º M1").turno(tn2).build();

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

        Tempo tp1 = Tempo.builder().diaSemana(2).gradeHoraria(gh1).tempo(1).build();
        Tempo tp2 = Tempo.builder().diaSemana(2).gradeHoraria(gh1).tempo(2).build();
        Tempo tp3 = Tempo.builder().diaSemana(2).gradeHoraria(gh1).tempo(3).build();
        Tempo tp4 = Tempo.builder().diaSemana(2).gradeHoraria(gh1).tempo(4).build();
        Tempo tp5 = Tempo.builder().diaSemana(2).gradeHoraria(gh1).tempo(5).build();

        Tempo tp6 = Tempo.builder().diaSemana(3).gradeHoraria(gh2).tempo(1).build();
        Tempo tp7 = Tempo.builder().diaSemana(3).gradeHoraria(gh2).tempo(2).build();
        Tempo tp8 = Tempo.builder().diaSemana(3).gradeHoraria(gh2).tempo(3).build();
        Tempo tp9 = Tempo.builder().diaSemana(3).gradeHoraria(gh2).tempo(4).build();
        Tempo tp10 = Tempo.builder().diaSemana(3).gradeHoraria(gh2).tempo(5).build();

        Tempo tp11 = Tempo.builder().diaSemana(4).gradeHoraria(gh3).tempo(1).build();
        Tempo tp12 = Tempo.builder().diaSemana(4).gradeHoraria(gh3).tempo(2).build();
        Tempo tp13 = Tempo.builder().diaSemana(4).gradeHoraria(gh4).tempo(3).build();
        Tempo tp14 = Tempo.builder().diaSemana(4).gradeHoraria(gh4).tempo(4).build();
        Tempo tp15 = Tempo.builder().diaSemana(4).gradeHoraria(gh4).tempo(5).build();

        Tempo tp16 = Tempo.builder().diaSemana(5).gradeHoraria(gh5).tempo(1).build();
        Tempo tp17 = Tempo.builder().diaSemana(5).gradeHoraria(gh5).tempo(2).build();
        Tempo tp18 = Tempo.builder().diaSemana(5).gradeHoraria(gh5).tempo(3).build();
        Tempo tp19 = Tempo.builder().diaSemana(5).gradeHoraria(gh6).tempo(4).build();
        Tempo tp20 = Tempo.builder().diaSemana(5).gradeHoraria(gh6).tempo(5).build();

        Tempo tp21 = Tempo.builder().diaSemana(6).gradeHoraria(gh3).tempo(1).build();
        Tempo tp22 = Tempo.builder().diaSemana(6).gradeHoraria(gh7).tempo(2).build();
        Tempo tp23 = Tempo.builder().diaSemana(6).gradeHoraria(gh7).tempo(3).build();
        Tempo tp24 = Tempo.builder().diaSemana(6).gradeHoraria(gh4).tempo(4).build();
        Tempo tp25 = Tempo.builder().diaSemana(6).gradeHoraria(gh4).tempo(5).build();

        Tempo tp26 = Tempo.builder().diaSemana(2).gradeHoraria(gh8).tempo(1).build();
        Tempo tp27 = Tempo.builder().diaSemana(2).gradeHoraria(gh8).tempo(2).build();
        Tempo tp28 = Tempo.builder().diaSemana(2).gradeHoraria(gh8).tempo(3).build();
        Tempo tp29 = Tempo.builder().diaSemana(2).gradeHoraria(gh8).tempo(4).build();
        Tempo tp30 = Tempo.builder().diaSemana(2).gradeHoraria(gh8).tempo(5).build();

        Tempo tp31 = Tempo.builder().diaSemana(3).gradeHoraria(gh10).tempo(1).build();
        Tempo tp32 = Tempo.builder().diaSemana(3).gradeHoraria(gh10).tempo(2).build();
        Tempo tp33 = Tempo.builder().diaSemana(3).gradeHoraria(gh11).tempo(3).build();
        Tempo tp34 = Tempo.builder().diaSemana(3).gradeHoraria(gh11).tempo(4).build();
        Tempo tp35 = Tempo.builder().diaSemana(3).gradeHoraria(gh11).tempo(5).build();

        Tempo tp36 = Tempo.builder().diaSemana(4).gradeHoraria(gh9).tempo(1).build();
        Tempo tp37 = Tempo.builder().diaSemana(4).gradeHoraria(gh9).tempo(2).build();
        Tempo tp38 = Tempo.builder().diaSemana(4).gradeHoraria(gh12).tempo(3).build();
        Tempo tp39 = Tempo.builder().diaSemana(4).gradeHoraria(gh12).tempo(4).build();
        Tempo tp40 = Tempo.builder().diaSemana(4).gradeHoraria(gh12).tempo(5).build();

        Tempo tp41 = Tempo.builder().diaSemana(5).gradeHoraria(gh13).tempo(1).build();
        Tempo tp42 = Tempo.builder().diaSemana(5).gradeHoraria(gh13).tempo(2).build();
        Tempo tp43 = Tempo.builder().diaSemana(5).gradeHoraria(gh13).tempo(3).build();
        Tempo tp44 = Tempo.builder().diaSemana(5).gradeHoraria(gh14).tempo(4).build();
        Tempo tp45 = Tempo.builder().diaSemana(5).gradeHoraria(gh14).tempo(5).build();

        Tempo tp46 = Tempo.builder().diaSemana(6).gradeHoraria(gh14).tempo(1).build();
        Tempo tp47 = Tempo.builder().diaSemana(6).gradeHoraria(gh14).tempo(2).build();
        Tempo tp48 = Tempo.builder().diaSemana(6).gradeHoraria(gh10).tempo(3).build();
        Tempo tp49 = Tempo.builder().diaSemana(6).gradeHoraria(gh10).tempo(4).build();
        Tempo tp50 = Tempo.builder().diaSemana(6).gradeHoraria(gh9).tempo(5).build();

        Dominio domi = Dominio.builder().descrDomi("PROVA").build();

        Periodo pr1 = Periodo.builder().numPeriodo(new Integer(1).shortValue()).build();
        Periodo pr2 = Periodo.builder().numPeriodo(new Integer(2).shortValue()).build();
        Periodo pr3 = Periodo.builder().numPeriodo(new Integer(3).shortValue()).build();

        AtividadeAvaliativa aa1 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh1).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa2 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh2).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa3 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh3).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa4 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh4).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa5 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh5).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa6 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh6).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa7 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh7).tipoAtiv(domi).valor(10.0).build();

        AtividadeAvaliativa aa8 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh8).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa9 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh9).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa10 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh10).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa11 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh11).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa12 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh12).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa13 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh13).tipoAtiv(domi).valor(10.0).build();
        AtividadeAvaliativa aa14 = AtividadeAvaliativa.builder().dataAtiv(LocalDate.now()).periodo(3).gradeHoraria(gh14).tipoAtiv(domi).valor(10.0).build();

        NotaTrimestral nt1 = NotaTrimestral.builder().notaValor(9.5).qtdFaltas(2).turmAlun(tm1).periodo(pr3).gradeCurricular(gc1).build();
        NotaTrimestral nt2 = NotaTrimestral.builder().notaValor(9.2).qtdFaltas(4).turmAlun(tm1).periodo(pr3).gradeCurricular(gc2).build();
        NotaTrimestral nt3 = NotaTrimestral.builder().notaValor(8.5).qtdFaltas(5).turmAlun(tm1).periodo(pr3).gradeCurricular(gc3).build();
        NotaTrimestral nt4 = NotaTrimestral.builder().notaValor(7.8).qtdFaltas(0).turmAlun(tm1).periodo(pr3).gradeCurricular(gc4).build();
        NotaTrimestral nt5 = NotaTrimestral.builder().notaValor(9.2).qtdFaltas(4).turmAlun(tm1).periodo(pr3).gradeCurricular(gc5).build();
        NotaTrimestral nt6 = NotaTrimestral.builder().notaValor(10.0).qtdFaltas(0).turmAlun(tm1).periodo(pr3).gradeCurricular(gc6).build();
        NotaTrimestral nt7 = NotaTrimestral.builder().notaValor(10.0).qtdFaltas(0).turmAlun(tm1).periodo(pr3).gradeCurricular(gc7).build();

        NotaTrimestral nt8 = NotaTrimestral.builder().notaValor(9.5).qtdFaltas(2).turmAlun(tm2).periodo(pr3).gradeCurricular(gc8).build();
        NotaTrimestral nt9 = NotaTrimestral.builder().notaValor(9.2).qtdFaltas(4).turmAlun(tm2).periodo(pr3).gradeCurricular(gc9).build();
        NotaTrimestral nt10 = NotaTrimestral.builder().notaValor(8.5).qtdFaltas(5).turmAlun(tm2).periodo(pr3).gradeCurricular(gc10).build();
        NotaTrimestral nt11 = NotaTrimestral.builder().notaValor(7.8).qtdFaltas(0).turmAlun(tm2).periodo(pr3).gradeCurricular(gc11).build();
        NotaTrimestral nt12 = NotaTrimestral.builder().notaValor(9.2).qtdFaltas(4).turmAlun(tm2).periodo(pr3).gradeCurricular(gc12).build();
        NotaTrimestral nt13 = NotaTrimestral.builder().notaValor(10.0).qtdFaltas(0).turmAlun(tm2).periodo(pr3).gradeCurricular(gc13).build();
        NotaTrimestral nt14 = NotaTrimestral.builder().notaValor(10.0).qtdFaltas(0).turmAlun(tm2).periodo(pr3).gradeCurricular(gc14).build();

        NotaAtivAval naa1 = NotaAtivAval.builder().atividadeAvaliativa(aa1).notaValor(9.5).notaTrimestral(nt1).build();
        NotaAtivAval naa2 = NotaAtivAval.builder().atividadeAvaliativa(aa2).notaValor(9.2).notaTrimestral(nt2).build();
        NotaAtivAval naa3 = NotaAtivAval.builder().atividadeAvaliativa(aa3).notaValor(8.5).notaTrimestral(nt3).build();
        NotaAtivAval naa4 = NotaAtivAval.builder().atividadeAvaliativa(aa4).notaValor(7.8).notaTrimestral(nt4).build();
        NotaAtivAval naa5 = NotaAtivAval.builder().atividadeAvaliativa(aa5).notaValor(9.2).notaTrimestral(nt5).build();
        NotaAtivAval naa6 = NotaAtivAval.builder().atividadeAvaliativa(aa6).notaValor(10.0).notaTrimestral(nt6).build();
        NotaAtivAval naa7 = NotaAtivAval.builder().atividadeAvaliativa(aa7).notaValor(10.0).notaTrimestral(nt7).build();

        NotaAtivAval naa8 = NotaAtivAval.builder().atividadeAvaliativa(aa8).notaValor(9.5).notaTrimestral(nt8).build();
        NotaAtivAval naa9 = NotaAtivAval.builder().atividadeAvaliativa(aa9).notaValor(9.2).notaTrimestral(nt9).build();
        NotaAtivAval naa10 = NotaAtivAval.builder().atividadeAvaliativa(aa10).notaValor(8.5).notaTrimestral(nt10).build();
        NotaAtivAval naa11 = NotaAtivAval.builder().atividadeAvaliativa(aa11).notaValor(7.8).notaTrimestral(nt11).build();
        NotaAtivAval naa12 = NotaAtivAval.builder().atividadeAvaliativa(aa12).notaValor(9.2).notaTrimestral(nt12).build();
        NotaAtivAval naa13 = NotaAtivAval.builder().atividadeAvaliativa(aa13).notaValor(10.0).notaTrimestral(nt13).build();
        NotaAtivAval naa14 = NotaAtivAval.builder().atividadeAvaliativa(aa14).notaValor(10.0).notaTrimestral(nt14).build();

        Pauta pt1 = Pauta.builder().conteudo("Operações Aritméticas").dataPauta(LocalDate.now()).gradeHoraria(gh1).periodo(1).qtdAulas(3).build();
        Pauta pt2 = Pauta.builder().conteudo("Orações verbais").dataPauta(LocalDate.now()).gradeHoraria(gh2).periodo(1).qtdAulas(3).build();
        Pauta pt3 = Pauta.builder().conteudo("Verbo to be").dataPauta(LocalDate.now()).gradeHoraria(gh3).periodo(1).qtdAulas(3).build();
        Pauta pt4 = Pauta.builder().conteudo("Descobrimento do Brasil").dataPauta(LocalDate.now()).gradeHoraria(gh4).periodo(1).qtdAulas(3).build();
        Pauta pt5 = Pauta.builder().conteudo("Plano Cartesiano").dataPauta(LocalDate.now()).gradeHoraria(gh5).periodo(1).qtdAulas(3).build();
        Pauta pt6 = Pauta.builder().conteudo("Reino Animal").dataPauta(LocalDate.now()).gradeHoraria(gh6).periodo(1).qtdAulas(3).build();
        Pauta pt7 = Pauta.builder().conteudo("Jogo de Futsal").dataPauta(LocalDate.now()).gradeHoraria(gh7).periodo(1).qtdAulas(3).build();

        Pauta pt8 = Pauta.builder().conteudo("Operações Aritméticas").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh1).periodo(1).qtdAulas(3).build();
        Pauta pt9 = Pauta.builder().conteudo("Orações verbais").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh2).periodo(1).qtdAulas(3).build();
        Pauta pt10 = Pauta.builder().conteudo("Verbo to be").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh3).periodo(1).qtdAulas(3).build();
        Pauta pt11 = Pauta.builder().conteudo("Descobrimento do Brasil").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh4).periodo(1).qtdAulas(3).build();
        Pauta pt12 = Pauta.builder().conteudo("Plano Cartesiano").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh5).periodo(1).qtdAulas(3).build();
        Pauta pt13 = Pauta.builder().conteudo("Reino Animal").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh6).periodo(1).qtdAulas(3).build();
        Pauta pt14 = Pauta.builder().conteudo("Jogo de Futsal").dataPauta(LocalDate.now().plusDays(5)).gradeHoraria(gh7).periodo(1).qtdAulas(3).build();

        Frequencia fr1 = Frequencia.builder().notaTrimestral(nt1).pauta(pt1).presenca('0').tempo(tp1).build();
        Frequencia fr2 = Frequencia.builder().notaTrimestral(nt1).pauta(pt1).presenca('1').tempo(tp2).build();
        Frequencia fr3 = Frequencia.builder().notaTrimestral(nt1).pauta(pt1).presenca('1').tempo(tp3).build();
        Frequencia fr4 = Frequencia.builder().notaTrimestral(nt1).pauta(pt8).presenca('1').tempo(tp1).build();
        Frequencia fr5 = Frequencia.builder().notaTrimestral(nt1).pauta(pt8).presenca('0').tempo(tp2).build();
        Frequencia fr6 = Frequencia.builder().notaTrimestral(nt1).pauta(pt8).presenca('1').tempo(tp3).build();
        Frequencia fr7 = Frequencia.builder().notaTrimestral(nt1).pauta(pt2).presenca('1').tempo(tp4).build();
        Frequencia fr8= Frequencia.builder().notaTrimestral(nt1).pauta(pt3).presenca('1').tempo(tp2).build();
        Frequencia fr9 = Frequencia.builder().notaTrimestral(nt1).pauta(pt4).presenca('1').tempo(tp3).build();
        Frequencia fr10 = Frequencia.builder().notaTrimestral(nt1).pauta(pt5).presenca('1').tempo(tp1).build();

        DataCalendario dt1 = DataCalendario.builder().dataCale(LocalDate.of(2019, Month.APRIL, 21)).descrCale("Tiradentes").periodoCale(1).tipoCale('F').build();
        DataCalendario dt2 = DataCalendario.builder().dataCale(LocalDate.of(2019, Month.SEPTEMBER, 7)).descrCale("Tiradentes").periodoCale(1).tipoCale('F').build();
        DataCalendario dt3 = DataCalendario.builder().dataCale(LocalDate.of(2019, Month.NOVEMBER, 15)).descrCale("Tiradentes").periodoCale(1).tipoCale('F').build();

        Mensagem msg1 = Mensagem.builder().assunto("Mensagem de Teste").mensagem("Mensagem Teste").remetente(u1).build();

        MensagemUsuario mUsr1 = MensagemUsuario.builder().destinatario(u2).mensagem(msg1).build();
        MensagemUsuario mUsr2 = MensagemUsuario.builder().destinatario(u3).mensagem(msg1).build();
        MensagemUsuario mUsr3 = MensagemUsuario.builder().destinatario(u1).mensagem(msg1).build();

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
        turnoRepository.saveAll(Arrays.asList(tn1, tn2, tn3));
        turmaRepository.saveAll(Arrays.asList(t1, t2));
        turmAlunRepository.saveAll(Arrays.asList(tm1, tm2));
        gradeHorariaRepository.saveAll(Arrays.asList(gh1, gh2, gh3, gh4, gh5, gh6, gh7, gh8, gh9, gh10, gh11, gh12, gh13, gh14));
        tempoRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6, tp7, tp8, tp9, tp10, tp11, tp12, tp13, tp14, tp15, tp16, tp17, tp18, tp19, tp20, tp21, tp22, tp23, tp24, tp25, tp26, tp27, tp28, tp29, tp30, tp31, tp32, tp33, tp34, tp35, tp36, tp37, tp38, tp39, tp40, tp41, tp42, tp43, tp44, tp45, tp46, tp47, tp48, tp49, tp50));
        dominioRepository.saveAll(Arrays.asList(domi));
        periodoRepository.saveAll(Arrays.asList(pr1, pr2, pr3));
        ativAvalRepository.saveAll(Arrays.asList(aa1, aa2, aa3, aa4, aa5, aa6, aa7, aa8, aa9, aa10, aa11, aa12, aa13, aa14));
        notaTrimestralRepository.saveAll(Arrays.asList(nt1, nt2, nt3, nt4, nt5, nt6, nt7, nt8, nt9, nt10, nt11, nt12, nt13, nt14));
        notaAtivAvalRepository.saveAll(Arrays.asList(naa1, naa2, naa3, naa4, naa5, naa6, naa7, naa8, naa9, naa10, naa11, naa12, naa13, naa14));
        pautaRepository.saveAll(Arrays.asList(pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8, pt9, pt10, pt11, pt12, pt13, pt14));
        frequenciaRepository.saveAll(Arrays.asList(fr1, fr2, fr3));
        dataRepository.saveAll(Arrays.asList(dt1, dt2, dt3));
        mensagemRepository.saveAll(Arrays.asList(msg1));
        mensagemUsuarioRepository.saveAll(Arrays.asList(mUsr1, mUsr2, mUsr3));
    }
}
