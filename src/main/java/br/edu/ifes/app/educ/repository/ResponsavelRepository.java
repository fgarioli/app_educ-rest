/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.Pessoa;
import br.edu.ifes.app.educ.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernando
 */
@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {

//    @Transactional(readOnly = true)
//    @Query("SELECT COUNT() FROM Emprestimo obj WHERE obj.cliente.id = :clienteId ORDER BY obj.id")
//    public Integer findEmprestimos(@Param("clienteId") Integer cliente_id);
    
    @Transactional(readOnly = true)
    Boolean existsByPessoa(Pessoa pessoa);

}
