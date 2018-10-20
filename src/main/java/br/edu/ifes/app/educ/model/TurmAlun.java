package br.edu.ifes.app.educ.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class TurmAlun {

    private Integer codTurmAlun;
    private LocalDate dtInic;
    private LocalDate dtFim;
    public Matricula matricula;
    public Turma turma;
    public ArrayList<NotaTrimestral> notaTrimestral = new ArrayList<>();
    
}
