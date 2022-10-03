package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Usuario;
import br.ufrn.troquinhas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/addUsuario")
    public String addUsuario(@ModelAttribute("usuario") Usuario usuario, Model model){
        Usuario novoUsuario = usuarioService.addUsuario(usuario);
        model.addAttribute("usuario", novoUsuario);
        return "usuario/listaUsuarios"; }

    @RequestMapping("/getUsuarioById/{id}")
    public String getUsuarioById(@PathVariable Integer id, Model model){
        Optional<Usuario> u = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", u);
        return "usuario/paginaUsuario";
    }

    @RequestMapping("/listaUsuario")
    public List<Usuario> getAllUsuarios(){ return usuarioService.getAllUsuarios(); }

    @RequestMapping("/removeUsuario/{id}")
    public String removeUsuario(@PathVariable Integer id){
        usuarioService.removeUsuario(id);
        return "usuario/listaUsuarios";
    };

//    @RequestMapping("/{id}")
//    public void atualizaUsuario(@RequestBody Usuario u){ usuarioService.atualizaUsuario(u); };
}
