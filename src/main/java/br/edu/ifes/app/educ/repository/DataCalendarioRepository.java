/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.DataCalendario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernando
 */
@Repository
public interface DataCalendarioRepository extends JpaRepository<DataCalendario, Integer> {
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM DataCalendario obj WHERE year(obj.dataCale) = :ano ORDER BY obj.dataCale")
    public List<DataCalendario> findDataCalendarioByAno(@Param("ano") Integer ano);

}
