package br.edu.ifes.app.educ.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pauta {

    private Integer codPauta;
    private LocalDate dataPauta;
    private String conteudo;
    private Integer qtdAulas;
    private Integer periodo;
    public ArrayList<Frequencia> frequencia = new ArrayList<>();
    public GradeHoraria gradeHoraria;
    
}
