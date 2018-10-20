package br.edu.ifes.app.educ.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Turma {

    private Integer codTurm;
    private String nomeTurm;
    private Integer exercicio;
    private LocalDate dtInic;
    private LocalDate dtFim;
    public ArrayList<GradeHoraria> gradeHoraria = new ArrayList<>();
    public ArrayList<TurmAlun> turmAlun = new ArrayList<>();
    public Emeb emeb;
    
}
