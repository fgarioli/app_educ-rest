package br.edu.ifes.app.educ.model;

import java.util.ArrayList;

public class Tempo {
	private Integer codTempo;
	private Integer tempo;
	private Integer diaSemana;
	public GradeHoraria gradeHoraria;
	public ArrayList<Frequencia> frequencia = new ArrayList<Frequencia>();
}