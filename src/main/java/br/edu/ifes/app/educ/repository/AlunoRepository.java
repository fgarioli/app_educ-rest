/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.repository;

import br.edu.ifes.app.educ.model.Aluno;
import br.edu.ifes.app.educ.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernando
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
    @Transactional(readOnly = true)
    Boolean existsByPessoa(Pessoa pessoa);
    
}
