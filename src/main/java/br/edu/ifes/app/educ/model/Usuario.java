package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Usuario {
	private Long codUsuario;
	private String login;
	private String senha;
	public ArrayList<MensagemUsuario> mensagemUsuario = new ArrayList<MensagemUsuario>();
	public ArrayList<Mensagem> remetente = new ArrayList<Mensagem>();
	public Pessoa pessoa;
}