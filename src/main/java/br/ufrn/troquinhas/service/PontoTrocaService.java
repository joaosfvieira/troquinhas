package br.ufrn.troquinhas.service;

import br.ufrn.troquinhas.model.PontoTroca;
import br.ufrn.troquinhas.repository.PontoTrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoTrocaService {
    @Autowired
    PontoTrocaRepository pontoTrocaRepository;

    public PontoTroca addPontoTroca(PontoTroca p){ return pontoTrocaRepository.save(p); };

    public Optional<PontoTroca> getPontoTrocaById(Integer id){
        Optional<PontoTroca> pontoTroca = pontoTrocaRepository.findById(id);
        return pontoTroca;
    };

    public List<PontoTroca> getAllPontoTrocas(){ return pontoTrocaRepository.findAll(); }

    public void removePontoTroca(Integer id){ pontoTrocaRepository.deleteById(id); }

    public PontoTroca atualizaPontoTroca(PontoTroca p){ return pontoTrocaRepository.save(p); }
}
