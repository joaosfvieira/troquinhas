package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Colecionador;
import br.ufrn.troquinhas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

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
    };

//    @RequestMapping("/{id}")
//    public void atualizaUsuario(@RequestBody Usuario u){ usuarioService.atualizaUsuario(u); };
}
