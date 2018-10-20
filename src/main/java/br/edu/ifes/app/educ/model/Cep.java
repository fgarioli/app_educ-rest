package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Cep {
	private Integer codCep;
	private String descrCep;
	private String cep;
	private String complemento;
	public ArrayList<Emeb> emeb = new ArrayList<Emeb>();
	public Bairro bairro;
}