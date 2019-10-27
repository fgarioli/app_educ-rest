/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static Classifier mlp;

    private static Instances instances;

    public ClassificationService() {
        Instances ins = this.loadData();
        ClassificationService.instances = ins;
        ClassificationService.mlp = this.realizarTreinamento(ins);
    }

    private Instances loadData() {
        try {
            DataSource ds = new DataSource(getClass().getResourceAsStream("/weka/dados.arff"));
            Instances ins = ds.getDataSet();
            ins.setClassIndex(19);
            return ins;
        } catch (Exception ex) {
            Logger.getLogger(ClassificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Classifier realizarTreinamento(Instances ins) {
        try {
            MultilayerPerceptron mlp = new MultilayerPerceptron();
            mlp.setGUI(false);
            mlp.setAutoBuild(true);
            mlp.setBatchSize("100");
            mlp.setHiddenLayers("o,t,i");
            mlp.setLearningRate(0.6);
            mlp.setMomentum(0.2);
            mlp.setNominalToBinaryFilter(true);
            mlp.setNormalizeAttributes(true);
            mlp.setNormalizeNumericClass(true);
            mlp.setNumDecimalPlaces(2);
            mlp.setTrainingTime(300);
            mlp.setValidationThreshold(20);
            mlp.buildClassifier(ins);

            return mlp;
        } catch (Exception ex) {
            Logger.getLogger(ClassificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Instance getInstance(Integer turmAlunId) {
        Instance i = new DenseInstance(20);
        i.setDataset(ClassificationService.instances);
        i.setValue(0, 1);
        i.setValue(1, 1);
        i.setValue(2, 9);
        i.setValue(3, 0);
        i.setValue(4, 0);
        i.setValue(5, 0);
        i.setValue(6, "EMEB TESTE 1");
        i.setValue(7, 1);
        i.setValue(8, 0);
        i.setValue(9, 1);
        i.setValue(10, 1);
        i.setValue(11, "M");
        i.setValue(12, 80);
        i.setValue(13, 85);
        i.setValue(14, 75);
        i.setValue(15, 92);
        i.setValue(16, 89);
        i.setValue(17, 67);
        i.setValue(18, 1087);

        return i;
    }

    public void classificar(Integer turmAlunId) {
        try {
            Instance i = this.getInstance(turmAlunId);
            double clazz = mlp.classifyInstance(i);
            double percent[] = mlp.distributionForInstance(i);
            DoubleSummaryStatistics stat = Arrays.stream(percent).summaryStatistics();

            System.out.println(clazz);
            System.out.println(Arrays.toString(percent));
            System.out.println(stat.getMax());
        } catch (Exception ex) {
            Logger.getLogger(ClassificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
