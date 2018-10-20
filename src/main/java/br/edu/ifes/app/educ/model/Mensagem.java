package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Mensagem {
	private Long codMsg;
	private String descrMsg;
	private String msg;
	public ArrayList<MensagemUsuario> mensagemUsuario = new ArrayList<MensagemUsuario>();
	public Usuario remetente;
}