/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.MensagemUsuario;
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
public interface MensagemUsuarioRepository extends JpaRepository<MensagemUsuario, Integer> {
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT obj FROM Frequencia obj WHERE obj.notaTrimestral.turmAlun.codTurmAlun = :idUsuario GROUP BY obj.notaTrimestral.periodo.numPeriodo, obj.pauta.dataPauta ORDER BY obj.notaTrimestral.periodo.numPeriodo, obj.pauta.dataPauta")
    public List<MensagemUsuario> findMensagemByUsuario(@Param("idUsuario") Integer idUsuario);

}
