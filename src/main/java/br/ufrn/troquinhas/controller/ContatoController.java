package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Contato;
import br.ufrn.troquinhas.model.Figurinha;
import br.ufrn.troquinhas.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/contato")
@Controller
public class ContatoController {
    @Autowired
    ContatoService contatoService;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("contato", new Contato());
        return "contato/formContato";
    }

    @RequestMapping("/addContato")
    public String addContato(@ModelAttribute("contato") Contato contato, Model model){
        Contato novoContato = contatoService.addContato(contato);
        model.addAttribute("contato", contato);
        return "redirect:/contato/listaContatos";
    }

    @RequestMapping("/getContatoById/{id}")
    public String getContatoById(@PathVariable Integer id, Model model){
        Optional<Contato> c = contatoService.getContatoById(id);
        return "contato/paginaContato";
    }

    @RequestMapping("/listaContatos")
    public String getAllContatos(Model model){
        List<Contato> listaContatos = contatoService.getAllContatos();
        model.addAttribute("contatos", listaContatos);
        return "contato/listaContatos";
    }

    @RequestMapping("/removeContato/{id}")
    public String removeContato(@PathVariable Integer id){
        contatoService.removeContato(id);
        return "redirect:/contato/listaContatos";
    };

//    @RequestMapping("/{id}")
//    public void atualizaContato(@RequestBody Contato c){ contatoService.atualizaContato(c); };
}

