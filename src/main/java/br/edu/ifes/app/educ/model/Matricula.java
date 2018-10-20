package br.edu.ifes.app.educ.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Matricula {

    private Integer codMatr;
    private String matr;
    private LocalDate dtInic;
    private LocalDate dtFim;
    public Aluno aluno;
    public ArrayList<TurmAlun> turmAlun = new ArrayList<>();
    
}
