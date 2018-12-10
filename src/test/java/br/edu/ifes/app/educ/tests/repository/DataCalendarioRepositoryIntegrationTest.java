/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.tests.repository;

import br.edu.ifes.app.educ.model.DataCalendario;
import br.edu.ifes.app.educ.repository.DataCalendarioRepository;
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
public class DataCalendarioRepositoryIntegrationTest {
    
    @Autowired
    private DataCalendarioRepository calendarioRepository;
    
    @Test
    public void findDataCalendarioByAno() {
        List<DataCalendario> listData = calendarioRepository.findDataCalendarioByAno(2018);

        assertThat(listData).isEmpty();
    }
    
}
