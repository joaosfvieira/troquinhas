package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.PontoTroca;
import br.ufrn.troquinhas.service.PontoTrocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pontotroca")
@Controller
public class PontoTrocaController {
    @Autowired
    PontoTrocaService pontoTrocaService;

    @RequestMapping("/addPontoTroca")
    public PontoTroca addPontoTroca(@RequestBody PontoTroca p){ return pontoTrocaService.addPontoTroca(p); }

    @RequestMapping("/getPontoTrocaById/{id}")
    public PontoTroca getPontoTrocaById(@PathVariable Integer id){
        PontoTroca p = pontoTrocaService.getPontoTrocaById(id).getBody();
        return p;
    }

    @RequestMapping("/listaPontoTrocas")
    public List<PontoTroca> getAllPontoTroca(){ return pontoTrocaService.getAllPontoTrocas(); }

    @RequestMapping("/removePontoTroca/{id}")
    public void removePontoTroca(@PathVariable Integer id){ pontoTrocaService.removePontoTroca(id); };

//    @RequestMapping("/{id}")
//    public void atualizaPontoTroca(@RequestBody PontoTroca p){ pontoTrocaService.atualizaPontoTroca(p); };
}

