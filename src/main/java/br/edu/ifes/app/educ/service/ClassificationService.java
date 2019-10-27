/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.repository.PessoaRepository;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author fernando
 */
@Service
public class ClassificationService {

    @Autowired
    private PessoaRepository pessoaRepository;

    private static MultilayerPerceptron mlp;

    private static Instances ins;

    private Instances getInstances() throws Exception {
        if (this.ins == null) {
            DataSource ds = new DataSource(getClass().getResourceAsStream("/weka/dados.arff"));
            this.ins = ds.getDataSet();
            ins.setClassIndex(19);
        }
        return this.ins;
    }

    private Classifier getClassifier() throws Exception {
        if (this.mlp == null) {
            this.mlp = new MultilayerPerceptron();
            this.mlp.setGUI(false);
            this.mlp.setAutoBuild(true);
            this.mlp.setBatchSize("100");
            this.mlp.setHiddenLayers("o,t,i");
            this.mlp.setLearningRate(0.6);
            this.mlp.setMomentum(0.2);
            this.mlp.setNominalToBinaryFilter(true);
            this.mlp.setNormalizeAttributes(true);
            this.mlp.setNormalizeNumericClass(true);
            this.mlp.setNumDecimalPlaces(2);
            this.mlp.setTrainingTime(300);
            this.mlp.setValidationThreshold(20);
            this.mlp.buildClassifier(this.getInstances());
        }
        return this.mlp;
    }

    private Instance getInstance(Integer idTurmAlun) throws Exception {
        List<Object[]> listInfo = this.pessoaRepository.getAlunInfo(idTurmAlun);
        if (listInfo.isEmpty()) {
            throw new Exception("Dados não encontrados para classificação");
        }

        Object[] info = listInfo.get(0);

        Instance i = new DenseInstance(20);
        i.setDataset(ins);
        i.setValue(0, this.getGrauEscolaridade((String) info[0]));
        i.setValue(1, this.getGrauEscolaridade((String) info[1]));
        i.setValue(2, info[2] == null ? 9 : ((BigDecimal) info[2]).intValue());
        i.setValue(3, Integer.parseInt(((Character) info[3]).toString()));
        i.setValue(4, Integer.parseInt(((Character) info[4]).toString()));
        i.setValue(5, info[5] == null ? 0 : Integer.parseInt(((Character) info[5]).toString()));
        i.setValue(6, ((String) info[6]));
        i.setValue(7, info[7] == null ? 0 : 1);
        i.setValue(8, Integer.parseInt(((Character) info[8]).toString()));
        i.setValue(9, 'S' == ((Character) info[9]) ? 1 : 0);
        i.setValue(10, 'S' == ((Character) info[10]) ? 1 : 0);
        i.setValue(11, "FEMININO".equals(((String) info[11])) ? 'F' : 'M');

        // Calcula percentual de frequencia
        Double qtdFreq = ((BigDecimal) info[12]).doubleValue();
        Double qtdPres = ((BigDecimal) info[13]).doubleValue();
        Double percent = (qtdPres * 100) / qtdFreq;
        i.setValue(12, percent);

        i.setValue(13, ((BigDecimal) info[14]).doubleValue());
        i.setValue(14, ((BigDecimal) info[15]).doubleValue());
        i.setValue(15, ((BigDecimal) info[16]).doubleValue());
        i.setValue(16, ((BigDecimal) info[17]).doubleValue());
        i.setValue(17, ((BigDecimal) info[18]).doubleValue());
        i.setValue(18, 1087);

        return i;
    }

    public List<String> classify(Integer idTurmAlun) throws Exception {
        this.mlp = (MultilayerPerceptron) this.getClassifier();
        Instance is = this.getInstance(idTurmAlun);
//        double clazz = mlp.classifyInstance(i);
//        double percent[] = mlp.distributionForInstance(i);
//        DoubleSummaryStatistics stat = Arrays.stream(percent).summaryStatistics();
//
//        System.out.println(clazz);
//        System.out.println(Arrays.toString(percent));
//        System.out.println(stat.getMax());
        double results[] = this.mlp.distributionForInstance(is);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            list.add(this.formatPercent(results[i], 6));
        }
        return list;
    }

    public Integer getGrauEscolaridade(String escolaridade) {
        if (null == escolaridade) {
            return 0;
        } else {
            switch (escolaridade) {
                case "NENHUM":
                    return 0;
                case "FUNDAMENTAL COMPLETO":
                    return 1;
                case "ENSINO MÉDIO":
                case "ENSINO MÉDIO  - NORMAL / MAGISTÉRIO ESPECIFICO INDÍGENA":
                case "ENSINO MÉDIO  - NORMAL / MAGISTÉRIO":
                    return 2;
                case "DOUTORADO":
                case "MESTRADO":
                case "ESPECIALIZAÇÃO":
                case "SUPERIOR COMPLETO":
                    return 3;
                default:
                    return 0;
            }
        }
    }

    public String formatPercent(double done, int digits) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ROOT);
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat percentFormat = new DecimalFormat("0.0", otherSymbols);
        percentFormat.setDecimalSeparatorAlwaysShown(false);
        percentFormat.setMinimumFractionDigits(digits);
        percentFormat.setMaximumFractionDigits(digits);
        return percentFormat.format(done);
    }
}
