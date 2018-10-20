package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class GradeHoraria {
	private Integer codGrHr;
	public ArrayList<Pauta> pauta = new ArrayList<Pauta>();
	public Docente docente;
	public GradeCurricular gradeCurricular;
	public ArrayList<Tempo> tempo = new ArrayList<Tempo>();
	public ArrayList<AtividadeAvaliativa> atividadeAvaliativa = new ArrayList<AtividadeAvaliativa>();
	public Turma turma;
}