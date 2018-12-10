/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.tests.repository;

import br.edu.ifes.app.educ.repository.FrequenciaRepository;
import java.util.List;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author fernando
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class FrequenciaRepositoryIntegrationTest {

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    @Test
    public void findFrequencia() {
        List<?> listFreq = frequenciaRepository.findByTurmAlunId(1);

        for (int i=0; i<listFreq.size(); i++) {
            System.out.println(listFreq.get(i));
        }
        
        assertThat(listFreq).isEmpty();
    }

}
