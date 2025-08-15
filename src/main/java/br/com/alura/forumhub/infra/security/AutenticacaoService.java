package br.com.alura.forumhub.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.forumhub.model.usuario.Usuario;
import br.com.alura.forumhub.repository.usuario.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     return usuarioRepository.findByLogin(username);
    // }   
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByLogin(username);
    if (usuario == null) {
        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
    return usuario;
}


}
