package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Cidade {
	private Integer codCidade;
	private String nomeCidade;
	public Estado estado;
	public ArrayList<Bairro> bairro = new ArrayList<Bairro>();
}