package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Bairro {
	private Integer codBair;
	private String nomeBair;
	public ArrayList<Cep> cep = new ArrayList<Cep>();
	public Cidade cidade;
}