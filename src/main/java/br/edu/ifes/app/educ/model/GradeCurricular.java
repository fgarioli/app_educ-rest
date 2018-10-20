package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class GradeCurricular {
	private Integer codGrCu;
	public Disciplina disciplina;
	public Ano ano;
	public ArrayList<GradeHoraria> gradeHoraria = new ArrayList<GradeHoraria>();
}