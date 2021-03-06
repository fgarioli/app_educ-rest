/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.app.educ.service;

import br.edu.ifes.app.educ.dto.UsuarioDTO;
import br.edu.ifes.app.educ.model.Aluno;
import br.edu.ifes.app.educ.model.Responsavel;
import br.edu.ifes.app.educ.model.Usuario;
import br.edu.ifes.app.educ.model.enums.Perfil;
import br.edu.ifes.app.educ.repository.AlunoRepository;
import br.edu.ifes.app.educ.repository.ResponsavelRepository;
import br.edu.ifes.app.educ.repository.UsuarioRepository;
import br.edu.ifes.app.educ.security.UserSS;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(login);
        }
        
        if (responsavelRepository.existsByPessoa(usuario.getPessoa())) {
            List<Responsavel> listResp = responsavelRepository.findByPessoa(usuario.getPessoa());
            
            UsuarioDTO uDto = new UsuarioDTO();
            uDto.setCodUsuario(listResp.get(0).getCodResp());
            uDto.setNomeUsuario(usuario.getPessoa().getNomePess());
            uDto.setPerfil(Perfil.RESPONSAVEL.getDescricao());
            
            return new UserSS(usuario, new HashSet<>(Arrays.asList(Perfil.RESPONSAVEL)), uDto);
        } else if (alunoRepository.existsByPessoa(usuario.getPessoa())) {
            List<Aluno> listAluno = alunoRepository.findByPessoa(usuario.getPessoa());
            
            UsuarioDTO uDto = new UsuarioDTO();
            uDto.setCodUsuario(listAluno.get(0).getCodAlun());
            uDto.setNomeUsuario(usuario.getPessoa().getNomePess());
            uDto.setPerfil(Perfil.ALUNO.getDescricao());
            
            return new UserSS(usuario, new HashSet<>(Arrays.asList(Perfil.ALUNO)), uDto);
        }
        
        throw new UsernameNotFoundException(login);
    }
    
}
