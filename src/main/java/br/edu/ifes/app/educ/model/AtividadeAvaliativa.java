package br.edu.ifes.app.educ.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class AtividadeAvaliativa {

    private Integer codAtivAval;
    private LocalDate dataAtiv;
    private String descrAtiv;
    private Integer periodo;
    private Double valor;
    public GradeHoraria gradeHoraria;
    public ArrayList<NotaAtivAval> notaAtivAval = new ArrayList<NotaAtivAval>();
    public Dominio tipo_de_Atividade;
    
}
