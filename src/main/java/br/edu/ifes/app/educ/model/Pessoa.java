package br.edu.ifes.app.educ.model;

import java.time.LocalDate;

public class Pessoa {

    private Integer codPess;
    private String nomePess;
    private String cpf;
    private String rg;
    private LocalDate dtExpRg;
    private String rgCompl;
    private LocalDate dtNasc;
    private String email;
    private String nacionalidade;
    private String nomePai;
    private String nomeMae;
    private String telefone;
    private String telefonePai;
    private String telefoneMae;
    private String celular;
    public Aluno aluno;
    public Funcionario funcionario;
    public Usuario usuario;
    public Responsavel responsavel;
    
}
