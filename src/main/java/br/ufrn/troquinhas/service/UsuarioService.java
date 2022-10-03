package br.ufrn.troquinhas.service;

import br.ufrn.troquinhas.model.Colecionador;
import br.ufrn.troquinhas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Colecionador addUsuario(Colecionador u){ return usuarioRepository.save(u); };

    public Optional<Colecionador> getUsuarioById(Integer id){
        Optional<Colecionador> colecionador = usuarioRepository.findById(id);
        return colecionador;
    };

    public List<Colecionador> getAllUsuarios(){ return usuarioRepository.findAll(); }

    public void removeUsuario(Integer id){ usuarioRepository.deleteById(id); }

    public Colecionador atualizaUsuario(Colecionador u){ return usuarioRepository.save(u); }
}