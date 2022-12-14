package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Colecionador;
import br.ufrn.troquinhas.model.PontoTroca;
import br.ufrn.troquinhas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/")
    public String redirectToIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String showIndex(Model model){
        List<Colecionador> listaColecionadores1 = usuarioService.getAllColecionadoresWherePontoTrocaIdEqualsId(1);
        List<Colecionador> listaColecionadores2 = usuarioService.getAllColecionadoresWherePontoTrocaIdEqualsId(2);
        model.addAttribute("listaColecionadores1", listaColecionadores1);
        model.addAttribute("listaColecionadores2", listaColecionadores2);
        return "index";
    }
}
