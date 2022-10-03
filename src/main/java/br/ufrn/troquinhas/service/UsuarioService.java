package br.ufrn.troquinhas.service;

import br.ufrn.troquinhas.model.Usuario;
import br.ufrn.troquinhas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario addUsuario(Usuario u){ return usuarioRepository.save(u); };

    public Optional<Usuario> getUsuarioById(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    };

    public List<Usuario> getAllUsuarios(){ return usuarioRepository.findAll(); }

    public void removeUsuario(Integer id){ usuarioRepository.deleteById(id); }

    public Usuario atualizaUsuario(Usuario u){ return usuarioRepository.save(u); }
}
