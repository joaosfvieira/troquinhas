package br.ufrn.troquinhas.controller;

import br.ufrn.troquinhas.model.Figurinha;
import br.ufrn.troquinhas.model.Colecionador;
import br.ufrn.troquinhas.service.FigurinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/figurinha")
@Controller
public class FigurinhaController {
    @Autowired
    FigurinhaService figurinhaService;

    @PostMapping("/add")
    public Figurinha addFigurinha(@RequestBody Figurinha f){ return figurinhaService.addFigurinha(f); }

    @GetMapping("/{id}")
    public Figurinha getFigurinhaById(@PathVariable Integer id){
        Figurinha f = figurinhaService.getFigurinhaById(id).getBody();
        return f;
    }

    @GetMapping("/list")
    public List<Figurinha> getAllFigurinhas(){ return figurinhaService.getAllFigurinhas(); }

    @DeleteMapping("/{id}")
    public void removeFigurinha(@PathVariable Integer id){ figurinhaService.removeFigurinha(id); };

    @PutMapping("/{id}")
    public void atualizaFigurinha(@RequestBody Figurinha f){ figurinhaService.atualizaFigurinha(f); };
}

