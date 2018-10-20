package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class NotaTrimestral {
	private Integer codNotaTrim;
	private Double notaValor;
	private Integer qtdFaltas;
	private String notaDescr;
	public ArrayList<Frequencia> frequencia = new ArrayList<Frequencia>();
	public TurmAlun turmAlun;
	public ArrayList<NotaAtivAval> notaAtivAval = new ArrayList<NotaAtivAval>();
}