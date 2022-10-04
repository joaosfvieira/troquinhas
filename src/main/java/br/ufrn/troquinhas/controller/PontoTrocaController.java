package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Contato;
import br.ufrn.troquinhas.model.PontoTroca;
import br.ufrn.troquinhas.service.PontoTrocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/pontotroca")
@Controller
public class PontoTrocaController {
    @Autowired
    PontoTrocaService pontoTrocaService;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("pontotroca", new PontoTroca());
        return "ponto-troca/formPontoTroca";
    }

    @RequestMapping("/addPontoTroca")
    public String addPontoTroca(@ModelAttribute("pontotroca") PontoTroca pontoTroca, Model model){
        PontoTroca novoPontoTroca = pontoTrocaService.addPontoTroca(pontoTroca);
        model.addAttribute("pontotroca", novoPontoTroca);
        return "redirect:/pontotroca/listaPontoTrocas";
    }

    @RequestMapping("/getPontoTrocaById/{id}")
    public String getPontoTrocaById(@PathVariable Integer id){
        Optional<PontoTroca> p = pontoTrocaService.getPontoTrocaById(id);
        return "ponto-troca/paginaPontoTroca";
    }

    @RequestMapping("/listaPontoTrocas")
    public String getAllPontoTroca(Model model){
        List<PontoTroca> listaPontoTrocas = pontoTrocaService.getAllPontoTrocas();
        model.addAttribute("listaPontoTrocas", listaPontoTrocas);
        return "ponto-troca/listaPontoTrocas";
    }

    @RequestMapping("/removePontoTroca/{id}")
    public String removePontoTroca(@PathVariable Integer id){
        pontoTrocaService.removePontoTroca(id);
        return "redirect:/pontotroca/listaPontoTrocas";
    };

//    @RequestMapping("/{id}")
//    public void atualizaPontoTroca(@RequestBody PontoTroca p){ pontoTrocaService.atualizaPontoTroca(p); };
}

