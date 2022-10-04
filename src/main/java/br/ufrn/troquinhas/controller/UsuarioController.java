package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Colecionador;
import br.ufrn.troquinhas.model.Figurinha;
import br.ufrn.troquinhas.model.PontoTroca;
import br.ufrn.troquinhas.service.PontoTrocaService;
import br.ufrn.troquinhas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.Set;
=======
>>>>>>> 7b99a14c3f1971a6e45cc3a027ca099c0b1d3b07

@RequestMapping("/usuario")
@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PontoTrocaService pontoTrocaService;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("colecionador", new Colecionador());
        return "usuario/formUsuario";
    }

    @RequestMapping("/addUsuario")
    public String addUsuario(@ModelAttribute("usuario") Colecionador colecionador, Model model){
        Colecionador novoUsuario = usuarioService.addUsuario(colecionador);
        model.addAttribute("usuario", novoUsuario);
        return "redirect:/usuario/listaUsuarios"; }

    @RequestMapping("/getUsuarioById/{id}")
    public String getUsuarioById(@PathVariable Integer id, Model model){
        Colecionador c = usuarioService.getUsuarioById(id);
        Set<Figurinha> listaFigurinhasPossuidas = usuarioService.getUsuarioById(id).getFigurinhasPossuidas();
        Set<Figurinha> listaFigurinhasDesejadas = usuarioService.getUsuarioById(id).getFigurinhasDesejadas();
        List<PontoTroca> listaPontoTrocas = pontoTrocaService.getAllPontoTrocas();
        model.addAttribute("pontoTrocas",listaPontoTrocas);
        model.addAttribute("figurinhasPossuidas", listaFigurinhasPossuidas);
        model.addAttribute("figurinhasDesejadas", listaFigurinhasDesejadas);
        model.addAttribute("colecionador", c);
        return "usuario/paginaUsuario";
    }

    @RequestMapping("/listaUsuarios")
    public String getAllUsuarios(Model model){
        List<Colecionador> listaUsuarios = usuarioService.getAllUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuario/listaUsuarios";
    }

    @RequestMapping("/removeUsuario/{id}")
    public String removeUsuario(@PathVariable Integer id){
        usuarioService.removeUsuario(id);
        return "redirect:/usuario/listaUsuarios";
    }

    @RequestMapping("/marcarPresenca/{id}/{idPontoTroca}")
    public String marcarPresenca(@PathVariable("id") Integer id, @PathVariable("idPontoTroca") Integer idPontoTroca) {
        usuarioService.marcarPresenca(id, idPontoTroca);
        return "redirect:/usuario/listaUsuarios";
    }

//    @RequestMapping("/{id}")
//    public void atualizaUsuario(@RequestBody Usuario u){ usuarioService.atualizaUsuario(u); };
}
