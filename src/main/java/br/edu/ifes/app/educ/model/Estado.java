package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Estado {
	private Integer codEstado;
	private String nomeEstado;
	private String siglaEstado;
	public ArrayList<Cidade> cidade = new ArrayList<Cidade>();
}