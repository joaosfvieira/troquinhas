package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Colecionador;
import br.ufrn.troquinhas.model.Figurinha;
import br.ufrn.troquinhas.service.FigurinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/figurinha")
@Controller
public class FigurinhaController {
    @Autowired
    FigurinhaService figurinhaService;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("figurinha", new Figurinha());
        return "figurinha/formFigurinha";
    }

    @RequestMapping("/addFigurinha")
    public String addFigurinha(@ModelAttribute("figurinha") Figurinha figurinha, Model model){
        Figurinha novaFigurinha = figurinhaService.addFigurinha(figurinha);
        model.addAttribute("figurinha", figurinha);
        return "redirect:/figurinha/listaFigurinhas";
    }

    @RequestMapping("/getFigurinhaById/{id}")
    public String getFigurinhaById(@PathVariable Integer id, Model model){
        Optional<Figurinha> f = figurinhaService.getFigurinhaById(id);
        model.addAttribute("figurinha", f);
        return "figurinha/paginaFigurinha";
    }

    @RequestMapping("/listaFigurinhas")
    public String getAllFigurinhas(Model model){
        List<Figurinha> figurinhas = figurinhaService.getAllFigurinhas();
        model.addAttribute("figurinhas", figurinhas);
        return "figurinha/listaFigurinhas";
    }

    @RequestMapping("/removeFigurinha/{id}")
    public String removeFigurinha(@PathVariable Integer id){
        figurinhaService.removeFigurinha(id);
        return "redirect:/figurinha/listaFigurinhas";
    };

//    @RequestMapping("/{id}")
//    public void atualizaFigurinha(@RequestBody Figurinha f){ figurinhaService.atualizaFigurinha(f); };
}

