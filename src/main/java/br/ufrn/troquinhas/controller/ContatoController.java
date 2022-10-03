package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Contato;
import br.ufrn.troquinhas.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contato")
@Controller
public class ContatoController {
    @Autowired
    ContatoService contatoService;

    @PostMapping("/add")
    public Contato addContato(@RequestBody Contato c){ return contatoService.addContato(c); }

    @GetMapping("/{id}")
    public Contato getContatoById(@PathVariable Integer id){
        Contato c = contatoService.getContatoById(id).getBody();
        return c;
    }

    @GetMapping("/list")
    public List<Contato> getAllContatos(){ return contatoService.getAllContatos(); }

    @DeleteMapping("/{id}")
    public void removeContato(@PathVariable Integer id){ contatoService.removeContato(id); };

    @PutMapping("/{id}")
    public void atualizaContato(@RequestBody Contato c){ contatoService.atualizaContato(c); };
}

